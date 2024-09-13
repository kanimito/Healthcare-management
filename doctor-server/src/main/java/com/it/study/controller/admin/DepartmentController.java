package com.it.study.controller.admin;

import com.it.study.common.Result;
import com.it.study.domain.entity.Department;
import com.it.study.service.DepartmentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping(value = "/doctor/admin")
public class DepartmentController {

  @Autowired private DepartmentService departmentService;

  // todo 所有科室数据获得
  @GetMapping(value = "/allDepartmentList")
  public Result allDepartmentList() {
    List<Department> department = departmentService.selectAllDepartment();
    return Result.ok(department);
  }

  // todo 内科数据获得
  @GetMapping(value = "/departmentList1")
  public Result DepartmentList1() {
    List<Department> department1 = departmentService.selectAllDepartment1();
    return Result.ok(department1);
  }

  // todo 外科数据获得
  @GetMapping(value = "/departmentList2")
  public Result DepartmentList2() {
    List<Department> department2 = departmentService.selectAllDepartment2();
    return Result.ok(department2);
  }

  // todo 妇产科数据获得
  @GetMapping(value = "/departmentList3")
  public Result DepartmentList3() {
    List<Department> department3 = departmentService.selectAllDepartment3();
    return Result.ok(department3);
  }

  // todo 儿科数据获得
  @GetMapping(value = "/departmentList4")
  public Result DepartmentList4() {
    List<Department> department4 = departmentService.selectAllDepartment4();
    return Result.ok(department4);
  }

  // todo 五官科数据获得
  @GetMapping(value = "/departmentList5")
  public Result DepartmentList5() {
    List<Department> department5 = departmentService.selectAllDepartment5();
    return Result.ok(department5);
  }

  // todo 肿瘤科数据获得
  @GetMapping(value = "/departmentList6")
  public Result DepartmentCategoryList6() {
    List<Department> department6 = departmentService.selectAllDepartment6();
    return Result.ok(department6);
  }

  // todo 中医科数据获得
  @GetMapping(value = "/departmentList7")
  public Result DepartmentCategoryList7() {
    List<Department> department7 = departmentService.selectAllDepartment7();
    return Result.ok(department7);
  }

  @PostMapping(value = "/addDepartment")
  public Result addDepartment(@RequestBody Department department) {
    departmentService.addDepartment(department);
    return Result.ok("添加成功！");
  }
}
