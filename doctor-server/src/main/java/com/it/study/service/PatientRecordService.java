package com.it.study.service;

import com.it.study.domain.dto.RegistationDTO;
import com.it.study.domain.entity.Register;

import java.util.List;

public interface PatientRecordService {
  List<RegistationDTO> selectAllPatientRecord();
}
