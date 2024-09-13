package com.it.study.domain.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * 病人表
 * @TableName patient
 */
@Data
public class Patient implements Serializable {
    /**
     * 病人身份证号
     */
    private String pPatientId;

    /**
     * 病人头像
     */
    private String pAvatar;

    /**
     * 病人账号
     */
    private String pUsername;

    /**
     * 病人姓名
     */
    private String pName;

    /**
     * 病人密码
     */
    private String pPassword;

    /**
     * 角色标识
     */
    private String role;

    /**
     * 病人年龄
     */
    private Integer pAge;

    /**
     * 病人性别
     */
    private String pSex;

    /**
     * 病人电话
     */
    private String pTel;

    /**
     * 病人邮箱
     */
    private String pEmail;

    private static final long serialVersionUID = 1L;

}