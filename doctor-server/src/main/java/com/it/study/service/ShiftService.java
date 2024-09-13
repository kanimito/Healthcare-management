package com.it.study.service;

import com.it.study.domain.entity.Shift;
import com.it.study.domain.request.PaiBanRequest;

import java.util.List;

public interface ShiftService {
  List<Shift> shiftList();

  void insertShift(PaiBanRequest shift);
  //    void shiftTime(Integer time);
  //
  //    int getLatestShiftId();

}
