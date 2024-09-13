import request from '@/utils/request'

export function addUser(data) {
  return request({
    url: '/doctor/user/add',
    method: 'post',
    data: data
  })
}

export function userlist(data) {
  return request({
    url: '/doctor/user/list',
    method: 'get',
    params: data
  })
}

export function updateUser(data) {
  return request({
    url: '/doctor/user/update',
    method: 'post',
    data: data
  })
}

export function deleteUser(data) {
  return request({
    url: '/doctor/user/delete',
    method: 'post',
    data: data
  })
}

export function getById(data) {
  return request({
    url: '/doctor/user/get',
    method: 'get',
    params: data
  })
}

export function getByUserCode(data) {
  return request({
    url: '/doctor/user/getByUserCode',
    method: 'get',
    params: data
  })
}
