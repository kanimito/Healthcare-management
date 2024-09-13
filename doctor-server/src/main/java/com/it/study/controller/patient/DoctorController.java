package com.it.study.controller.patient;

import com.it.study.common.Result;
import com.it.study.domain.dto.ShiftDTO;
import com.it.study.domain.entity.SysUsers;
import com.it.study.service.DoctorService;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.it.study.service.SysUserService;
import com.it.study.service.DoctorService;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.it.study.service.SysUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.controller.patient @Author: kanimito @CreateTime: 2024-08-21 10:10 @Description:
 * TODO @Version: 1.0
 */
@RestController
@RequestMapping("/patient")
@Log4j
public class DoctorController {
  @Autowired private DoctorService doctorService;
  @Autowired private SysUserService sysUserService;

  @GetMapping("/getShiftTimeById")
  public Result getDoctor(Long shiftTimeId) {
    ShiftDTO doctorByShiftTime = doctorService.getDoctorByShiftTime(shiftTimeId);
    return Result.ok(doctorByShiftTime);
  }

  @GetMapping("/getShiftTimeList")
  public Result getDoctorList(Integer doctorId, String selDate) throws ParseException {
    log.info("doctorId:" + doctorId);
    log.info("date:" + selDate);

    List<ShiftDTO> doctorByShiftTimeList =
        doctorService.getDoctorByShiftTimeList(doctorId, selDate);
    return Result.ok(doctorByShiftTimeList);
  }

  @GetMapping("/getDoctorByDoctorId")
  public Result getDoctor(Integer doctorId) {
    return Result.ok(doctorService.getDoctor(doctorId));
  }

  @GetMapping("/getDoctorList")
  public Result getDoctorList(Integer dId) {
    if (dId == 0) {
      List<SysUsers> doctorListAll = sysUserService.getDoctorListAll();
      return Result.ok(doctorListAll);
    }
    List<SysUsers> doctorListByDId = sysUserService.getDoctorListByDId(dId);
    return Result.ok(doctorListByDId);
  }

}
