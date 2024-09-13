package com.it.study.controller.admin;

import com.it.study.common.Result;
import com.it.study.domain.entity.Drugs;
import com.it.study.service.DrugsService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping(value = "/doctor/admin")
public class DrugsController {

  @Autowired private DrugsService drugsService;

  @GetMapping(value = "/drugList")
  public Result drugs() {
    List<Drugs> drugs = drugsService.selectAllDrugs();
    return Result.ok(drugs);
  }

  @GetMapping(value = "/drugInfo")
  public Result drugInfo(Long drugId) {
    return Result.ok(drugsService.selectById(drugId));
  }

  @PostMapping(value = "/updateDrugs")
  public Result updateDrugInfo(@RequestBody Drugs drugs) {
    drugsService.updateDrugs(drugs);
    return Result.ok("修改成功！");
  }

  @GetMapping(value = "/deleteDrugs")
  public Result deleteDrugs(Long drugId) {
    drugsService.deleteDrugs(drugId);
    return Result.ok("删除成功！");
  }

  @PostMapping(value = "/addDrugs")
  public Result addDrugs(@RequestBody Drugs drugs) {
    drugsService.addDrugs(drugs);
    return Result.ok("增加成功！");
  }
}
