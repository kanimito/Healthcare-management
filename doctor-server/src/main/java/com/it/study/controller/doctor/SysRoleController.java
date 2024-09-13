package com.it.study.controller.doctor;

import com.it.study.common.Result;
import com.it.study.domain.entity.SysRoles;
import com.it.study.domain.entity.SysUserRoles;
import com.it.study.service.SysRoleService;

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
 * kanimito @CreateTime: 2024-08-16 08:04 @Description: TODO 后台角色管理 @Version: 1.0
 */
@RestController
@RequestMapping("/doctor/role")
@Log4j
public class SysRoleController {
  @Autowired private SysRoleService sysRoleService;

  @GetMapping("/list")
  public Result selectRoles() {
    List<SysRoles> sysRoles = sysRoleService.selectRoles();
    return Result.ok(sysRoles);
  }

  @PostMapping("/addUserRole")
  public Result addUserRole(@RequestBody SysUserRoles sysUserRoles) {
    log.info("roleId:" + sysUserRoles.getRoleId());
    sysRoleService.insertUserRole(sysUserRoles);
    return Result.ok("添加成功");
  }

  @PostMapping("/add")
  public Result addRole(@RequestBody SysRoles sysRoles) {
    sysRoleService.insertRole(sysRoles);
    return Result.ok("添加成功");
  }

  @GetMapping("/get")
  public Result getRole(@RequestParam("id") Integer id) {
    SysRoles sysRoles = sysRoleService.selectRoleById(id);
    return Result.ok(sysRoles);
  }

  @PostMapping("/update")
  public Result updateRole(@RequestBody SysRoles sysRoles) {
    sysRoleService.updateRole(sysRoles);
    return Result.ok("修改成功");
  }

  @GetMapping("/delete")
  public Result deleteRole(@RequestParam("id") Integer id) {
    sysRoleService.deleteRole(id);
    return Result.ok("删除成功");
  }
}
