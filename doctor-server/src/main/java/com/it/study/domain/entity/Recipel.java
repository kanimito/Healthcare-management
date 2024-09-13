package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 处方表 @TableName recipel */
@Data
public class Recipel implements Serializable {
  /** 处方ID */
  private Integer rId;

  /** 挂号编号 */
  private Integer rgNum;

  /** 病人身份证 */
  private String pPatitentId;

  /** 病人姓名 */
  private String pName;

  /** 医生编号 */
  private String dDoctorId;

  /** 医生姓名 */
  private String dName;

  /** 医嘱 */
  private String rAdvice;

  /** 药品订单ID */
  private Integer doId;

  /** 处方创建时间 */
  private Date createTime;

  private static final long serialVersionUID = 1L;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", rId=").append(rId);
    sb.append(", rgNum=").append(rgNum);
    sb.append(", pPatitentId=").append(pPatitentId);
    sb.append(", pName=").append(pName);
    sb.append(", dDoctorId=").append(dDoctorId);
    sb.append(", dName=").append(dName);
    sb.append(", rAdvice=").append(rAdvice);
    sb.append(", doId=").append(doId);
    sb.append(", createTime=").append(createTime);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
