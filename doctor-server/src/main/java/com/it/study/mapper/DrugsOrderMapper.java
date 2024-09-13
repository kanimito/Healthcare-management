package com.it.study.mapper;

import com.it.study.domain.entity.DrugsOrder;
import com.it.study.domain.entity.DrugsOrderDetail;
import com.it.study.domain.request.TiJiaoDetailRequest;
import com.it.study.domain.request.TiJiaoOrderDetailRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 31344
* @description 针对表【drugs_order(处方详情表)】的数据库操作Mapper
* @createDate 2024-09-06 11:51:24
* @Entity com.it.study.domain.entity.DrugsOrder
*/
public interface DrugsOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DrugsOrder record);

    int insertSelective(DrugsOrder record);

    DrugsOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DrugsOrder record);

    int updateByPrimaryKey(DrugsOrder record);

    Boolean insertOrder(TiJiaoDetailRequest tiJiaoDetailRequest);

//    int getLastInsertId();

    Boolean insertOrderDetails(TiJiaoOrderDetailRequest item);
}
