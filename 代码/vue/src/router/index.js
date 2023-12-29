import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },

  {
    path: '/system',
    component: Layout,
    children: [
      {
        path: '/user',
        name: 'User',
        component: () => import('@/views/user'),
        meta: { title: '用户管理', icon: 'form' }
      }
    ]
  },
  // {
  //   path: '/form',
  //   component: Layout,
  //   children: [
  //     {
  //       path: 'index',
  //       name: 'Form',
  //       component: () => import('@/views/form/index'),
  //       meta: { title: '报销申请', icon: 'form' }
  //     }
  //   ]
  // },

  {
    path: '/message',
    component: Layout,
    redirect: '/message/menu1',
    meta: { title: '凭证管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'model1',
        name: 'Message1',
        component: () => import('@/views/message/menu1/index'),
        meta: { title: '收款凭证', icon: 'el-icon-document' }
      },
      {
        path: 'model2',
        name: 'Message2',
        component: () => import('@/views/message/menu2/index'),
        meta: { title: '付款凭证', icon: 'el-icon-document' }
      },
      {
        path: 'model3',
        name: 'Message3',
        component: () => import('@/views/message/menu3/index'),
        meta: { title: '查凭证', icon: 'el-icon-document' }
      }
    ]
  },

  {
    path: '/nested',
    component: Layout,
    redirect: '/nested/menu1',
    name: 'Nested',
    meta: {
      title: '收支统计',
      icon: 'nested'
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/nested/menu1/index'),
        name: 'Menu1',
        meta: { title: '收入统计' }
      },
      {
        path: 'menu2',
        component: () => import('@/views/nested/menu2/index'),
        name: 'Menu2',
        meta: { title: '支出统计' }
      }
    ]
  },
  {
    path: '/blog',
    component: Layout,
    redirect: '/blog',
    name: 'Blog',
    meta: { title: '通知', icon: 'el-icon-s-help' },
    children: [
      {
        path: '/addBlog',
        name: 'addBlog',
        component: () => import('@/views/notification/addBlog/index'),
        meta: { title: '发布通知', icon: 'table' }
      },
      {
        path: '/viewBlog',
        name: 'viewBlog',
        component: () => import('@/views/notification/lookBlog'),
        meta: { title: '查看通知', icon: 'table' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
