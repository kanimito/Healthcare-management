import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['/login', '/auth-redirect'] // no redirect whitelist
/**
 * 前置路由守卫(在每一次地址发生跳转时都会执行该方法)
 */
router.beforeEach(async(to, from, next) => {
  // 开始进度条
  NProgress.start()

  // 设置页面标题
  document.title = getPageTitle(to.meta.title)

  // 判断用户是否已登录
  const hasToken = getToken()

  if (hasToken) {
    if (to.path === '/login') {
      // 如果已登录，则重定向到主页
      next({ path: '/' })
      NProgress.done() // hack: https://github.com/PanJiaChen/vue-element-admin/pull/2939
    } else {
      // 通过getInfo判断用户是否获得了权限角色
      const hasRoles = store.getters.roles && store.getters.roles.length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          // console.log("try-token="+hasToken)
          // 获取用户信息
          // 注意:角色必须是一个对象数组!例如:['admin']或['developer'，'editor']
          const { roles } = await store.dispatch('user/getInfo')

          // 根据角色生成可访问路由映射
          const accessRoutes = await store.dispatch('permission/generateRoutes', roles)

          // 动态添加可访问路由
          router.addRoutes(accessRoutes)

          // Hack方法确保添加路由完成
          //设置replace: true，这样导航就不会留下历史记录
          next({ ...to, replace: true })
        } catch (error) {
          // console.log("catch-token="+hasToken)
          // console.log("error=");
          // 删除令牌并转到登录页面重新登录
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          //送你回登录页面
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* has no token*/

    if (whiteList.indexOf(to.path) !== -1) {
      // 在免费登录白名单中，直接进入
      next()
    } else {
      // 其他没有访问权限的页面被重定向到登录页面,并且登录成功后自动跳回你想去的页面
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // 完成进度条
  NProgress.done()
})
