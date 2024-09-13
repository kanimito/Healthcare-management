package com.it.study.service;

import com.it.study.domain.dto.DrugDTO;

import java.util.List;

public interface DrugService {
  List<DrugDTO> selectDrug(Integer rid);

  void updateOrderStatus(Integer doId);
}
