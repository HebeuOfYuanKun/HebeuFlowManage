<template>
  <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab" @tab-click="changeCon(editableTabsValue)">
  <el-tab-pane
    v-for="(item, index) in editableTabs"
    :key="item.name"
    :label="item.title"
    :name="item.name"
    
  >
    {{item.content}}
  </el-tab-pane>
</el-tabs>
</template>

<script>
    export default {
        name:'Tabs',
        data() {
      return {
        // editableTabsValue: this.$store.state.editableTabsValue,
        // editableTabs: this.$store.state.editableTabs,
      }
    },
    computed:{
        editableTabsValue:{
            get(){
                return this.$store.state.editableTabsValue
            },
            set(val){
                this.$store.state.editableTabsValue=val
            }
        },
        editableTabs:{
            get(){
                return this.$store.state.editableTabs
            },
            set(val){
                this.$store.state.editableTabs=val
            }
        }
    },
    methods: {
    removeTab(targetName){
        this.$store.commit('removeTab',targetName)
    },
    changeCon(editableTabsValue){
      //console.log(this)
         //console.log(this.$route.path)
        // if(editableTabsValue!=this.$store.state.editableTabsValue){
          if(this.$route.path!=this.$store.state.editableTabsValue){
            this.$router.push({
              path:this.$store.state.editableTabsValue
        })
          }
           
        // }
        
    }
    }
  }
</script>
<style scoped>
.el-tables{
    padding: 0px;
}
</style>