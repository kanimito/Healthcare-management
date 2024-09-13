package com.it.study;

import com.it.study.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study @Author:
 * kanimito @CreateTime: 2024-08-16 11:13 @Description: TODO @Version: 1.0
 */
public class JedisTest {
  //    @Autowired
  //    private JwtUtil jwtUtil;
  @Test
  public void test() {
    // todo 1.创建连接
    Jedis jedis = new Jedis("192.168.122.101", 6379);

    String set = jedis.set("username", "kanimito");
    System.out.println(set);
  }
}
