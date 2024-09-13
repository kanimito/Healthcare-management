package com.it.study.controller.patient;

import com.it.study.common.Result;
import com.it.study.domain.dto.DrugDTO;
import com.it.study.domain.entity.DrugsOrder;
import com.it.study.service.DrugService;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.controller.patient @Author: kanimito @CreateTime: 2024-08-21 23:35 @Description:
 * TODO @Version: 1.0
 */
@RestController
@RequestMapping("/patient")
@Log4j
public class DrugController {
  @Autowired private DrugService drugService;

  @GetMapping("/getDrugOrder")
  public Result getDrugOrder(Integer rid) {
    List<DrugDTO> drugDTOS = drugService.selectDrug(rid);

    return Result.ok(drugDTOS);
  }

  @PostMapping("/updateOrderStatus")
  public Result updateOrderStatus(@RequestBody DrugsOrder drugsOrder) {
    drugService.updateOrderStatus(drugsOrder.getDoId());
    return Result.ok();
  }
}
