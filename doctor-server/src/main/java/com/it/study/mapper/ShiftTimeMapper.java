package com.it.study.mapper;

import com.it.study.domain.dto.ShiftDTO;
import com.it.study.domain.entity.ShiftTime;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【shift_time(排班时间表)】的数据库操作Mapper
 * @createDate 2024-08-21 10:00:25 @Entity com.it.study.domain.entity.ShiftTime
 */
public interface ShiftTimeMapper {

  int deleteByPrimaryKey(Long id);

  int insert(ShiftTime record);

  int insertSelective(ShiftTime record);

  ShiftTime selectByPrimaryKey(Long id);

  ShiftDTO getDoctorByShiftTime(Long shiftTimeId);

  List<ShiftDTO> getDoctorByShiftTimeList(
      @Param("doctorId") Integer doctorId, @Param("date") Date date);

  int updateByPrimaryKeySelective(ShiftTime record);

  int updateByPrimaryKey(ShiftTime record);
}
