package com.it.study.mapper;

import com.it.study.domain.entity.SysRoleResources;

/**
 * @author Administrator
 * @description 针对表【sys_role_resources】的数据库操作Mapper
 * @createDate 2024-08-16 07:40:52 @Entity com.it.study.domain.entity.SysRoleResources
 */
public interface SysRoleResourcesMapper {

  int deleteByPrimaryKey(Long id);

  int insert(SysRoleResources record);

  int insertSelective(SysRoleResources record);

  SysRoleResources selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(SysRoleResources record);

  int updateByPrimaryKey(SysRoleResources record);
}
