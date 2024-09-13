package com.it.study.mapper;

import com.it.study.domain.dto.DrugDTO;
import com.it.study.domain.entity.DrugsOrderDetail;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs_order_detail】的数据库操作Mapper
 * @createDate 2024-08-21 23:22:45 @Entity com.it.study.domain.entity.DrugsOrderDetail
 */
public interface DrugsOrderDetailMapper {

  int deleteByPrimaryKey(Long id);

  int insert(DrugsOrderDetail record);

  int insertSelective(DrugsOrderDetail record);

  DrugsOrderDetail selectByPrimaryKey(Long id);

  List<DrugDTO> selectDrugOrder(Integer rid);

  int updateByPrimaryKeySelective(DrugsOrderDetail record);

  int updateByPrimaryKey(DrugsOrderDetail record);
}
