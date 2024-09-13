package com.it.study.mapper;

import com.github.pagehelper.Page;
import com.it.study.domain.entity.SysUserRoles;

/**
 * @author Administrator
 * @description 针对表【sys_user_roles】的数据库操作Mapper
 * @createDate 2024-08-16 07:40:52 @Entity com.it.study.domain.entity.SysUserRoles
 */
public interface SysUserRolesMapper {
  Page<SysUserRoles> selectUsersWithRoles();

  int insertUserRoles(SysUserRoles sysUserRoles);

  //    int addUser(SysUserRoles sysUserRoles);

}
