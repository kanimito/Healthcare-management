package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.dto.ShiftDTO;
import com.it.study.domain.entity.SysUsers;
import com.it.study.mapper.ShiftTimeMapper;
import com.it.study.mapper.SysUsersMapper;
import com.it.study.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.service.impl @Author: kanimito @CreateTime: 2024-08-21 10:12 @Description:
 * TODO @Version: 1.0
 */
@Service
public class DoctorServiceImpl implements DoctorService {
  @Autowired private ShiftTimeMapper shiftTimeMapper;
  @Autowired private SysUsersMapper sysUsersMapper;

  @Override
  public ShiftDTO getDoctorByShiftTime(Long shiftTimeId) {
    ShiftDTO shiftDTO = shiftTimeMapper.getDoctorByShiftTime(shiftTimeId);
    if (shiftDTO == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return shiftDTO;
  }

  @Override
  public List<ShiftDTO> getDoctorByShiftTimeList(Integer doctorId, String selDate)
      throws ParseException {
    //        String dateString = "2024-08-21 10:00:00"; // 你的日期字符串
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = (Date) formatter.parse(selDate);
    List<ShiftDTO> doctorByShiftTimeList = shiftTimeMapper.getDoctorByShiftTimeList(doctorId, date);
    if (doctorByShiftTimeList == null || doctorByShiftTimeList.size() < 1) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return doctorByShiftTimeList;
  }

  @Override
  public SysUsers getDoctor(Integer doctorId) {
    SysUsers sysUsers = sysUsersMapper.selectByPrimaryKey(Long.valueOf(doctorId));
    if (sysUsers == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return sysUsers;
  }
}
