import request from '@/utils/request'
export function selectDrugsList() {
    return request({
      url: '/doctor/user/drugslist',
      method: 'post',
    })
  }
  export function selectPatientPage() {
    return request({
      url: '/doctor/user/selectPatientPage',
      method: 'get',
    })
  }
  export function huizhenye(params) {
    return request({
      url: '/doctor/user/huizhen',
      method: 'post',
      data:params
    })
  }
  export function seepaiban(params) {
    return request({
      url: '/doctor/user/seepaiban',
      method: 'post',
      data:params
    })
  }
  export function jiaohao1(params) {
    return request({
      url: '/doctor/user/jiaohao',
      method: 'post',
      data:params
    })
  }
  export function tijiao(data) {
    return request({
      url: '/doctor/user/tijiaoyizhu',
      method: 'post',
      data
    })
  }
  export function tijiaodingdan(data) {
    return request({
      url: '/doctor/user/tijiaodingdan',
      method: 'post',
      data
    })
  }
  export function tijiaoorderdetail(data) {
    return request({
      url: '/doctor/user/tijiaoorderdetail',
      method: 'post',
      data
    })
  }
  export function buquan(data) {
    return request({
      url: '/doctor/user/buquan',
      method: 'post',
      data
    })
  }