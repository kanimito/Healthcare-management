package com.it.study.service.impl;

import com.it.study.domain.entity.Recipel;
import com.it.study.mapper.RecipelMapper;
import com.it.study.service.DoctorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorRecordServiceImpl implements DoctorRecordService {

  @Autowired private RecipelMapper recipelMapper;

  @Override
  public List<Recipel> selectAllDoctorRecord() {
    return recipelMapper.selectAllDoctorRecord();
  }
}
