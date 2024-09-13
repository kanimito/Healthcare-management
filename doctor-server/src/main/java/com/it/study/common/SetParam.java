package com.it.study.common;

import redis.clients.jedis.params.Params;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study.common @Author:
 * kanimito @CreateTime: 2024-08-16 16:19 @Description: TODO @Version: 1.0
 */
public abstract class SetParam extends Params {
  public static final String XX = "xx"; // 只在键已经存在时，才对键进行设置操作
  public static final String NX = "nx"; // 只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value
  public static final String PX =
      "px"; // 设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond
  // value
  public static final String EX =
      "ex"; // 设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value
  public static final String EXAT = "exat"; // 设置以秒为单位的UNIX时间戳所对应的时间为过期时间
  public static final String PXAT = "pxat"; // 设置毫秒为单位的UNIX时间戳所对应的时间为过期时间
  public static final String KEEPTTL = "keepttl"; // 保留设置前已指定的键的生存时间
  public static final String GET = "get"; // 返回指定键原本的值，若键不存在则返回nil
}
