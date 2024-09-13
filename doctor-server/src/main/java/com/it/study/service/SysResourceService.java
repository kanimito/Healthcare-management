package com.it.study.service;

import com.github.pagehelper.Page;
import com.it.study.domain.entity.SysResources;

public interface SysResourceService {
  Page<SysResources> selectResources();

  void insertResource(SysResources sysResources);

  void updateResource(SysResources sysResources);

  void deleteResource(Integer id);

  SysResources selectResourceById(Integer id);
}
