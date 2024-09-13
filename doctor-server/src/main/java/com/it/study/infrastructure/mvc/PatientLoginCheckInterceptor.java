package com.it.study.infrastructure.mvc;

import com.it.study.util.JedisUtil;
import com.it.study.util.JwtUtil;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.infrastructure.mvc @Author: kanimito @CreateTime: 2024-08-19 14:32 @Description:
 * TODO @Version: 1.0
 */
@Log4j
public class PatientLoginCheckInterceptor implements HandlerInterceptor {
  @Autowired private JedisUtil jedisUtil;
  @Autowired private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws IOException {
        String token = request.getHeader("X-Token");
        log.info("X-token:" + token);
        log.info("jwtUtil:" + jwtUtil);
        log.info("jedisUtil:" + jedisUtil);
        log.info("handler:" +handler);
        if (token == null) {
//            response.getWriter().write("token为空");
            return true;
        }
        return true;
  }
}
