package com.it.study.mapper;

import com.it.study.domain.entity.Recipel;
import com.it.study.domain.request.BuQuanYiZhuRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 31344
* @description 针对表【recipel(处方表)】的数据库操作Mapper
* @createDate 2024-09-07 10:57:13
* @Entity com.it.study.domain.entity.Recipel
*/
public interface RecipelMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Recipel record);

    int insertSelective(Recipel record);

    Recipel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Recipel record);

    int updateByPrimaryKey(Recipel record);

    Boolean AddYiZhu(@Param("rgNum") Integer rgNum,
            @Param("pName") String pName,
            @Param("pPatitentId") String pPatitentId,
            @Param("rAdvice") String rAdvice);

  List<Recipel> selectAllDoctorRecord();
    Boolean buquanyizhu(@Param("rgNum") Integer rgNum,
                        @Param("dDoctorId") Integer dDoctorId,
                        @Param("dName") String dName,
                        @Param("doId") Integer doId);
  List<Recipel> selectAllByDateAndUser(
      @Param("patientId") String patientId, @Param("selDate") String selDate);


//  int dingdanid();
}

