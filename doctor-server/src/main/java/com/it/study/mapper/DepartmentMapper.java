package com.it.study.mapper;

import com.it.study.domain.entity.Department;
import com.it.study.domain.entity.DepartmentCategory;

import java.util.List;

/** @Entity com.it.study.domain.entity.Department */
public interface DepartmentMapper {

  int deleteByPrimaryKey(Long id);

  int insert(Department record);

  int insertSelective(Department record);

  Department selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(Department record);

  int updateByPrimaryKey(Department record);

  List<Department> selectAllDepartment();

  List<Department> selectAllDepartment1();

  List<Department> selectAllDepartment2();

  List<Department> selectAllDepartment3();

  List<Department> selectAllDepartment4();

  List<Department> selectAllDepartment5();

  List<Department> selectAllDepartment6();

  List<Department> selectAllDepartment7();
}
