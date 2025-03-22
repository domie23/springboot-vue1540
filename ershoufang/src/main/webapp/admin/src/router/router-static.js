import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

         import users from '@/views/modules/users/list'
        import chuzu from '@/views/modules/chuzu/list'
        import chuzuCollection from '@/views/modules/chuzuCollection/list'
        import chuzuLiuyan from '@/views/modules/chuzuLiuyan/list'
        import dictionary from '@/views/modules/dictionary/list'
        import forum from '@/views/modules/forum/list'
        import gonggao from '@/views/modules/gonggao/list'
        import maifang from '@/views/modules/maifang/list'
        import maifangCollection from '@/views/modules/maifangCollection/list'
        import maifangLiuyan from '@/views/modules/maifangLiuyan/list'
        import xiaoqu from '@/views/modules/xiaoqu/list'
        import yonghu from '@/views/modules/yonghu/list'
        import config from '@/views/modules/config/list'
        import dictionaryChaoxiang from '@/views/modules/dictionaryChaoxiang/list'
        import dictionaryChuzu from '@/views/modules/dictionaryChuzu/list'
        import dictionaryChuzuCollection from '@/views/modules/dictionaryChuzuCollection/list'
        import dictionaryFangxing from '@/views/modules/dictionaryFangxing/list'
        import dictionaryForum from '@/views/modules/dictionaryForum/list'
        import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
        import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
        import dictionaryMaifang from '@/views/modules/dictionaryMaifang/list'
        import dictionaryMaifangCollection from '@/views/modules/dictionaryMaifangCollection/list'
        import dictionaryQuyu from '@/views/modules/dictionaryQuyu/list'
        import dictionarySex from '@/views/modules/dictionarySex/list'
        import dictionaryShangquan from '@/views/modules/dictionaryShangquan/list'
        import dictionaryWuye from '@/views/modules/dictionaryWuye/list'
        import dictionaryXiaoqu from '@/views/modules/dictionaryXiaoqu/list'
        import dictionaryYizu from '@/views/modules/dictionaryYizu/list'
        import dictionaryZhuangxiu from '@/views/modules/dictionaryZhuangxiu/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryChaoxiang',
        name: '房屋朝向',
        component: dictionaryChaoxiang
    }
    ,{
        path: '/dictionaryChuzu',
        name: '出租类型名称',
        component: dictionaryChuzu
    }
    ,{
        path: '/dictionaryChuzuCollection',
        name: '收藏表类型',
        component: dictionaryChuzuCollection
    }
    ,{
        path: '/dictionaryFangxing',
        name: '房屋类型名称',
        component: dictionaryFangxing
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型名称',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型名称',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryMaifang',
        name: '是否卖出',
        component: dictionaryMaifang
    }
    ,{
        path: '/dictionaryMaifangCollection',
        name: '收藏表类型',
        component: dictionaryMaifangCollection
    }
    ,{
        path: '/dictionaryQuyu',
        name: '区域类型名称',
        component: dictionaryQuyu
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型名称',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangquan',
        name: '商圈类型名称',
        component: dictionaryShangquan
    }
    ,{
        path: '/dictionaryWuye',
        name: '物业公司类型名称',
        component: dictionaryWuye
    }
    ,{
        path: '/dictionaryXiaoqu',
        name: '建筑类型名称',
        component: dictionaryXiaoqu
    }
    ,{
        path: '/dictionaryYizu',
        name: '是否出租',
        component: dictionaryYizu
    }
    ,{
        path: '/dictionaryZhuangxiu',
        name: '装修类型名称',
        component: dictionaryZhuangxiu
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/chuzu',
        name: '出租',
        component: chuzu
      }
    ,{
        path: '/chuzuCollection',
        name: '出租收藏',
        component: chuzuCollection
      }
    ,{
        path: '/chuzuLiuyan',
        name: '出租留言',
        component: chuzuLiuyan
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/maifang',
        name: '卖房',
        component: maifang
      }
    ,{
        path: '/maifangCollection',
        name: '卖房收藏',
        component: maifangCollection
      }
    ,{
        path: '/maifangLiuyan',
        name: '卖房留言',
        component: maifangLiuyan
      }
    ,{
        path: '/xiaoqu',
        name: '小区',
        component: xiaoqu
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
