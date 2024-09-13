import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/doctor/login',
    method: 'post',
    data:data
  })
}

export function getInfo(token) {
  return request({
    url: '/doctor/user/info',
    method: 'get',
    params: {
      token
    }
  })
}

export function logout() {
  return request({
    url: '/doctor/user/logout',
    method: 'post'
  })
}


