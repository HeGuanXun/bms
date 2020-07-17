import Vue from "vue";
import VueRouter from "vue-router";
if (!window.VueRouter) Vue.use(VueRouter);

const routes = [
  { path: "/login", component: () => import("views/login") },
  {
    path: "",
    name: "index",
    redirect: "/home",
    component: () => import("views/layout"),
    children: [
      {
        path: "home",
        name: "home",
        component: () => import("views/home"),
        meta: { title: "首页" }
      }
    ]
  }
];

const router = new VueRouter({
  routes
});

//路由守卫
router.beforeEach((to, from, next) => {
  next();
  // let store = JSON.parse(window.sessionStorage.getItem("yl-platForm-sess-state"));
  // if (store?.common?.token) {
  //   if (to.path === "/home") {
  //     next({ path: "/home" });
  //     eventBus.$emit("titleChange", "首页");
  //   } else {
  //     if (to.path != "/home") {
  //       let hasPath = store.common.nav.find(_item => {
  //         return  _item.url === to.path
  //       });
  //       if (hasPath) {
  //         next();
  //       } else {
  //         next({ path: "/home" });
  //       }
  //     } else {
  //       next();
  //     }
  //   }
  // } else {
  //   if (to.path === "/home") {
  //     //loop
  //     next();
  //   } else {
  //     next({ path: "/home" });
  //   }
  // }
});

export default router;
