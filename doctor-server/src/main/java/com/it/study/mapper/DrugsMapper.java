package com.it.study.mapper;

import com.it.study.domain.entity.Drugs;

import java.util.List;

/** @Entity com.it.study.domain.entity.Drugs */
public interface DrugsMapper {

  int deleteByPrimaryKey(Long id);

  int insert(Drugs record);

  int insertSelective(Drugs record);

  Drugs selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(Drugs record);

  int updateByPrimaryKey(Drugs record);

  List<Drugs> selectAllDrugs();

  List<Drugs> selectDrugs();
}
