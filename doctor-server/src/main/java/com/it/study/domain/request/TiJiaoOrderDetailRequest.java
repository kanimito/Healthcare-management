package com.it.study.domain.request;

import lombok.Data;

@Data
public class TiJiaoOrderDetailRequest {
    private Integer doId;
    private Integer drugId;
    private Integer quantity;
    private double dodCost;
}
