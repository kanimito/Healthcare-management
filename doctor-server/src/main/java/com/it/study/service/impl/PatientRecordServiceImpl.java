package com.it.study.service.impl;

import com.it.study.domain.dto.RegistationDTO;
import com.it.study.domain.entity.Register;
import com.it.study.mapper.RegisterMapper;
import com.it.study.service.PatientRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientRecordServiceImpl implements PatientRecordService {

  @Autowired private RegisterMapper registerMapper;

  @Override
  public List<RegistationDTO> selectAllPatientRecord() {
    List<RegistationDTO> record = registerMapper.selectAllPatientRecord();
    return record;
  }
}
