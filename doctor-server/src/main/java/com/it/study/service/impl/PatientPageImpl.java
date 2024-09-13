package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.*;
import com.it.study.domain.request.BuQuanYiZhuRequest;
import com.it.study.domain.request.TiJiaoDetailRequest;
import com.it.study.domain.request.TiJiaoOrderDetailRequest;
import com.it.study.mapper.*;
import com.it.study.service.PatientPage;
import com.it.study.util.WebMvcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PatientPageImpl implements PatientPage {

    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private ShiftMapper shiftMapper;
    @Autowired
    private RecipelMapper recipelMapper;
    @Autowired
    private DrugsOrderMapper drugsOrderMapper;


    @Override
    public List<Register> selectPatientPage(Integer id) {
        List<Register> registers=registerMapper.selectPatientPage(id);
        return registers;
    }

    @Override
    public List<Register> huizhen(Integer id) {
        List<Register> huizhen = registerMapper.huizhen(id);
        return huizhen;
    }

    @Override
    public List<Shift> seepaiban() {
        List<Shift>shifts=shiftMapper.seepaiban();
        return shifts;
    }

    @Override
    public Boolean jiaohao(Integer id) {
        Boolean jiaohao = registerMapper.jiaohao(id);
        return jiaohao;
    }

    @Override
    public Boolean tijiaoyizhu(Integer rgNum, String pName, String pPatientId, String rAdvice) {
        Boolean tijiao = recipelMapper.AddYiZhu(rgNum,pName,pPatientId,rAdvice);
        return tijiao;
    }


    @Override
    public Boolean SubmitDrugs(TiJiaoDetailRequest tiJiaoDetailRequest) {
        Boolean aBoolean = drugsOrderMapper.insertOrder(tiJiaoDetailRequest);
        if (!aBoolean){
            throw new BusinessException(CodeEnum.SaveError);
        }
        for (TiJiaoOrderDetailRequest item : tiJiaoDetailRequest.getOrderDetail()) {
            item.setDoId(tiJiaoDetailRequest.getDoId());
            Boolean aBoolean1 = drugsOrderMapper.insertOrderDetails(item);
            if (!aBoolean1){
                throw new BusinessException(CodeEnum.SaveError);
            }
        }
        DrugsOrder drugsOrder = new DrugsOrder();
        drugsOrder.setDoId(tiJiaoDetailRequest.getDoId());
        drugsOrder.setDoStatus(1);
        drugsOrderMapper.updateByPrimaryKeySelective(drugsOrder);

        Register register = new Register();
        register.setRgNum(tiJiaoDetailRequest.getRgNum());
        register.setRgStatus(3);
        int i = registerMapper.updateByPrimaryKeySelective(register);
        return true;
    }

//    @Override
//    public Boolean buquan(Integer rgNum, Integer dDoctorId, String dName, Integer doId) {
//        SysUsers currentUser = WebMvcUtil.getCurrentUser();
//        int did=currentUser.getId();
//        String dname=currentUser.getUsername();
//        int doid=recipelMapper.dingdanid();
//        Boolean buquanyizhu = recipelMapper.buquanyizhu(rgNum,did,dname,doid);
//        return buquanyizhu;
//    }

//    @Override
//    public int dingdanid() {
//       return recipelMapper.dingdanid();
//    }

//
//    @Override
//    public Boolean SubmitDrugsdingdan(Integer drugsId, Integer drugsQuantity, double dodCost) {
//
//        return drugsOrderMapper.insertOrderDetails(doid,drugsId,drugsQuantity,dodCost);
//    }

}
