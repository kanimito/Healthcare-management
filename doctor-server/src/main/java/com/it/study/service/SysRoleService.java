package com.it.study.service;

import com.it.study.domain.entity.SysRoles;
import com.it.study.domain.entity.SysUserRoles;

import java.util.List;

public interface SysRoleService {
  List<SysRoles> selectRoles();

  void insertUserRole(SysUserRoles sysUserRoles);

  void insertRole(SysRoles sysRoles);

  SysRoles selectRoleById(Integer id);

  void updateRole(SysRoles sysRoles);

  void deleteRole(Integer id);
}
