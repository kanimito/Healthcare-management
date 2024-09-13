import request from '@/utils/request'

export function roleList(data) {
  return request({
    url: '/doctor/role/list',
    method: 'get',
    params: data
  })
}

export function addUserRole(data) {
  return request({
    url: '/doctor/role/addUserRole',
    method: 'post',
    data: data
  })
}

export function addRole(data) {
  return request({
    url: '/doctor/role/add',
    method: 'post',
    data: data
  })
}

export function getRoleById(data) {
  return request({
    url: '/doctor/role/get',
    method: 'get',
    params: data
  })
}

export function updateRoleById(data) {
  return request({
    url: '/doctor/role/update',
    method: 'post',
    data: data
  })
}

export function deleteRoleById(data) {
  return request({
    url: '/doctor/role/delete',
    method: 'get',
    params: data
  })
}

