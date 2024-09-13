package com.it.study.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @TableName sys_resources
 */
@Data
public class SysResources implements Serializable {
  /** */
  private Integer id;

  /** 资源名称 */
  private String name;

  /** 资源URL */
  private String url;

  /** 类型 0：菜单 1：功能 */
  private Integer type;

  /** 排序 */
  private Integer sort;

  /** 备注 */
  private String note;

  /** 父菜单ID，一级菜单为0 */
  private Integer parentid;

  /** 授权(如：sys:user:create) */
  private String permission;

    /**
     * 
     */
    @JsonFormat(pattern="yyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;

  /** */
  private Date modifiedTime;

  /** 创建用户 */
  private String gmtAddUser;

  /** 修改用户 */
  private String gmtUpdateUser;

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
    SysResources other = (SysResources) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getName() == null
            ? other.getName() == null
            : this.getName().equals(other.getName()))
        && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
        && (this.getType() == null
            ? other.getType() == null
            : this.getType().equals(other.getType()))
        && (this.getSort() == null
            ? other.getSort() == null
            : this.getSort().equals(other.getSort()))
        && (this.getNote() == null
            ? other.getNote() == null
            : this.getNote().equals(other.getNote()))
        && (this.getParentid() == null
            ? other.getParentid() == null
            : this.getParentid().equals(other.getParentid()))
        && (this.getPermission() == null
            ? other.getPermission() == null
            : this.getPermission().equals(other.getPermission()))
        && (this.getCreatedTime() == null
            ? other.getCreatedTime() == null
            : this.getCreatedTime().equals(other.getCreatedTime()))
        && (this.getModifiedTime() == null
            ? other.getModifiedTime() == null
            : this.getModifiedTime().equals(other.getModifiedTime()))
        && (this.getGmtAddUser() == null
            ? other.getGmtAddUser() == null
            : this.getGmtAddUser().equals(other.getGmtAddUser()))
        && (this.getGmtUpdateUser() == null
            ? other.getGmtUpdateUser() == null
            : this.getGmtUpdateUser().equals(other.getGmtUpdateUser()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
    result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
    result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
    result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
    result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
    result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
    result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
    result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
    result = prime * result + ((getGmtAddUser() == null) ? 0 : getGmtAddUser().hashCode());
    result = prime * result + ((getGmtUpdateUser() == null) ? 0 : getGmtUpdateUser().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", name=").append(name);
    sb.append(", url=").append(url);
    sb.append(", type=").append(type);
    sb.append(", sort=").append(sort);
    sb.append(", note=").append(note);
    sb.append(", parentid=").append(parentid);
    sb.append(", permission=").append(permission);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", modifiedTime=").append(modifiedTime);
    sb.append(", gmtAddUser=").append(gmtAddUser);
    sb.append(", gmtUpdateUser=").append(gmtUpdateUser);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
