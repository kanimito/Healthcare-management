import Layout from '@/layout'


const doctorRouter = {
  path: '/doctorsys',
  component: Layout,
  redirect: '/system/doctorsys',
  name: 'Doctorsys',
  alwaysShow: true,
  meta: {
    title: '医生系统',
    icon: 'el-icon-user',
    roles: ['doctor'],
  },
  children: [
    {
      path: 'paiban',
      component: () => import('@/views/doctor/seepaiban'),
      name: 'Paiban',
      meta: { title: '排班' ,roles: ['doctor']},
      
    },
    {
      path: 'drugs',
      component: () => import('@/views/doctor/doctorsys'),
      name: 'Drugs',
      meta: { title: '药品',roles: ['doctor']},
    },
    {
      path: 'patientpage',
      component: () => import('@/views/doctor/patientpage'),
      name: 'Patientpage',
      meta: { title: '病人挂号页', roles: ['doctor'] },
     
    },
    {
      path: 'seedoctor',
      component: () => import('@/views/doctor/seedoctor'),
      name: 'Seedoctor',
      hidden: true,
      meta:{title:'会诊',roles:['doctor']}
    },
  ]
}
export default doctorRouter;
