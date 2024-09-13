import request from '@/utils/request';

export function getDrugsList(query) {
    return request({
        url: '/doctor/admin/drugList',
        method: 'get',
        params: query
    })
}

export function getDrugsInfo(query) {
    return request({
        url: '/doctor/admin/drugInfo',
        method: 'get',
        params: query
    })
}

export function getPatientRecord(query){
    return request({
        url: '/doctor/admin/patient',
        method: 'get',
        params: query
    })
}

export function getDoctorRecord(query){
    return request({
        url: '/doctor/admin/doctor',
        method: 'get',
        params: query
    })
}

export function getAllDepartmentList(query){
    return request({
        url: '/doctor/admin/allDepartmentList',
        method: 'get',
        params: query
    })
}

//主科室获取
export function getDepartmentList(query){
    return request({
        url: '/doctor/admin/departmentCategoryList',
        method: 'get',
        params: query
    })
}

//内科科室获取
export function getDepartmentList1(query){
    return request({
        url: '/doctor/admin/departmentList1',
        method: 'get',
        params: query
    })
}

//外科科室获取
export function getDepartmentList2(query){
    return request({
        url: '/doctor/admin/departmentList2',
        method: 'get',
        params: query
    })
}

export function getDepartmentList3(query){
    return request({
        url: '/doctor/admin/departmentList3',
        method: 'get',
        params: query
    })
}

export function getDepartmentList4(query){
    return request({
        url: '/doctor/admin/departmentList4',
        method: 'get',
        params: query
    })
}

export function getDepartmentList5(query){
    return request({
        url: '/doctor/admin/departmentList5',
        method: 'get',
        params: query
    })
}

export function getDepartmentList6(query){
    return request({
        url: '/doctor/admin/departmentList6',
        method: 'get',
        params: query
    })
}

export function getDepartmentList7(query){
    return request({
        url: '/doctor/admin/departmentList7',
        method: 'get',
        params: query
    })
}



export function getShiftList(query){
    return request({
        url: '/doctor/admin/shiftList',
        method: 'get',
        params: query
    })
}

export function updateDrugs(query){
    return request({
        url: '/doctor/admin/updateDrugs',
        method: 'post',
        data: query
    })
}

export function deleteDrugs(query){
    return request({
        url: '/doctor/admin/deleteDrugs',
        method: 'get',
        params: query
    })
}

export function insertDrugs(query){
    return request({
        url: '/doctor/admin/addDrugs',
        method: 'post',
        data: query
    })
}

export function insertDepartment(query){
    return request({
        url: '/doctor/admin/addDepartment',
        method: 'post',
        data: query
    })
}

export function selectAllDoctorList(query){
    return request({
        url: '/doctor/user/selectAllDoctors',
        method: 'get',
        params: query
    })
}

export function insertScheduling(query){
    return request({
        url: '/doctor/admin/scheduling',
        method: 'post',
        data: query
    })
}

export function insertShiftTime(query){
    return request({
        url: '/doctor/admin/shiftTime',
        method: 'post',
        data: query
    })
}

export function getLatestShiftId(query){
    return request({
        url: '/doctor/admin/shiftId',
        method: 'post',
        data: query
    })
}
