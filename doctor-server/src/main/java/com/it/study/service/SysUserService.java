package com.it.study.service;

import com.github.pagehelper.Page;
import com.it.study.domain.entity.SysUserRoles;
import com.it.study.domain.entity.SysUsers;
import com.it.study.domain.request.UserRequest;

import java.util.List;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-study @BelongsPackage: com.it.study.service @Author:
 * kanimito @CreateTime: 2024-07-31 15:41 @Description: TODO @Version: 1.0
 */
public interface SysUserService {
  String login(UserRequest user);

  void logout(String token);

  Page<SysUserRoles> userList();

  void updateUser(SysUsers sysUsers);

  void addUser(SysUsers sysUsers);

  void deleteUser(Integer id);

  Page<SysUsers> getByUserCode(String userCode);

  List<SysUsers> getDoctorListByDId(Integer dId);

  List<SysUsers> getDoctorListAll();
  List<SysUsers> selectAllDoctors();
}
