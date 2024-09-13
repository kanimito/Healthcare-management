package com.it.study.mapper;

import com.it.study.domain.dto.RegistationDTO;
import com.it.study.domain.entity.Register;
import org.apache.ibatis.annotations.Select;
import com.it.study.domain.entity.Drugs;
import java.util.List;

/**
* @author 31344
* @description 针对表【register】的数据库操作Mapper
* @createDate 2024-08-21 15:38:57
* @Entity com.it.study.domain.entity.Register
*/
public interface RegisterMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);


//    @Select("SELECT DISTINCT reg.rg_num, reg.p_patient_id, reg.p_name, reg.p_sex, reg.p_age, su.username " +
//            "FROM register reg " +
//            "JOIN shift_time se ON reg.shift_id = se.shift_id " +
//            "JOIN shift st ON se.shift_id = st.shift_id " +
//            "JOIN sys_users su ON st.d_id = su.id " +
//            "WHERE reg.rg_status = '0'")

    List<Register> selectPatientPage(Integer id);

    List<Register> huizhen(Integer id);
    List<Register> searchAllByPPatientIdRegister(String patientId);

    Boolean jiaohao(Integer id);

    List<RegistationDTO> selectAllPatientRecord();
}
