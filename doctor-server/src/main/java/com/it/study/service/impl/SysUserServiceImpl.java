package com.it.study.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.SysUserRoles;
import com.it.study.domain.entity.SysUsers;
import com.it.study.domain.request.UserRequest;
import com.it.study.infrastructure.system.SystemGlobalStore;
import com.it.study.mapper.SysUserRolesMapper;
import com.it.study.mapper.SysUsersMapper;
import com.it.study.service.SysUserService;
import com.it.study.util.JedisUtil;
import com.it.study.util.JwtUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-study @BelongsPackage: com.it.study.service.impl @Author:
 * kanimito @CreateTime: 2024-07-31 15:41 @Description: TODO @Version: 1.0
 */
@Log4j
@Service
public class SysUserServiceImpl implements SysUserService {
  @Autowired private SysUsersMapper sysUsersMapper;
  @Autowired private SysUserRolesMapper sysUserRolesMapper;
  @Autowired private JwtUtil jwtUtil;
  @Autowired private JedisUtil jedisUtil;

  @Override
  public String login(UserRequest user) {
    log.info(StringUtils.hasText(user.getVerifyCode()));
    //        if (!StringUtils.hasText(user.getVerifyCode())){
    //            throw new IllegalArgumentException("验证码不正确！");
    //        }
    if (!StringUtils.hasText(user.getUsername()) || !StringUtils.hasText(user.getPassword())) {
      throw new IllegalArgumentException("用户名或者密码不正确！");
    }

    SysUsers login = sysUsersMapper.selectByUsername(user.getUsername());
    log.info(login.getUsername());
    if (login == null) {
      throw new NullPointerException("用户名不存在！");
    }
    if (!user.getPassword().equals(login.getPassword())) {
      throw new BusinessException(CodeEnum.BusinessError, "密码不正确");
    }
    // 设置session会话
    //        WebMvcUtil.setSessionValue(SystemConst.LoginUser,login);
    // 生成唯一的令牌ID
    String tid = UUID.randomUUID().toString().replaceAll("-", "");
    String token = jwtUtil.generateToken(tid);
    //        SystemGlobalStore.setAttr(tid,login);
    // todo 将用户数据保存到Redis当中
    try {
      Date currentDate = new Date();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      calendar.add(Calendar.MINUTE, Math.toIntExact(jwtUtil.getExpire() / 60));
      Date calendarTime = calendar.getTime();
      login.setExpired(calendarTime);
      jedisUtil.set(tid, login, jwtUtil.getExpire());
    } catch (JsonProcessingException e) {
      log.error(e.getMessage());
      throw new BusinessException(CodeEnum.SystemError);
    }

    return token;
  }

  @Override
  public void logout(String token) {
    try {
      String tid = jwtUtil.parseToken(token);
      SystemGlobalStore.removeAttr(tid);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new BusinessException(CodeEnum.NotAuthorization);
    }
  }

  @Override
  public Page<SysUserRoles> userList() {
    //        Page<SysUsers> sysUsers = sysUsersMapper.selectPageAllUser();
    Page<SysUserRoles> sysUserRoles = sysUserRolesMapper.selectUsersWithRoles();
    return sysUserRoles;
  }

  @Override
  public void updateUser(SysUsers sysUsers) {
    int i = sysUsersMapper.updateByPrimaryKey(sysUsers);
    if (i < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public void addUser(SysUsers sysUsers) {
    int insert = sysUsersMapper.insert(sysUsers);
    if (insert < 1) {
      throw new BusinessException(CodeEnum.UpdateError, "添加失败");
    }
  }

  @Override
  public void deleteUser(Integer id) {
    int i = sysUsersMapper.deleteByPrimaryKey(id);
    if (i < 1) {
      throw new BusinessException(CodeEnum.UpdateError, "删除失败");
    }
  }

  @Override
  public Page<SysUsers> getByUserCode(String userCode) {
    Page<SysUsers> sysUsers = sysUsersMapper.selectByUserCode(userCode);
    if (sysUsers == null) {
      throw new BusinessException(CodeEnum.UpdateError, "用户不存在");
    }
    return sysUsers;
  }

  @Override
  public List<SysUsers> getDoctorListByDId(Integer dId) {
    List<SysUsers> doctorListByDId = sysUsersMapper.getDoctorListByDId(dId);
    if (doctorListByDId == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return doctorListByDId;
  }

  @Override
  public List<SysUsers> getDoctorListAll() {
    List<SysUsers> doctorListAll = sysUsersMapper.getDoctorListAll();
    if (doctorListAll == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return doctorListAll;
  }
  public List<SysUsers> selectAllDoctors() {
    return sysUsersMapper.selectAllDoctors();
  }
}
