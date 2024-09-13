package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.study.domain.vo.Page;
import lombok.Data;

/** 排班表 @TableName shift */
public class Shift implements Serializable {
  /** 排班id */
  private Integer shiftId;

  /** 排班日期 */
  @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
  private Date date;

  /** 科室小类id */
  private Integer dcId;

  /** 办公室id */
  private Integer dId;

  /** 医生id */
  private Integer dDoctorId;

  /** 排班状态(0、未发布 1、已发布) */
  private Integer status;

  private String dcName;
  private String realName;
  private Integer time;
  private String dpName;
  private String dAddress;
  private String mobile;

  private String email;

  private String dPhone;

  private Integer sex;

  private Integer count;
  private static final long serialVersionUID = 1L;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getShiftId() {
    return shiftId;
  }

  public void setShiftId(Integer shiftId) {
    this.shiftId = shiftId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getDcId() {
    return dcId;
  }

  public void setDcId(Integer dcId) {
    this.dcId = dcId;
  }

  public Integer getdId() {
    return dId;
  }

  public void setdId(Integer dId) {
    this.dId = dId;
  }

  public Integer getdDoctorId() {
    return dDoctorId;
  }

  public void setdDoctorId(Integer dDoctorId) {
    this.dDoctorId = dDoctorId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getDcName() {
    return dcName;
  }

  public void setDcName(String dcName) {
    this.dcName = dcName;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public String getDpName() {
    return dpName;
  }

  public void setDpName(String dpName) {
    this.dpName = dpName;
  }

  public String getdAddress() {
    return dAddress;
  }

  public void setdAddress(String dAddress) {
    this.dAddress = dAddress;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getdPhone() {
    return dPhone;
  }

  public void setdPhone(String dPhone) {
    this.dPhone = dPhone;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "Shift{" +
            "shiftId=" + shiftId +
            ", date=" + date +
            ", dcId=" + dcId +
            ", dId=" + dId +
            ", dDoctorId=" + dDoctorId +
            ", status=" + status +
            ", dcName='" + dcName + '\'' +
            ", realName='" + realName + '\'' +
            ", time=" + time +
            ", dpName='" + dpName + '\'' +
            ", dAddress='" + dAddress + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", dPhone='" + dPhone + '\'' +
            ", sex=" + sex +
            ", count=" + count +
            '}';
  }
}
