package com.it.study.domain.entity;

import java.io.Serializable;
import lombok.Data;

/** 排班时间表 @TableName shift_time */
@Data
public class ShiftTime implements Serializable {
  /** 排班时间id */
  private Integer shiftTimeId;

  /** 排班id */
  private Integer shiftId;

  /** 排班时间段（8-12点，14-16点，整点）S */
  private Integer time;

  /** 时间段放号数量 */
  private Integer count;

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
    ShiftTime other = (ShiftTime) that;
    return (this.getShiftTimeId() == null
            ? other.getShiftTimeId() == null
            : this.getShiftTimeId().equals(other.getShiftTimeId()))
        && (this.getShiftId() == null
            ? other.getShiftId() == null
            : this.getShiftId().equals(other.getShiftId()))
        && (this.getTime() == null
            ? other.getTime() == null
            : this.getTime().equals(other.getTime()))
        && (this.getCount() == null
            ? other.getCount() == null
            : this.getCount().equals(other.getCount()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getShiftTimeId() == null) ? 0 : getShiftTimeId().hashCode());
    result = prime * result + ((getShiftId() == null) ? 0 : getShiftId().hashCode());
    result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
    result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", shiftTimeId=").append(shiftTimeId);
    sb.append(", shiftId=").append(shiftId);
    sb.append(", time=").append(time);
    sb.append(", count=").append(count);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
