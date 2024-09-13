package com.it.study.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.study.common.SetParam;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study.util @Author:
 * kanimito @CreateTime: 2024-08-16 11:39 @Description: TODO @Version: 1.0
 */
public class JedisUtil {

  private final JedisPool jedisPool;
  private final ObjectMapper objectMapper;

  public JedisUtil(String host, Integer port, JedisPool jedisPool) {

    this.jedisPool = jedisPool;
    this.objectMapper = new ObjectMapper();
  }

  // 从Redis中获取值
  public <T> T get(String key, Class<T> clazz) throws IOException {
    try (Jedis jedis = jedisPool.getResource()) { // 使用try-with-resources
      String value = jedis.get(key);
      return objectMapper.readValue(value, clazz);
    }
  }

  public long getEx(String key) {
    try (Jedis jedis = jedisPool.getResource()) { // 使用try-with-resources
      return jedis.ttl(key);
    }
  }

  // 将值存入Redis(可覆盖)
  public void set(String key, Object value) throws JsonProcessingException {
    try (Jedis jedis = jedisPool.getResource()) { // 使用try-with-resources
      String json = objectMapper.writeValueAsString(value);
      jedis.set(key, json);
    }
  }

  // 将值存入Redis(带过期时间，覆盖)
  public void setExpire(String key, Object value, long time) throws JsonProcessingException {
    try (Jedis jedis = jedisPool.getResource()) { // 使用try-with-resources
      String json = objectMapper.writeValueAsString(value);
      jedis.set(key, json, "xx", "ex", time);
    }
  }

  // 将值存入Redis(带过期时间，不存在才存)
  public void set(String key, Object value, long expire) throws JsonProcessingException {
    try (Jedis jedis = jedisPool.getResource()) { // 使用try-with-resources
      String json = objectMapper.writeValueAsString(value);
      jedis.set(key, json, "nx", "ex", expire);
    }
  }

  public long del(String... key) {
    try (Jedis jedis = jedisPool.getResource()) { // 使用try-with-resources
      return jedis.del(key);
    }
  }
}
