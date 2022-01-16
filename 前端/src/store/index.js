import Vue from "vue";
import Vuex from 'vuex'
import router from '../router/index'
Vue.use(Vuex)

const actions = {

}
const mutations = {
    setToken(State, jwt) {
        State.Token = jwt
        localStorage.setItem("Token", jwt)
    },
    resetState: (state) => {
        state.menuList = []
        state.authList = []

        state.hasRoute = false
        state.editableTabsValue = 'Index'
        state.Token = ''
        state.editableTabs = [{
            title: '首页',
            name: 'Index',
        }]
    },

    setMenuList(State, menuList) {
        State.menuList = menuList
    },
    setAuthList(State, authList) {
        State.authList = authList
    },
    setRouteState(State, value) {
        State.hasRoute = value
    },
    addTab(State, child) {
        let count = 0
        State.editableTabs.forEach(tab => { //遍历标签
            if (tab.name === child.path) {
                count += 1
            }
        });
        if (count === 0) { //标签列表中没有
            State.editableTabs.push({ //添加标签
                title: child.tabsName,
                name: child.path,
            });
        }
        State.editableTabsValue = child.path;
    },
    removeTab(State, targetName) {

        let tabs = State.editableTabs;
        let activeName = State.editableTabsValue;
        if (targetName === '/home/index') { //不可删除首页标签
            return
        }
        if (activeName === targetName) {
            tabs.forEach((tab, index) => {
                if (tab.name === targetName) {
                    let nextTab = tabs[index + 1] || tabs[index - 1];
                    if (nextTab) {
                        activeName = nextTab.name;
                        router.push(activeName)
                    }
                }
            });
        }
        State.editableTabsValue = activeName;
        State.editableTabs = tabs.filter(tab => tab.name !== targetName);
    }
}
const state = {
    //动态路由
    menuList: [],
    authList: [],
    hasRoute: false,

    Token: '',

    //标签页
    editableTabsValue: '/home/index',
    editableTabs: [{
        title: '首页',
        name: '/home/index'
    }],
}
export default new Vuex.Store({
    actions,
    mutations,
    state
})