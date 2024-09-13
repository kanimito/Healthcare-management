package com.it.study.service.impl;

import com.it.study.domain.entity.DepartmentCategory;
import com.it.study.mapper.DepartmentCategoryMapper;
import com.it.study.service.DepartmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentCategoryServiceImpl implements DepartmentCategoryService {

  @Autowired private DepartmentCategoryMapper departmentCategoryMapper;

  @Override
  public List<DepartmentCategory> selectAllDepartmentCategory() {
    return departmentCategoryMapper.selectAllDepartmentCategory();
  }
}
