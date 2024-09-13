package com.it.study.service;

import com.it.study.domain.entity.Patient;
import com.it.study.domain.request.UserRequest;

public interface PatientService {

    //登录
    String login (UserRequest user);

    //注册
    int register (UserRequest user);

    //个人中心展示
    Patient personalDate (String user);

    //个人中心修改
    int updatePersonalDate(Patient patient);

    //病历卡片
    Patient getCard(String key);
}
