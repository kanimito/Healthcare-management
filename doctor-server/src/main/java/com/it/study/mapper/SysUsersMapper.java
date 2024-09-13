package com.it.study.mapper;

import com.github.pagehelper.Page;
import com.it.study.common.PageResult;
import com.it.study.domain.entity.SysUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【sys_users】的数据库操作Mapper
 * @createDate 2024-08-13 09:30:58 @Entity com.it.study.domain.entity.SysUsers
 */
public interface SysUsersMapper {

  int deleteByPrimaryKey(@Param("id") Integer id);

  int insert(SysUsers record);

  int insertSelective(SysUsers record);

  SysUsers selectByPrimaryKey(Long id);
  SysUsers selectSysUserByPrimaryKey(Long id);
  Page<SysUsers> selectByUserCode(@Param("userCode") String userCode);
  Page<SysUsers> selectPageAllUser();

  SysUsers selectByUsername(@Param("username") String username);



  List<SysUsers> getDoctorListByDId(Integer dId);

  List<SysUsers> getDoctorListAll();

  int updateByPrimaryKeySelective(SysUsers record);

  int updateByPrimaryKey(SysUsers record);

  List<SysUsers> selectAllDoctors();
}
