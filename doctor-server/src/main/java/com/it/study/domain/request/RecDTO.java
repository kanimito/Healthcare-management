package com.it.study.domain.request;

import lombok.Data;

public class RecDTO {
    private String rgNum;
    private String pName;
    private String pPatientId;
    private String rAdvice;

    public RecDTO() {
    }

    public RecDTO(String rgNum, String pName, String pPatientId, String rAdvice) {
        this.rgNum = rgNum;
        this.pName = pName;
        this.pPatientId = pPatientId;
        this.rAdvice = rAdvice;
    }

    public String getRgNum() {
        return rgNum;
    }

    public void setRgNum(String rgNum) {
        this.rgNum = rgNum;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPatientId() {
        return pPatientId;
    }

    public void setpPatientId(String pPatientId) {
        this.pPatientId = pPatientId;
    }

    public String getrAdvice() {
        return rAdvice;
    }

    public void setrAdvice(String rAdvice) {
        this.rAdvice = rAdvice;
    }

    @Override
    public String toString() {
        return "RecDTO{" +
                "rgNum='" + rgNum + '\'' +
                ", pName='" + pName + '\'' +
                ", pPatientId='" + pPatientId + '\'' +
                ", rAdvice='" + rAdvice + '\'' +
                '}';
    }
}
