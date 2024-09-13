package com.it.study.service;

import com.it.study.domain.entity.DrugsOrder;
import com.it.study.domain.entity.DrugsOrderDetail;
import com.it.study.domain.entity.Register;
import com.it.study.domain.entity.Shift;
import com.it.study.domain.request.BuQuanYiZhuRequest;
import com.it.study.domain.request.TiJiaoDetailRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientPage {
    List<Register> selectPatientPage(Integer id);

    List<Register> huizhen(Integer id);

    List<Shift> seepaiban();

    Boolean jiaohao(Integer id);

    Boolean tijiaoyizhu(@Param("rgNum") Integer rgNum,
                        @Param("pName") String pName,
                        @Param("pPatientId") String pPatientId,
                        @Param("rAdvice") String rAdvice);

    Boolean SubmitDrugs(TiJiaoDetailRequest tiJiaoDetailRequest);

//    Boolean buquan(@Param("rgNum") Integer rgNum,
//                   @Param("dDoctorId") Integer dDoctorId,
//                   @Param("dName") String dName,
//                   @Param("doId") Integer doId);
//    int dingdanid();
//
//    Boolean SubmitDrugsdingdan(
//                               @Param("drugsId") Integer drugsId,
//                               @Param("drugsQuantity") Integer drugsQuantity,
//                               @Param("dodCost") double dodCost);
}
