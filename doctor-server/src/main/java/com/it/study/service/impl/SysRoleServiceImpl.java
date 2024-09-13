package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.SysRoles;
import com.it.study.domain.entity.SysUserRoles;
import com.it.study.mapper.SysRolesMapper;
import com.it.study.mapper.SysUserRolesMapper;
import com.it.study.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study.service.impl @Author:
 * kanimito @CreateTime: 2024-08-16 08:02 @Description: TODO @Version: 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
  @Autowired private SysRolesMapper sysRolesMapper;

  @Autowired private SysUserRolesMapper sysUserRolesMapper;

  @Override
  public List<SysRoles> selectRoles() {
    List<SysRoles> sysRoles = sysRolesMapper.selectRoles();
    if (sysRoles.size() < 1) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return sysRoles;
  }

  @Override
  public void insertUserRole(SysUserRoles sysUserRoles) {
    int i = sysUserRolesMapper.insertUserRoles(sysUserRoles);
    if (i < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public void insertRole(SysRoles sysRoles) {
    int insert = sysRolesMapper.insert(sysRoles);
    if (insert < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public SysRoles selectRoleById(Integer id) {
    SysRoles sysRoles = sysRolesMapper.selectByPrimaryKey(id);
    if (sysRoles == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return sysRoles;
  }

  @Override
  public void updateRole(SysRoles sysRoles) {
    int i = sysRolesMapper.updateByPrimaryKeySelective(sysRoles);
    if (i < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public void deleteRole(Integer id) {
    int i = sysRolesMapper.deleteByPrimaryKey(id);
    if (i < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }
}
