package com.it.study.controller.admin;

import com.it.study.common.Result;
import com.it.study.domain.entity.Shift;
import com.it.study.domain.request.PaiBanRequest;
import com.it.study.service.ShiftService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@RequestMapping(value = "/doctor/admin")
public class ShiftController {

  @Autowired private ShiftService shiftService;

  @GetMapping(value = "/shiftList")
  public Result shift() {
    return Result.ok(shiftService.shiftList());
  }

  // 排班科室医生日期插入
  @PostMapping(value = "/scheduling")
  public Result scheduling(@RequestBody PaiBanRequest shift) {
    shiftService.insertShift(shift);
    return Result.ok("发布排班信息成功！");
  }

  //    //排班时间段插入
  //    @PostMapping(value = "/shiftTime")
  //    public Result shiftTime(@RequestBody Integer time){
  //        shiftService.shiftTime(time);
  //        return Result.ok("发布排班信息成功！");
  //    }
  //
  //    //排班shift_id插入
  //    @PostMapping(value = "/shiftId")
  //    public Result shiftId(){
  //        Integer latestShiftId = shiftService.getLatestShiftId();
  ////        System.out.println(latestShiftId);
  //        shiftService.shiftTime(latestShiftId);
  //        return Result.ok();
  //    }

}
