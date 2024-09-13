package com.it.study.mapper;

import com.it.study.domain.entity.Patient;
import com.it.study.domain.entity.SysUsers;
import org.apache.ibatis.annotations.Param;

/**
* @author shiwenguan
* @description 针对表【patient(病人表)】的数据库操作Mapper
* @createDate 2024-08-23 14:36:03
* @Entity com.it.study.domain.entity.Patient
*/
public interface PatientMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Long id);

    Patient selectByUsername(@Param("username") String username);

    int updateByPrimaryKeySelective(Patient record);


    //修改用户信息通过用户名
    int updateByUsernameSelective(Patient patient);

    int updateByPrimaryKey(Patient record);

}
