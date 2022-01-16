<template>
  <div>
    <el-form :inline="true" class="demo-form-inline" v-model="searchForm">
      <el-form-item>
        <el-input
          v-model="searchForm.Name"
          placeholder="姓名"
          clearable
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchRole" icon="el-icon-search"
          >查找</el-button
        >
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          @click="addDialogVisible = true,editId=false"
          icon="el-icon-circle-plus-outline"
          >新增</el-button
        >
      </el-form-item>
      <el-form-item>
        <el-popconfirm title="确定批量删除这些吗？" @confirm="deleteRoles">
          <el-button
            type="danger"
            slot="reference"
            icon="el-icon-delete-solid"
            :disabled="delButSta"
            >批量删除</el-button
          >
        </el-popconfirm>
      </el-form-item>
    </el-form>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      border
      stripe
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="name" label="姓名" width="150"> </el-table-column>
      <el-table-column prop="id" label="学号" width="150"></el-table-column>
        <el-table-column prop="sex" label="性别" width="100">
      </el-table-column>
      <el-table-column prop="college" label="学院" width="200">
      </el-table-column>
      <el-table-column prop="grade" label="班级" width="150">
      </el-table-column>
      <el-table-column prop="phone" label="手机号" width="150">
      </el-table-column>
      <!-- <el-table-column prop="statu" width="160" label="状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.statu === '1'" type="success">正常</el-tag>
          <el-tag v-if="scope.row.statu === '0'" type="danger">禁用</el-tag>
        </template>
      </el-table-column> -->
      <el-table-column label="操作" width="339">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row.id)"
            >编辑</el-button
          >
          <el-button size="mini" @click="apply(scope.row.id)"
            >请假</el-button
          >
          <el-popconfirm
            title="这是一段内容确定删除吗？"
            @confirm="handleDelete(scope.row.id)"
          >
            <el-button slot="reference" type="danger" size="small"
              >删除</el-button
            >
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="page.CurrentPage"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="page.Size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="page.Total"
    >
    </el-pagination>
    <el-dialog
      title="编辑"
      :visible.sync="addDialogVisible"
      width="30%"
      :before-close="closeDialog"
      
    >
      <el-form
        :model="addForm"
        :rules="rules"
        ref="addForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>
        <!-- <el-form-item label="学号" prop="id"  >
          <el-input v-model="addForm.id" :disabled="editId"></el-input>
        </el-form-item> -->
        <el-form-item label="性别" prop="sex">
          <el-input v-model="addForm.sex"></el-input>
        </el-form-item>
        <el-form-item label="学院" prop="college">
          <el-input v-model="addForm.college"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="grade">
          <el-input v-model="addForm.grade"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="addForm.phone"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            size="small"
            @click="submitForm('addForm')"
            :loading="loading"
            >立即创建</el-button
          >
          <el-button @click="resetForm('addForm')" size="small">重置</el-button>
          <el-button @click="addDialogVisible = false" size="small"
            >取 消</el-button
          >
        </el-form-item>
      </el-form>

    </el-dialog>
    <el-dialog
      title="请假"
      :visible.sync="applyDialog"
      width="38.2%"
      :before-close="closeApplyDialog"
      
    >
      <el-form
        :model="applyForm"
        :rules="applyRules"
        ref="applyForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <!-- <el-form-item label="开始日期" prop="startDate">
          <el-input v-model="applyForm.startDate"></el-input>
        </el-form-item> -->
        <!-- <el-form-item label="学号" prop="id"  >
          <el-input v-model="addForm.id" :disabled="editId"></el-input>
        </el-form-item> -->
        <el-form-item label="请假时间" prop="applyDate">
          <el-date-picker
            v-model="applyDate"
            :clearable="false"
            type="datetimerange"
            range-separator="至"
            start-placeholder="开始日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            end-placeholder="结束日期">
          </el-date-picker>
        </el-form-item>
        <!-- <el-form-item label="结束日期" prop="endDate">
          <el-input v-model="addForm.endDate"></el-input>
        </el-form-item> -->
        <el-form-item label="目的地" prop="destination">
          <el-input style="width:75%" v-model="applyForm.destination"></el-input>
          <el-button style="width:20%" type="primary" @click="searchDestination">查询</el-button>
        </el-form-item>
        <el-form-item label="地址" prop="area">
          <el-input style="width:22%;padding-right:5px" v-model="applyForm.country"></el-input>
          <el-input style="width:22%;padding-right:5px" v-model="applyForm.province"></el-input>
          
          <el-input style="width:22%;padding-right:5px"  v-model="applyForm.city"></el-input>
          <el-input style="width:22%;padding-right:5px" v-model="applyForm.district"></el-input>
        </el-form-item>
        <el-form-item label="请假事由" prop="reason">
          <el-input v-model="applyForm.reason"></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input
          type="textarea"
          :rows="2"
           v-model="applyForm.remark"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            size="small"
            @click="submitApplyForm('applyForm')"
            :loading="loading"
            :disabled="this.applyDisabled"
            >立即申请</el-button
          >
          <el-button @click="resetForm('applyForm')" size="small">重置</el-button>
          <el-button @click="closeApplyDialog = false" size="small"
            >取 消</el-button
          >
        </el-form-item>
      </el-form>
      
    </el-dialog>
  </div>
