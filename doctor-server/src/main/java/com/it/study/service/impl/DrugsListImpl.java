package com.it.study.service.impl;

import com.it.study.domain.entity.Drugs;
import com.it.study.mapper.DrugsMapper;
import com.it.study.service.DrugsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugsListImpl implements DrugsList {
    @Autowired
    DrugsMapper drugsMapper;
    @Override
    public List<Drugs> selectDrugsList() {
        List<Drugs> list = drugsMapper.selectDrugs();
        return list;
    }
}
