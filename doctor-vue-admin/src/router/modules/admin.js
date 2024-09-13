//管理员路由设置
import Layout from '@/layout';

const adminSettingRouter = {
    path: '/adminSetting',
    component: Layout,
    name: 'AdminSetting',
    meta: {
        title: 'AdminSetting',
        icon: 'el-icon-user-solid',
        roles: ['admin'],
    },
    
    children: [
        {
            path: '/patient',
            component:() => import('@/views/admin/patient-records'),
            name: 'Patient',
            meta: {title: 'Patient',roles: ['admin']},
            
        },
        {
            path: '/doctor',
            component:() => import('@/views/admin/doctor-records'),
            name: 'Doctor',
            meta: {title: 'Doctor',roles: ['admin']},
        },
        {
            path: '/drugs',
            component:() => import('@/views/admin/drugs'),
            name: 'Drugs',
            meta: {title: 'Drugs',roles: ['admin']},
        },
        {
            path: '/department',
            component:() => import('@/views/admin/department'),
            name: 'Department',
            meta: {title: 'Department',roles: ['admin']},
        },
        {
            path: '/scheduling',
            component:() => import('@/views/admin/scheduling'),
            name: 'Scheduling',
            meta: {title: 'Scheduling',roles: ['admin']},
        },
    ]
};

export default adminSettingRouter;