package com.it.study.controller.admin;

import com.it.study.common.Result;
import com.it.study.service.DoctorRecordService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping(value = "/doctor/admin")
public class DoctorRecordController {

  @Autowired private DoctorRecordService doctorRecordService;

  @GetMapping(value = "/doctor")
  public Result doctorRecord() {
    return Result.ok(doctorRecordService.selectAllDoctorRecord());
  }
}
