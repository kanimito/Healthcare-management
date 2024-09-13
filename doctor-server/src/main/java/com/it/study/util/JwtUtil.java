package com.it.study.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.*;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study.util @Author:
 * kanimito @CreateTime: 2024-08-13 11:03 @Description: TODO JTW令牌工具类 @Version: 1.0
 */
public class JwtUtil {
  /** 数字签名秘钥 */
  private String sighSecret = "";

  /** 令牌过期时间,默认30分钟 */
  @Getter private long expire = 30 * 60l;

  public JwtUtil(String secret, long expire) {
    this.sighSecret = secret;
    this.expire = expire;
  }

  public JwtUtil(String secret) {
    this.sighSecret = secret;
  }

  /** 生成令牌 */
  public String generateToken(String tid) {
    String token =
        Jwts.builder()
            // 主题
            .setSubject("login")
            // 设置令牌id,唯一的,建议用UUID
            .setId(tid)
            // 令牌签发时间
            .setIssuedAt(new Date())
            // 设置过期时间(一天)
            //                .setExpiration(new Date(System.currentTimeMillis() +24 * 60 * 60 *
            // 1000))
            .signWith(
                // 加密秘钥
                Keys.hmacShaKeyFor(this.sighSecret.getBytes()),
                // 加密算法
                SignatureAlgorithm.HS256)
            // 生成令牌
            .compact();
    return token;
  }

  //    public static void main(String[] args) {
  //        String secret = "+ipyyYc4MQiwZJtrtHTIHs7fyvR0wf5uwGDVV4pHwSU=";
  //        System.out.println(secret.length());
  //        JwtUtil jwtUtil = new JwtUtil(secret);
  //        UUID uuid = UUID.randomUUID();
  //        String tid = uuid. toString();
  //        System.out.println(jwtUtil.generateToken(tid));
  //    }

  /** 返回令牌的ID值 */
  public String parseToken(String token) {
    if (!StringUtils.hasText(token)) {
      throw new IllegalArgumentException("令牌不能为空!");
    }
    return Jwts.parserBuilder()
        // 设置验证令牌的秘钥
        .setSigningKey(Keys.hmacShaKeyFor(this.sighSecret.getBytes()))
        // 创建了令牌解析器
        .build()
        // 校验令牌
        .parseClaimsJws(token)
        .getBody()
        // 拿到令牌的Id(UUID)
        .getId();
  }
}
