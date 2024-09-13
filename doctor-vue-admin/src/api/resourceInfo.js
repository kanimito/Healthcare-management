import request from '@/utils/request'

export function resourceList(data) {
  return request({
    url: '/doctor/resource/list',
    method: 'get',
    params: data
  })
}

export function addResource(data) {
  return request({
    url: '/doctor/resource/add',
    method: 'post',
    data: data
  })
}

export function getResourceById(data) {
  return request({
    url: '/doctor/resource/get',
    method: 'get',
    params: data
  })
}

export function updateResourceById(data) {
  return request({
    url: '/doctor/resource/update',
    method: 'post',
    data: data
  })
}

export function deleteResourceById(data) {
  return request({
    url: '/doctor/resource/delete',
    method: 'get',
    params: data
  })
}

