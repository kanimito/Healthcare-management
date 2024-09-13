package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.dto.DrugDTO;
import com.it.study.domain.entity.DrugsOrder;
import com.it.study.mapper.DrugsOrderDetailMapper;
import com.it.study.mapper.DrugsOrderMapper;
import com.it.study.service.DrugService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.service.impl @Author: kanimito @CreateTime: 2024-08-22 10:09 @Description:
 * TODO @Version: 1.0
 */
@Service
@Log4j
public class DrugServiceImpl implements DrugService {
  @Autowired private DrugsOrderDetailMapper drugsOrderDetailMapper;
  @Autowired private DrugsOrderMapper drugsOrderMapper;

  @Override
  public List<DrugDTO> selectDrug(Integer rid) {
    List<DrugDTO> drugDTOS = drugsOrderDetailMapper.selectDrugOrder(rid);
    if (drugDTOS == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return drugDTOS;
  }

  @Override
  public void updateOrderStatus(Integer doId) {
    DrugsOrder drugsOrder = new DrugsOrder();
    drugsOrder.setDoStatus(1);
    drugsOrder.setDoId(doId);
    log.info(drugsOrder);
    int i = drugsOrderMapper.updateByPrimaryKeySelective(drugsOrder);
    if (i < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }
}
