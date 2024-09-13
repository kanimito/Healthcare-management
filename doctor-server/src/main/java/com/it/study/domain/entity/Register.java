package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**

 * @TableName register
 */
@Data
public class Register implements Serializable {
  /** 挂号编号 */
  private Integer rgNum;

  /** 病人身份证号 */
  private String pPatientId;

  /** 病人姓名 */
  private String pName;

  /** 病人性别 */
  private String pSex;

  /** 病人年龄 */
  private Integer pAge;

  /** 挂号时间 */
  @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
  private Date rgCreatetime;

  /** 挂号状态(0、未叫号 1、已叫号 2、就诊中 3、就诊完成) */
  private Integer rgStatus;

  /** 排班id */
  private Integer shiftId;

  /** 排班时间段id */
  private Integer shiftTimeId;
  private String dAddress;
  private String dpName;
  private static final long serialVersionUID = 1L;
  private String username;
  private String realName;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", rgNum=").append(rgNum);
    sb.append(", pPatientId=").append(pPatientId);
    sb.append(", pName=").append(pName);
    sb.append(", pSex=").append(pSex);
    sb.append(", pAge=").append(pAge);
    sb.append(", rgCreatetime=").append(rgCreatetime);
    sb.append(", rgStatus=").append(rgStatus);
    sb.append(", shiftId=").append(shiftId);
    sb.append(", shiftTimeId=").append(shiftTimeId);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
