package com.it.study.infrastructure.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.study.common.CodeEnum;
import com.it.study.common.Result;
import com.it.study.common.consts.SystemConst;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.SysUsers;
import com.it.study.util.JedisUtil;
import com.it.study.util.JwtUtil;
import com.it.study.util.WebMvcUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-study @BelongsPackage:
 * com.it.study.infrastructure.mvc @Author: kanimito @CreateTime: 2024-08-01 11:04 @Description:
 * TODO doctor登录拦截器 @Version: 1.0
 */
@Log4j
public class LoginCheckInterceptor implements HandlerInterceptor {
  @Autowired private JedisUtil jedisUtil;
  @Autowired private JwtUtil jwtUtil;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.info("登录拦截器开始工作...");
    String token = request.getHeader("X-Token");
    String tid = null;
    SysUsers sysUsers = null;
    try {
      tid = jwtUtil.parseToken(token);
      sysUsers = jedisUtil.get(tid, SysUsers.class);
      if (sysUsers == null) {
        log.error("登录拦截器检测到用户未登录");
        responseJson(response, Result.fail(CodeEnum.BusinessError));
        return false;
      }
    } catch (Exception e) {
      log.error("登录拦截器检测到异常", e);
      responseJson(response, Result.fail(CodeEnum.BusinessError));
      return false;
    } finally {
      if (tid != null && sysUsers != null) {
        long timeDifferenceInMinutes = jedisUtil.getEx(tid) / 60;
        if (timeDifferenceInMinutes < 15) {
          updateUserTokenExpiry(tid, sysUsers);
        }
      }
    }
    return true;
  }

  private void updateUserTokenExpiry(String tid, SysUsers sysUsers) throws JsonProcessingException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, Math.toIntExact(jwtUtil.getExpire() / 60));
    sysUsers.setExpired(calendar.getTime());
    jedisUtil.setExpire(tid, sysUsers, jwtUtil.getExpire());
  }

  private ObjectMapper objectMapper = new ObjectMapper();

  private void responseJson(HttpServletResponse response, Object data) {
    response.setContentType("application/json;charset=utf-8");
    try {
      String json = objectMapper.writeValueAsString(data);
      response.getWriter().print(json);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
