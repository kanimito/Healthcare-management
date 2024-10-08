package com.it.study.service.impl;

import com.github.pagehelper.Page;
import com.it.study.common.CodeEnum;
import com.it.study.common.exception.BusinessException;
import com.it.study.domain.entity.SysResources;
import com.it.study.mapper.SysResourcesMapper;
import com.it.study.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage:
 * com.it.study.service.impl @Author: kanimito @CreateTime: 2024-08-19 00:40 @Description:
 * TODO @Version: 1.0
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
  @Autowired private SysResourcesMapper sysResourcesMapper;

  @Override
  public Page<SysResources> selectResources() {
    Page<SysResources> sysResources = sysResourcesMapper.selectResources();
    if (sysResources.size() < 1) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return sysResources;
  }

  @Override
  public void insertResource(SysResources sysResources) {
    int insert = sysResourcesMapper.insert(sysResources);
    if (insert < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public void updateResource(SysResources sysResources) {
    int update = sysResourcesMapper.updateByPrimaryKey(sysResources);
    if (update < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public void deleteResource(Integer id) {
    int delete = sysResourcesMapper.deleteByPrimaryKey(id);
    if (delete < 1) {
      throw new BusinessException(CodeEnum.UpdateError);
    }
  }

  @Override
  public SysResources selectResourceById(Integer id) {
    SysResources sysResources = sysResourcesMapper.selectByPrimaryKey(id);
    if (sysResources == null) {
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return sysResources;
  }
}
