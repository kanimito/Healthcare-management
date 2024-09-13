package com.it.study.domain.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName sys_user_roles
 */
@Data
public class SysUserRoles extends SysUsers implements Serializable {
  private Integer roleId;
  private Integer userId;
  private String roleName;
  private String roleNote;
}
