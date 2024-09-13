package com.it.study.service;

import com.it.study.domain.entity.Drugs;

import java.util.List;

public interface DrugsService {
  List<Drugs> selectAllDrugs();

  Drugs selectById(Long id);

  void updateDrugs(Drugs drugs);

  void deleteDrugs(Long id);

  void addDrugs(Drugs drugs);
}
