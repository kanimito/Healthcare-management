package com.it.study.controller.admin;

import com.it.study.common.Result;
import com.it.study.domain.entity.DepartmentCategory;
import com.it.study.service.DepartmentCategoryService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping(value = "/doctor/admin")
public class AdminDepartmentCategoryController {

  @Autowired private DepartmentCategoryService departmentCategoryService;

  // todo 主科室数据获得
  @GetMapping(value = "/departmentCategoryList")
  public Result DepartmentCategoryList() {
    List<DepartmentCategory> departmentCategories =
        departmentCategoryService.selectAllDepartmentCategory();
    return Result.ok(departmentCategories);
  }
}
