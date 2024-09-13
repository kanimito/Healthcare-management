package com.it.study.domain.entity;

import java.io.Serializable;

import lombok.Data;

/** 科室表 @TableName department */
@Data
public class Department implements Serializable {
  /** 科室主键ID */
  private Integer dId;

  /** 科室名 */
  private String dpName;

  /** 科室地址 */
  private String dAddress;

  /** 科室电话 */
  private String dPhone;

  /** 大类科室编号 */
  private Integer dcId;

  /** 小类科室编号 */
  private Integer dcChildId;

  private static final long serialVersionUID = 1L;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", dId=").append(dId);
    sb.append(", dpName=").append(dpName);
    sb.append(", dAddress=").append(dAddress);
    sb.append(", dPhone=").append(dPhone);
    sb.append(", dcId=").append(dcId);
    sb.append(", dcChildId=").append(dcChildId);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
