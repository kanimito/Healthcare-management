package com.it.study.controller.doctor;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.study.common.CodeEnum;
import com.it.study.common.PageResult;
import com.it.study.common.Result;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.SysUserRoles;
import com.it.study.domain.entity.SysUsers;
import com.it.study.domain.vo.SysUserVo;
import com.it.study.service.SysUserService;
import com.it.study.util.JedisUtil;
import com.it.study.util.JwtUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study.controller @Author:
 * kanimito @CreateTime: 2024-08-14 11:59 @Description: TODO 后台用户管理 @Version: 1.0
 */
@RestController
@RequestMapping("/doctor/user")
@Log4j
public class SysUserController {
  @Autowired private JwtUtil jwtUtil;
  @Autowired private SysUserService sysUserService;

  @Autowired private JedisUtil jedisUtil;

  @GetMapping(value = "/selectAllDoctors")
  public Result selectAllDoctors() {
    List<SysUsers> sysUsers = sysUserService.selectAllDoctors();
    return Result.ok(sysUsers);
  }

  @GetMapping("/info")
  //    @Permission("system:user:info")
  public Result getInfo(@RequestParam String token) {
    log.info("请求来的token" + token);
    String tid = jwtUtil.parseToken(token);
    log.info("解析出来的tid" + tid);
    //        SysUsers sysUsers = SystemGlobalStore.getAttr(tid);
    SysUsers sysUsers = null;
    try {
      sysUsers = jedisUtil.get(tid, SysUsers.class);
    } catch (IOException e) {
      log.error(e.getMessage());
      throw new BusinessException(CodeEnum.SystemError);
    }
    SysUserVo sysUserVo = new SysUserVo();
    sysUserVo.setUsername(sysUsers.getUsername());
    sysUserVo.setRoles(Arrays.asList(sysUsers.getAccountType()));
    return Result.ok(sysUserVo);
  }

  @GetMapping("/list")
  public PageResult userList(
      @RequestParam(value = "pageNow") Integer pageNow,
      @RequestParam(value = "pageSize") Integer pageSize) {
    log.info("查询用户列表");
    PageHelper.startPage(pageNow, pageSize);
    Page<SysUserRoles> page = sysUserService.userList();
    return PageResult.ok(page, page.getTotal());
  }

  @GetMapping("/get")
  public Result getUser(@RequestParam(value = "id") Integer id) {
    log.info("查询用户信息");
    SysUsers resUser = new SysUsers();
    for (SysUsers user : sysUserService.userList()) {
      if (user.getId().equals(id)) {
        resUser = user;
        break;
      }
    }
    if (resUser == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return Result.ok(resUser);
  }

  @PostMapping("/update")
  public Result update(@RequestBody SysUsers sysUsers) {
    sysUserService.updateUser(sysUsers);
    return Result.ok("更新成功");
  }

  @PostMapping("/add")
  public Result add(@RequestBody SysUsers sysUsers) {
    sysUsers.setAccountType("doctor");
    // 获取当前时间
    LocalDateTime now = LocalDateTime.now();

    // 定义日期格式
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");

    // 将日期转为字符串
    String dateString = now.format(formatter);
    sysUsers.setUserCode(sysUsers.getUsername() + dateString);
    sysUsers.setStatus(1);
    sysUserService.addUser(sysUsers);
    log.info("传过来的增加sysUser:" + sysUsers.toString());
    return Result.ok("添加成功");
  }

  @PostMapping("/delete")
  public Result delete(@RequestBody SysUsers sysUsers) {
    log.info("delete的id:" + sysUsers.getId());
    sysUserService.deleteUser(sysUsers.getId());
    return Result.ok("删除成功");
  }

  @PostMapping("/logout")
  public Result logout(@RequestHeader("X-Token") String token) {
    log.info("用户退出登录------------------------------------------------------");
    // 删除登录信息
    sysUserService.logout(token);
    return Result.ok();
  }

  @GetMapping("/getByUserCode")
  public Result getByUserCode(@RequestParam(value = "userCode") String userCode) {
    Page<SysUsers> sysUsers = sysUserService.getByUserCode(userCode);
    return Result.ok(sysUsers);
  }
}
