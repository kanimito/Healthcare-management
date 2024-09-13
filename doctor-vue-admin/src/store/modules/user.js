import { login, logout, getInfo } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { resetRouter } from '@/router'

const state = {
  token: getToken(),
  name: '',
  avatar: '',
  introduction: '',
  roles: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_INTRODUCTION: (state, introduction) => {
    state.introduction = introduction
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  }
}

const actions = {
  // 用户登录逻辑
  login({ commit }, userInfo) {
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
      // 可以将登录令牌存储进cookie当中
      login({ username: username.trim(), password: password })
        .then((response) => {
          const { data } = response
          // 将令牌存储到store对象里面,实现vue组件共享该数据
          commit('SET_TOKEN', data)
          // 将令牌存储到cookie中
          setToken(data)
          resolve()
        })
        .catch((error) => {
          reject(error)
        })
    })
  },

  // get user info
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      console.log(state.token)
      getInfo(state.token)
        .then((response) => {
          const { data } = response

          if (!data) {
            reject('令牌无效,请重新登录')
          }
          /**
           * roles must be a non-empty array
           * 这里必须是数组类型,不然会报错,所以必须要加[]
           * name, avatar, introduction 是从后端拿到的
           * {
           *   roles: ['admin']
           *   username: 'admin'
           *   avatar: '头像图片地址'
           *   introduction: '个人简介'
           * }
           */
          const { roles, username } = data

          // roles must be a non-empty array
          if (!roles || roles.length <= 0) {
            reject('getInfo: 登录人员必须是管理员(admin)或者医生(doctor)')
          }

          commit('SET_ROLES', roles)
          commit('SET_NAME', username)
          // commit('SET_AVATAR', avatar);
          // commit('SET_INTRODUCTION', introduction);
          resolve(data)
        })
        .catch((error) => {
          reject(error)
        })
    })
  },

  // user logout
  logout({ commit, state, dispatch }) {
    return new Promise((resolve, reject) => {
      logout()
        .then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          // 移除cookie当中的令牌
          removeToken()
          // 重置路由配置
          resetRouter()

          // 重置访问过的视图和缓存的视图
          // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
          // 关闭所有的路由页面标签
          dispatch('tagsView/delAllViews', null, { root: true })

          resolve()
        })
        .catch((error) => {
          reject(error)
        })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise((resolve) => {
      commit('SET_TOKEN', '')
      commit('SET_ROLES', [])
      removeToken()
      resolve()
    })
  },

  // dynamically modify permissions
  async changeRoles({ commit, dispatch }, role) {
    const token = role + '-token'

    commit('SET_TOKEN', token)
    setToken(token)

    const { roles } = await dispatch('getInfo')

    resetRouter()

    // generate accessible routes map based on roles
    const accessRoutes = await dispatch('permission/generateRoutes', roles, {
      root: true
    })
    // dynamically add accessible routes
    router.addRoutes(accessRoutes)

    // reset visited views and cached views
    dispatch('tagsView/delAllViews', null, { root: true })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
