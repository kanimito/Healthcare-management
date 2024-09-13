package com.it.study.domain.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName sys_role_resources
 */
@Data
public class SysRoleResources implements Serializable {
  /** */
  private Integer id;

  /** 角色ID */
  private Integer roleId;

  /** 资源ID */
  private Integer resourceId;

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
    SysRoleResources other = (SysRoleResources) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getRoleId() == null
            ? other.getRoleId() == null
            : this.getRoleId().equals(other.getRoleId()))
        && (this.getResourceId() == null
            ? other.getResourceId() == null
            : this.getResourceId().equals(other.getResourceId()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
    result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", roleId=").append(roleId);
    sb.append(", resourceId=").append(resourceId);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
