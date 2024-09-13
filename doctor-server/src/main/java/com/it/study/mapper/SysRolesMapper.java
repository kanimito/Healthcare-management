package com.it.study.mapper;

import com.it.study.domain.entity.SysRoles;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【sys_roles】的数据库操作Mapper
 * @createDate 2024-08-16 07:40:52 @Entity com.it.study.domain.entity.SysRoles
 */
public interface SysRolesMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysRoles record);

  int insertSelective(SysRoles record);

  SysRoles selectByPrimaryKey(Integer id);

  List<SysRoles> selectRoles();

  int updateByPrimaryKeySelective(SysRoles record);

  int updateByPrimaryKey(SysRoles record);
}
