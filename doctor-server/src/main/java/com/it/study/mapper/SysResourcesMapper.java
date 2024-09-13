package com.it.study.mapper;

import com.github.pagehelper.Page;
import com.it.study.domain.entity.SysResources;

/**
 * @author Administrator
 * @description 针对表【sys_resources】的数据库操作Mapper
 * @createDate 2024-08-16 07:40:52 @Entity com.it.study.domain.entity.SysResources
 */
public interface SysResourcesMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(SysResources record);

  int insertSelective(SysResources record);

  SysResources selectByPrimaryKey(Integer id);

  Page<SysResources> selectResources();

  int updateByPrimaryKeySelective(SysResources record);

  int updateByPrimaryKey(SysResources record);
}
