//系统管理路由设置
import Layout from '@/layout';
const systemSettingRouter = {
    path: '/systemSetting',
    component: Layout,
    // redirect: '/systemSetting/sysusers',
    name: 'SystemSetting',
    meta: {
      title: 'SystemSetting',
      icon: 'el-icon-setting',
      roles:['admin'],
    },
    children:[
        {
            path:'sysusers',
            component:() => import('@/views/system/users'),
            name:"SysUsers",
            meta:{title:'SysUsers'},
            roles:['admin']

        },
        {
            path:'sysroles',
            component:() => import('@/views/system/roles'),
            name:"SysRoles",
            meta:{title:'SysRoles'},
            roles:['admin']

        },
        {
            path:'sysresource',
            component:() => import('@/views/system/resources'),
            name:"SysResource",
            meta:{title:'SysResource'},
            roles:['admin']

        }
    ]
};


export default systemSettingRouter;