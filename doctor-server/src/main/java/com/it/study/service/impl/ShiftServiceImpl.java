package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.Shift;
import com.it.study.domain.request.PaiBanRequest;
import com.it.study.mapper.ShiftMapper;
import com.it.study.service.ShiftService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class ShiftServiceImpl implements ShiftService {

  @Autowired private ShiftMapper shiftMapper;

  @Override
  public List<Shift> shiftList() {
    return shiftMapper.shiftList();
  }

  @Override
  public void insertShift(PaiBanRequest shift) {
    int row = shiftMapper.insertShift(shift);
    log.info(shift.getShiftId());
    //        Integer shiftId = shift.getShiftId();
    shift
        .getShiftTime()
        .forEach(
            item -> {
              item.setShiftId(shift.getShiftId());
              int i = shiftMapper.shiftTime(item.getTime(), item.getShiftId());
              if (i < 1) {
                throw new BusinessException(CodeEnum.Fail);
              }
            });

    if (row < 1) {
      throw new BusinessException(CodeEnum.Fail);
    }
  }
  //
  //    @Override
  //    public void shiftTime(Integer time) {
  //        int row = shiftMapper.shiftTime(time);
  //        if (row < 1){
  //            throw new BusinessException(CodeEnum.Fail);
  //        }
  //    }
  //
  //    @Override
  //    public int getLatestShiftId() {
  //        return shiftMapper.getLatestShiftId();
  //    }

}
