package com.it.study.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.Patient;
import com.it.study.domain.request.UserRequest;
import com.it.study.mapper.PatientMapper;
import com.it.study.service.PatientService;
import com.it.study.util.JedisUtil;
import com.it.study.util.JwtUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.UUID;

@Log4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public String login(UserRequest user) {
//        log.info(StringUtils.hasText(user.getVerifyCode()));
//        if (!StringUtils.hasText(user.getVerifyCode())){
//            throw new IllegalArgumentException("验证码不正确！");
//        }
        if (!StringUtils.hasText(user.getUsername())
                || !StringUtils.hasText(user.getPassword())){
            throw new IllegalArgumentException("用户名或者密码不正确！");
        }

        Patient login = patientMapper.selectByUsername(user.getUsername());
        log.info("%%%%%%%%"+login);
        if (login == null){
            throw new NullPointerException("用户名不存在！");
        }
        if (!user.getPassword().equals(login.getPPassword())){
            throw new BusinessException(CodeEnum.BusinessError,"密码不正确");
        }
        //设置session会话
//        WebMvcUtil.setSessionValue(SystemConst.LoginUser,login);
        //生成唯一的令牌ID
        String tid = UUID.randomUUID().toString()
                .replaceAll("-","");
        log.info("tid为："+tid);
        String token = jwtUtil.generateToken(tid);
//        SystemGlobalStore.setAttr(tid,login);
        //todo 将用户数据保存到Redis当中
        try {
            jedisUtil.set(tid,login);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new BusinessException(CodeEnum.SystemError);
        }

        return token;

    }

    //注册
    @Override
    public int register(UserRequest user) {
        if (StringUtils.hasText(user.getUsername())
                && StringUtils.hasText(user.getPassword())){
            Patient patient = new Patient();
            patient.setPUsername(user.getUsername());
            patient.setPPassword(user.getPassword());
            return patientMapper.insertSelective(patient);
        }
        return 0;
    }

    //个人中心展示
    @Override
    public Patient personalDate(String key) {
        log.info("要查询的用户tid:" + key);
        //根据传过来的tid获取用户信息
        Patient patient = null;
        try {
            patient = jedisUtil.get(key, Patient.class);
            log.info("从Redis中获取到的用户信息:" + patient);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BusinessException(CodeEnum.SystemError);
        }
        log.info("要响应的个人信息:" + patient);
        return patient;
    }

    //个人中心修改
    @Override
    public int updatePersonalDate(Patient patient) {
        log.info("要修改的个人信息:" + patient);
        if (patient.getPName() == null) {
            // 返回错误信息或抛出异常，停止执行
            throw new IllegalArgumentException("用户名不能为空！！！");
        }
        return patientMapper.updateByUsernameSelective(patient);
    }

    //病历卡片
    @Override
    public Patient getCard(String key) {
        log.info("要查询的用户tid:" + key);
        //根据传过来的tid获取用户信息
        Patient patient = null;
        try {
            patient = jedisUtil.get(key, Patient.class);
            log.info("从Redis中获取到的用户信息:" + patient);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BusinessException(CodeEnum.SystemError);
        }
        log.info("要响应的个人信息:" + patient);
        return patient;
    }
}
