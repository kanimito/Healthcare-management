package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.DepartmentCategory;
import com.it.study.mapper.DepartmentCategoryMapper;
import com.it.study.domain.entity.Department;
import com.it.study.mapper.DepartmentMapper;
import com.it.study.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired private DepartmentMapper departmentMapper;
   @Autowired private DepartmentCategoryMapper departmentCategoryMapper;

  @Override
  public List<DepartmentCategory> selAll() {
    List<DepartmentCategory> departmentCategories = departmentCategoryMapper.selectAll();
    if (departmentCategories.size() < 1) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return departmentCategories;
  }

  @Override
  public List<Department> selectAllDepartment() {
    return departmentMapper.selectAllDepartment();
  }

  @Override
  public List<Department> selectAllDepartment1() {
    return departmentMapper.selectAllDepartment1();
  }

  @Override
  public List<Department> selectAllDepartment2() {
    return departmentMapper.selectAllDepartment2();
  }

  @Override
  public List<Department> selectAllDepartment3() {
    return departmentMapper.selectAllDepartment3();
  }

  @Override
  public List<Department> selectAllDepartment4() {
    return departmentMapper.selectAllDepartment4();
  }

  @Override
  public List<Department> selectAllDepartment5() {
    return departmentMapper.selectAllDepartment5();
  }

  @Override
  public List<Department> selectAllDepartment6() {
    return departmentMapper.selectAllDepartment6();
  }

  @Override
  public List<Department> selectAllDepartment7() {
    return departmentMapper.selectAllDepartment7();
  }

  @Override
  public void addDepartment(Department Department) {
    int department = departmentMapper.insert(Department);
    if (department < 1) {
      throw new BusinessException(CodeEnum.Fail);
    }
  }
}
