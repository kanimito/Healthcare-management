package com.it.study.mapper;

import com.it.study.domain.entity.Shift;
import com.it.study.domain.request.PaiBanRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【shift(排班表)】的数据库操作Mapper
 * @createDate 2024-08-21 10:00:25 @Entity com.it.study.domain.entity.Shift
 */
public interface ShiftMapper {

  int deleteByPrimaryKey(Long id);

  int insert(Shift record);

  int insertSelective(Shift record);

  Shift selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(Shift record);

    List<Shift> seepaiban();

  int updateByPrimaryKey(Shift record);

  List<Shift> shiftList();

  int insertShift(PaiBanRequest shift);

  int shiftTime(@Param("time") Integer time, @Param("shiftId") Integer shiftId);

  //    Integer getLatestShiftId();

}
