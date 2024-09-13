package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sys_users
 */
@Data
public class SysUsers implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 医生部门ID
     */
    private Integer dId;

    /**
     * 账号类型：admin 或者 doctor
     */
    private String accountType;

    /**
     * 性别：0->男，1->女
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态:0->禁用，1->启用
     */
    private Integer status;

    /**
     * 添加时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    /**
     * 添加当前记录的用户
     */
    private String gmtAddUser;

    /**
     * 修改当前记录的用户
     */
    private String gmtUpdateUser;
    private Date expired;
    private static final long serialVersionUID = 1L;

}