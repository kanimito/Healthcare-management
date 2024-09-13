package com.it.study.mapper;

import com.it.study.domain.entity.DepartmentCategory;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【department_category(科室分类表)】的数据库操作Mapper
 * @createDate 2024-08-21 09:32:26 @Entity com.it.study.domain.entity.DepartmentCategory
 */
public interface DepartmentCategoryMapper {

  int deleteByPrimaryKey(Long id);

  int insert(DepartmentCategory record);

  int insertSelective(DepartmentCategory record);

  DepartmentCategory selectByPrimaryKey(Long id);

  List<DepartmentCategory> selectAll();

  int updateByPrimaryKeySelective(DepartmentCategory record);

  int updateByPrimaryKey(DepartmentCategory record);

  List<DepartmentCategory> selectAllDepartmentCategory();
}
