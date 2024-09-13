package com.it.study.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-study @BelongsPackage: com.it.study.util @Author:
 * kanimito @CreateTime: 2024-08-01 14:14 @Description: TODO @Version: 1.0
 */
public class WebMvcUtil {
    /**
     * 获取当前请求session对象
     * request请求对象来自于线程局部变量(ThreadLocal)
     * 由DispatcherServlet
     */
    private static final ThreadLocal currentLoginUserHolder = new ThreadLocal();
    private static HttpSession getSession(){

    ServletRequestAttributes requestAttributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (requestAttributes != null) {
      return requestAttributes.getRequest().getSession();
    }
    return null;
  }

  /** 获取session值 */
  public static <T> T getSessionValue(String key) {
    HttpSession session = getSession();
    return (T) session.getAttribute(key);
  }

    /**
     * 设置session值
     */
    public static void setSessionValue(String key,Object value){
        HttpSession session = getSession();
        session.setAttribute(key, value);
    }

    public static <T> T getCurrentUser(){
        return (T) currentLoginUserHolder.get();
    }

    public static void setCurrentUser(Object sysUser){
        currentLoginUserHolder.set(sysUser);
    }
}
