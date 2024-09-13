package com.it.study.controller.doctor;

import com.github.pagehelper.Page;
import com.it.study.common.Result;
import com.it.study.domain.entity.SysResources;
import com.it.study.service.SysResourceService;
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
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage: com.it.study.controller @Author:
 * kanimito @CreateTime: 2024-08-19 00:37 @Description: TODO 后台资源管理 @Version: 1.0
 */
@RestController
@RequestMapping("/doctor/resource")
@Log4j
public class SysResourceController {
  @Autowired private SysResourceService sysResourceService;

  @GetMapping("/list")
  public Result list() {
    log.info("进入资源管理");
    Page<SysResources> sysResources = sysResourceService.selectResources();
    return Result.ok(sysResources);
  }

  @PostMapping("/add")
  public Result add(@RequestBody SysResources sysResources) {
    sysResourceService.insertResource(sysResources);
    return Result.ok("增加成功");
  }

  @PostMapping("/update")
  public Result update(@RequestBody SysResources sysResources) {
    sysResourceService.updateResource(sysResources);
    return Result.ok("更新成功");
  }

  @GetMapping("/delete")
  public Result delete(@RequestParam("id") Integer id) {
    sysResourceService.deleteResource(id);
    return Result.ok("删除成功");
  }

  @GetMapping("/get")
  public Result get(@RequestParam("id") Integer id) {
    SysResources sysResources = sysResourceService.selectResourceById(id);
    return Result.ok(sysResources);
  }
}
