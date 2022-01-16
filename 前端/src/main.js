import Vue from 'vue';
import App from './App.vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router';
import store from './store/index';
import dataV from '@jiaminghi/data-view';
import './static/less/common.less';
// import echarts from 'echarts'
// Vue.prototype.$echarts = echarts
Vue.use(dataV)
Vue.use(ElementUI)
Vue.config.productionTip = false
new Vue({
    router,
    store: store,
    render: h => h(App)
}).$mount('#app')