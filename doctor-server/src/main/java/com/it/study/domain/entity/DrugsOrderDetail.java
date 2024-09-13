package com.it.study.domain.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName drugs_order_detail
 */
@Data
public class DrugsOrderDetail implements Serializable {
  /** 药品订单详情ID */
  private Integer dodId;

  /** 药品订单ID */
  private Integer doId;

  /** 药品ID */
  private Integer drugsId;

  /** 药品数量 */
  private Integer drugsQuantity;

  /** 小计 */
  private Double dodCost;

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
    DrugsOrderDetail other = (DrugsOrderDetail) that;
    return (this.getDodId() == null
            ? other.getDodId() == null
            : this.getDodId().equals(other.getDodId()))
        && (this.getDoId() == null
            ? other.getDoId() == null
            : this.getDoId().equals(other.getDoId()))
        && (this.getDrugsId() == null
            ? other.getDrugsId() == null
            : this.getDrugsId().equals(other.getDrugsId()))
        && (this.getDrugsQuantity() == null
            ? other.getDrugsQuantity() == null
            : this.getDrugsQuantity().equals(other.getDrugsQuantity()))
        && (this.getDodCost() == null
            ? other.getDodCost() == null
            : this.getDodCost().equals(other.getDodCost()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getDodId() == null) ? 0 : getDodId().hashCode());
    result = prime * result + ((getDoId() == null) ? 0 : getDoId().hashCode());
    result = prime * result + ((getDrugsId() == null) ? 0 : getDrugsId().hashCode());
    result = prime * result + ((getDrugsQuantity() == null) ? 0 : getDrugsQuantity().hashCode());
    result = prime * result + ((getDodCost() == null) ? 0 : getDodCost().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", dodId=").append(dodId);
    sb.append(", doId=").append(doId);
    sb.append(", drugsId=").append(drugsId);
    sb.append(", drugsQuantity=").append(drugsQuantity);
    sb.append(", dodCost=").append(dodCost);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
