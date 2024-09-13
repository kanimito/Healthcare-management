package com.it.study.service;

import com.it.study.domain.entity.DepartmentCategory;
import com.it.study.domain.entity.Department;

import java.util.List;

public interface DepartmentService {
  List<DepartmentCategory> selAll();
  List<Department> selectAllDepartment();

  List<Department> selectAllDepartment1();

  List<Department> selectAllDepartment2();

  List<Department> selectAllDepartment3();

  List<Department> selectAllDepartment4();

  List<Department> selectAllDepartment5();

  List<Department> selectAllDepartment6();

  List<Department> selectAllDepartment7();

  void addDepartment(Department Department);
}
