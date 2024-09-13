package com.it.study.domain.entity;

import java.io.Serializable;

import lombok.Data;

/** 科室分类表 @TableName department_category */
@Data
public class DepartmentCategory implements Serializable {
  /** 科室小类ID */
  private Integer dcId;

  /** 科室名称 */
  private String dcName;

  /** 科室大类ID */
  private Integer dcParentId;

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
    DepartmentCategory other = (DepartmentCategory) that;
    return (this.getDcId() == null
            ? other.getDcId() == null
            : this.getDcId().equals(other.getDcId()))
        && (this.getDcName() == null
            ? other.getDcName() == null
            : this.getDcName().equals(other.getDcName()))
        && (this.getDcParentId() == null
            ? other.getDcParentId() == null
            : this.getDcParentId().equals(other.getDcParentId()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getDcId() == null) ? 0 : getDcId().hashCode());
    result = prime * result + ((getDcName() == null) ? 0 : getDcName().hashCode());
    result = prime * result + ((getDcParentId() == null) ? 0 : getDcParentId().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", dcId=").append(dcId);
    sb.append(", dcName=").append(dcName);
    sb.append(", dcParentId=").append(dcParentId);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
