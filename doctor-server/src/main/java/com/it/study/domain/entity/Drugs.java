package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 药品表 @TableName drugs */
@Data
public class Drugs implements Serializable {
  /** 药品编号 */
  private String drugId;

  /** 药品名称 */
  private String drugName;

  /** 药品进价 */
  private Double drugIntoPrice;

  /** 药品售价 */
  private Double drugExitPrice;

  /** 药品数量 */
  private Long drugQuantity;

  /** 药品单位（盒、瓶、袋） */
  private String drugUnit;

  /** 存储位置 */
  private String drugStorage;

  /** 生产日期 */
  private Date drugDate;

  /** 有效期 */
  private Date usefullLife;

  private static final long serialVersionUID = 1L;

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    Drugs other = (Drugs) that;
    return (this.getDrugId() == null
            ? other.getDrugId() == null
            : this.getDrugId().equals(other.getDrugId()))
        && (this.getDrugName() == null
            ? other.getDrugName() == null
            : this.getDrugName().equals(other.getDrugName()))
        && (this.getDrugIntoPrice() == null
            ? other.getDrugIntoPrice() == null
            : this.getDrugIntoPrice().equals(other.getDrugIntoPrice()))
        && (this.getDrugExitPrice() == null
            ? other.getDrugExitPrice() == null
            : this.getDrugExitPrice().equals(other.getDrugExitPrice()))
        && (this.getDrugQuantity() == null
            ? other.getDrugQuantity() == null
            : this.getDrugQuantity().equals(other.getDrugQuantity()))
        && (this.getDrugUnit() == null
            ? other.getDrugUnit() == null
            : this.getDrugUnit().equals(other.getDrugUnit()))
        && (this.getDrugStorage() == null
            ? other.getDrugStorage() == null
            : this.getDrugStorage().equals(other.getDrugStorage()))
        && (this.getDrugDate() == null
            ? other.getDrugDate() == null
            : this.getDrugDate().equals(other.getDrugDate()))
        && (this.getUsefullLife() == null
            ? other.getUsefullLife() == null
            : this.getUsefullLife().equals(other.getUsefullLife()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
    result = prime * result + ((getDrugName() == null) ? 0 : getDrugName().hashCode());
    result = prime * result + ((getDrugIntoPrice() == null) ? 0 : getDrugIntoPrice().hashCode());
    result = prime * result + ((getDrugExitPrice() == null) ? 0 : getDrugExitPrice().hashCode());
    result = prime * result + ((getDrugQuantity() == null) ? 0 : getDrugQuantity().hashCode());
    result = prime * result + ((getDrugUnit() == null) ? 0 : getDrugUnit().hashCode());
    result = prime * result + ((getDrugStorage() == null) ? 0 : getDrugStorage().hashCode());
    result = prime * result + ((getDrugDate() == null) ? 0 : getDrugDate().hashCode());
    result = prime * result + ((getUsefullLife() == null) ? 0 : getUsefullLife().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", drugId=").append(drugId);
    sb.append(", drugName=").append(drugName);
    sb.append(", drugIntoPrice=").append(drugIntoPrice);
    sb.append(", drugExitPrice=").append(drugExitPrice);
    sb.append(", drugQuantity=").append(drugQuantity);
    sb.append(", drugUnit=").append(drugUnit);
    sb.append(", drugStorage=").append(drugStorage);
    sb.append(", drugDate=").append(drugDate);
    sb.append(", usefullLife=").append(usefullLife);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