</template>

<script>
import { request } from "@/axios/request"
import qs from 'qs'
export default {
  name: "Student",
  data() {
    return {
      applyDisabled:true,
      applyDate:["2020-02-01 19:00:00", "2020-02-01 20:00:00"],
      applyForm:{
        id:null,
        startDate:null,
        endDate:null,
        destination:null,
        reason:null,
        remark:null,
        country:null,
        province:null,
        city:null,
        district:null
      },
      applyDialog:false,
      data: [],
      loading:false,
      TreeData:{}, 
      currentRoleId:null,
      editId:false,
      addDialogVisible: false,
      disDialogVisible:false,
      searchForm: {
        Name: "",
      },
      addForm: {
        name: '',
        id:'',
        sex: '',
        college:'',
        phone: '',
      },
      page: {
        Size: 10,
        CurrentPage: 1,
        Total: null
      },
      selectIds:[],
      delButSta: true,
      tableData: [],
      rules: {
        name: [
          { required: true, message: "请输入姓名", trigger: "blur" },
          { min: 1, max: 8, message: "长度在 1 到 8 个字符", trigger: "blur" },
        ],
        id: [ 
          { required: true, message: "请输入学号", trigger: "blur" },
          { min: 1, max: 10, message: "长度在 1 到 10 个字符", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "请输入手机号", trigger: "blur" },
        ],
        college: [{ required: true, message: "请输入学院", trigger: "blur" }],
      },
      applyRules: {
        destination: [
          { required: true, message: "请输入目的地", trigger: "blur" },
    
        ],
        reason: [ 
          { required: true, message: "请输入原因", trigger: "blur" },
        
        ]
      },
       defaultProps: {
          children: 'children',
          label: 'name'
        },
    };
  },
  created() {
    this.gettableData()
  },
  methods: {
    submitApplyForm(applyForm){
      this.$refs[applyForm].validate((valid) => {
        if (valid) {
          this.loading = true;
          console.log(this.applyForm.id)
            request({
              url: "/examine",
              method: "post",
              data: {
                "student_id":this.applyForm.id,
                "startdate":this.applyDate[0],
                "enddate":this.applyDate[1],
                "reason":this.applyForm.reason,
                "destination":this.applyForm.country+this.applyForm.province+
                this.applyForm.city+this.applyForm.district,
                "remark":this.applyForm.remark
              },
            }).then(res => {       
              this.applyDialog = false
              this.$message({
                message:res.data.msg,
                type:'success'
                })
            })
            this.loading = false
            this.resetForm('applyForm')
      
        } else {
          alert("error submit!!");
          return false;
        }
      })
    },
    submitForm(addForm) {
      this.$refs[addForm].validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.addForm.id) {
            //console.log("1")
            this.puttableData(this.addForm.id);
          } else {
            
            request({
              url: "/student",
              method: "post",
              data: this.addForm,
            }).then(res => {       
              this.addDialogVisible = false
              this.$message({
                message:res.data.msg,
                type:'success'
                })
              this.gettableData()
            })
            this.loading = false
            this.resetForm('addForm')
            
          }
        } else {
          alert("error submit!!");
          return false;
        }
      });
    },
   
    //获取所有已经选择的id
    handleSelectionChange(val){
        this.selectIds=[]
        if(val.length!==0){
            val.forEach(element => {
            this.selectIds.push(element.id)
            })
            this.delButSta=false
        }else{
            this.delButSta=true
        }
    },
    //获取所有数据
    gettableData() {
    
        request({
        url: "/student",
        method: "get",
        params:{
            Name:this.searchForm.Name,
            CurrentPage:this.page.CurrentPage,
            Size:this.page.Size
        }
      }).then(res => {
        
          this.tableData = res.data.object.data
          this.page.Total=res.data.object.TotalCount;
        
      });
      
    },
    //请假
    apply(id){
      this.applyDialog=true
      this.applyForm.id=id 
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    closeDialog(done) {
      this.resetForm('addForm')
      this.loading=false
      done()
    },
    closeApplyDialog(done){
      this.resetForm('applyForm')
      this.loading=false
      done()
    },
    handleSizeChange(val) {
      this.page.Size=val
      this.gettableData()
    },
    handleCurrentChange(val) {
      this.page.CurrentPage=val
      this.gettableData()
    },
    //批量删除数据
    deleteRoles(){
      request({
        url:'/student',
        method:'delete',
        params:{
          ids:this.selectIds
        },
         paramsSerializer: params => {
      return qs.stringify(params, { indices: false })
    }
      }).then(res=>{
        this.delButSta=false
        this.gettableData()
        this.$message({
          message:res.data.msg,
          type:'success'
          })  
      })
    },
    searchDestination(){
      request({
        url:"/Address/"+this.applyForm.destination,
        method:"get"
      }).then(res=>{
        if(res.data.stateCode==200){
          this.applyDisabled = false
          this.applyForm.country=res.data.object.country=="[]" ? "":res.data.object.country
          this.applyForm.province=res.data.object.province=="[]" ? "":res.data.object.province
          this.applyForm.city=res.data.object.city=="[]" ? "":res.data.object.city
          this.applyForm.district=res.data.object.district=="[]" ? "":res.data.object.district
          this.$message({
            message:res.data.msg,
            type:'success'
            })
        }else{
          this.applyDisabled = true
          this.$message({
            message:res.data.msg,
            type:'error'
            })
        }
          
      })
    },
    //查找符合学生的角色
    searchRole() {
      this.gettableData()
    },
    //修改学生信息
    puttableData(id) {
      
      this.loading = true
      request({
        url: "/student",
        method: "put",
        data: this.addForm,
      }).then(res => {   
        this.addDialogVisible = false
        this.$message({
          message:res.data.msg,
          type:'success'
          })      
        this.gettableData()
      })    
      this.loading = false 
      this.resetForm('addForm')
      
    },
    //根据id回写学生信息
    handleEdit(id) {
      this.editId=true
      request({
        url: "/student/" + id,
        method: "get",
      }).then((res) => {
        this.$nextTick(() => { // 注意看这里
          this.addForm = res.data.object;
        this.addDialogVisible = true;
        })
        
      });
    },
    // //分配按钮点击事件
    // disAuth(id){
    //   this.currentRoleId=id
    //   this.disDialogVisible=true     
    //   request({
    //     url:'/role/menu/'+id,
    //     method:'get'
    //   }).then(res=>{
    //     this.$refs.AuthTree.setCheckedKeys(res.data.object)
    //   })
    // },
    //删除数据
    handleDelete(id) {
    this.selectIds=[]
    this.selectIds.push(id)
    this.deleteRoles()
  },
  
}}
</script>

<style scoped>
.el-pagination {
  float: right;
}
.el-form {
  padding-right: 40px;
}
.el-button{
  margin-right: 7px;
  margin-left: 10px;
}
</style>
