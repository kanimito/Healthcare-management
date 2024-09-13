package com.it.study.controller.admin;

import com.it.study.common.Result;
import com.it.study.domain.dto.RegistationDTO;
import com.it.study.domain.entity.Register;
import com.it.study.service.PatientRecordService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j
@RestController
@RequestMapping(value = "/doctor/admin")
public class PatientRecordController {

  @Autowired private PatientRecordService patientRecordService;

  @GetMapping(value = "/patient")
  public Result patientRecord() {
    List<RegistationDTO> registers = patientRecordService.selectAllPatientRecord();
    return Result.ok(registers);
  }
}
