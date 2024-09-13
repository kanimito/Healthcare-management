package com.it.study.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class TiJiaoDetailRequest {
    private Integer rgNum;
    private Integer doId;
    private String pName;
    private String pPatitentId;
    private double doCost;
    private Integer doStatus;
    private List<TiJiaoOrderDetailRequest> orderDetail;
}
