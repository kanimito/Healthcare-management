package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 处方详情表 @TableName drugs_order */
@Data
public class DrugsOrder implements Serializable {
  /** 药品订单ID */
  private Integer doId;

  /** 病人ID */
  private String pPatitentId;

  /** 病人姓名 */
  private String pName;

  /** 药品订单下单时间 */
  private Date doCreatetime;

  /** 药品订单状态(0、未支付 1、已支付) */
  private Integer doStatus;

  /** 药品订单花费 */
  private Double doCost;

  private static final long serialVersionUID = 1L;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", doId=").append(doId);
    sb.append(", pPatitentId=").append(pPatitentId);
    sb.append(", pName=").append(pName);
    sb.append(", doCreatetime=").append(doCreatetime);
    sb.append(", doStatus=").append(doStatus);
    sb.append(", doCost=").append(doCost);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
