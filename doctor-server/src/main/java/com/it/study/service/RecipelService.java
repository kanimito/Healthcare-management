package com.it.study.service;

import com.it.study.domain.entity.Recipel;

import java.util.List;

public interface RecipelService {
  List<Recipel> selectAllByDateAndUser(String patientId, String selDate);
}
