package com.it.study.service.impl;

import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.Drugs;
import com.it.study.mapper.DrugsMapper;
import com.it.study.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DrugsServiceImpl implements DrugsService {

  @Autowired private DrugsMapper drugsMapper;

  @Override
  public List<Drugs> selectAllDrugs() {
    List<Drugs> drugs = drugsMapper.selectAllDrugs();
    return drugs;
  }

  @Override
  public Drugs selectById(Long id) {
    return drugsMapper.selectByPrimaryKey(id);
  }

  @Override
  public void updateDrugs(Drugs drugs) {
    int row = drugsMapper.updateByPrimaryKey(drugs);
    if (row < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public void deleteDrugs(Long id) {
    int row = drugsMapper.deleteByPrimaryKey(id);
    if (row < 1) {
      throw new BusinessException(CodeEnum.DeleteError);
    }
  }

  @Override
  public void addDrugs(Drugs drugs) {
    int row = drugsMapper.insert(drugs);
    if (row < 1) {
      throw new BusinessException(CodeEnum.Fail);
    }

    //        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //
    //        // 创建一个日期格式化对象
    //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    //
    //        // 将Timestamp转换为字符串
    //        String formattedDate = sdf.format(timestamp);
    //
    //        System.out.println(formattedDate);
  }
}
