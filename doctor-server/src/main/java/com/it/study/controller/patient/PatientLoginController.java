package com.it.study.controller.patient;

import com.it.study.common.Result;
import com.it.study.domain.entity.Patient;
import com.it.study.domain.request.UserRequest;
import com.it.study.service.PatientService;
import com.it.study.service.SysUserService;
import com.it.study.util.JwtUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.controller.patient @Author: kanimito @CreateTime: 2024-08-19 14:29 @Description:
 * TODO 病人登录 @Version: 1.0
 */
@RestController
@RequestMapping("/patient")
@Log4j
public class PatientLoginController {

    @Autowired
    private JwtUtil jwtUtil;
    @Resource
    private PatientService patientService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserRequest user) {
        log.info("request的参数:" + user);
        String token = patientService.login(user);
        log.info("要响应的令牌:" + token);
        return Result.ok(token);
    }


    //注册
    @PostMapping("/register")
    public Result register(@RequestBody UserRequest user) {
        log.info("request的参数:" + user);
        patientService.register(user);
        return Result.ok();
    }


    //个人中心展示
    @PostMapping("/personalDate")
    public Result personalDate(@RequestHeader("Authorization") String authorizationHeader) {
        // 打印请求中的Authorization头信息
        log.info("Authorization头信息: " + authorizationHeader);
        // 去除前缀 "Bearer " 来获取真正的token
        authorizationHeader = authorizationHeader.substring("Bearer ".length());
        String token = authorizationHeader;

        // 解析token获取用户的tid
        String key = jwtUtil.parseToken(token);
        log.info("解析出的用户信息tid: " + key);

        // 获取用户的个人信息
        Patient patient = patientService.personalDate(key);
        log.info("要响应的个人信息: " + patient);
        return Result.ok(patientService.personalDate(key));
    }

    //个人中心修改
    @PostMapping("/updatePersonalDate")
    public Result updatePersonalDate(@RequestBody Patient patient) {
        log.info("request的参数:" + patient);
        patientService.updatePersonalDate(patient);
        return Result.ok();
    }

    //病历卡片
    @PostMapping("/recipel")
    public Result recipel(@RequestHeader("Authorization") String authorizationHeader) {
        // 打印请求中的Authorization头信息
        log.info("Authorization头信息: " + authorizationHeader);
        // 去除前缀 "Bearer " 来获取真正的token
        authorizationHeader = authorizationHeader.substring("Bearer ".length());
        String token = authorizationHeader;
        // 解析token获取用户的tid
        String key = jwtUtil.parseToken(token);
        log.info("解析出的用户信息tid: " + key);

        // 获取用户的个人信息
        return Result.ok(patientService.getCard(key));
    }
}
