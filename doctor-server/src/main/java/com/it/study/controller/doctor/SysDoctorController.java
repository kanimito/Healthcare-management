package com.it.study.controller.doctor;

import com.it.study.common.Result;
import com.it.study.domain.entity.Drugs;
import com.it.study.domain.entity.Register;
import com.it.study.domain.entity.Shift;
import com.it.study.domain.entity.SysUsers;
import com.it.study.domain.request.*;
import com.it.study.service.DrugsList;
import com.it.study.service.PatientPage;
import com.it.study.util.JedisUtil;
import com.it.study.util.JwtUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Log4j
@RestController
@RequestMapping("/doctor/user")
public class SysDoctorController {
    @Autowired
    private DrugsList drugsList;
    @Autowired
    private PatientPage patientPage;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private JedisUtil jedisUtil;
    @PostMapping("/drugslist")
    public Result selectDrugsList(){
        List<Drugs> list = drugsList.selectDrugsList();
        return Result.ok(list);
    }

    @GetMapping("/selectPatientPage")
    public Result selectPatientPage(@RequestHeader("X-Token") String token) throws IOException {
        // 解析token获取用户的tid
        String key = jwtUtil.parseToken(token);
        log.info("解析出的用户信息tid: " + key);
        SysUsers sysUsers = jedisUtil.get(key, SysUsers.class);
        List<Register> list=patientPage.selectPatientPage(sysUsers.getId());
        return Result.ok(list);
    }
    @PostMapping("/huizhen")
    public Result huizhen(@RequestBody HuiZhenRequest huizhen){
        List<Register> list=patientPage.huizhen(huizhen.getId());
        return Result.ok(list);
    }
    @PostMapping("/seepaiban")
    public Result seepaiban(){
        List<Shift>list=patientPage.seepaiban();
        return Result.ok(list);
    }
    @PostMapping("/jiaohao")
    public Result jiaohao(@RequestBody JiaoHaoRequest jiaohao){
        Boolean jiaohao1 = patientPage.jiaohao(jiaohao.getId());
        return Result.ok(jiaohao1);
    }
    @PostMapping("/tijiaoyizhu")
    public Result tijiao(@RequestBody RecDTO recDTO){
        log.info("recDto===="+recDTO);
        Boolean tijiao1 = patientPage.tijiaoyizhu(Integer.valueOf(recDTO.getRgNum()),recDTO.getpPatientId(),recDTO.getpName(),recDTO.getrAdvice());
        return Result.ok(tijiao1);
    }
    @PostMapping("/tijiaodingdan")
    public Result tijiaoorderdetail(@RequestBody TiJiaoDetailRequest tiJiaoDetailRequest){
        Boolean tijiaoorder=
                patientPage.SubmitDrugs(tiJiaoDetailRequest);
//        String pName, String pPatitentId, Integer doStatus, Integer drugsId, Integer drugsQuantity, double doCost, double dodCost
        return Result.ok(true);
    }
//
//    @PostMapping("/buquan")
//    public Result buquanyz(@RequestBody BuQuanYiZhuRequest bq){
//        Boolean buquan = patientPage.buquan(bq.getDDoctorId(), bq.getDoId(),bq.getDName(),bq.getRgNum());
//        return Result.ok(buquan);
//    }
}
