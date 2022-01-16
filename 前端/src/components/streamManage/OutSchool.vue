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
        <el-input
          v-model="searchForm.Id"
          placeholder="学号"
          oninput ="value=value.replace(/[^0-9.]/g,'')"
          clearable
        ></el-input>
        
      </el-form-item>
      <el-form-item>
        <template>
          <el-select v-model="value" clearable placeholder="审批意见">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
        
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchRole" icon="el-icon-search"
          >查找</el-button
        >
      </el-form-item>
      <!-- <el-form-item>
        <el-button
          type="primary"
          @click="addDialogVisible = true"
          icon="el-icon-circle-plus-outline"
          >新增</el-button
        >
      </el-form-item> -->
      <el-form-item>
        <el-popconfirm title="确定批量删除这些吗？" @confirm="deleteLeaves">
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
      ref="tableData"
      :data="tableData"
      tooltip-effect="dark"
      border
      stripe
      style="width: 100%"
      :default-sort = "{prop: 'startDate', order: 'descending'}"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="name" label="姓名" width="70"> </el-table-column>
      <el-table-column prop="student_Id"  sortable label="学号" width="100">
      </el-table-column>
      <!-- <el-table-column prop="id" label="学号" width="150">
      </el-table-column>
      <el-table-column prop="id" label="学号" width="150">
      </el-table-column> -->
      <el-table-column prop="startDate"  sortable label="请假开始时间" width="170">
      </el-table-column>
      <el-table-column prop="endDate"  sortable label="请假结束时间" width="170">
      </el-table-column>
      <el-table-column prop="isLeave" label="是否离校" width="90">
      </el-table-column>
      <el-table-column prop="destination" label="目的地" width="150">
      </el-table-column>
      <el-table-column prop="reason" label="请假原因" width="90">
      </el-table-column>
      <el-table-column prop="evidence" label="核酸证明" width="90">
      </el-table-column>
      <el-table-column prop="statues" label="状态" width="90">
      </el-table-column>
      <el-table-column prop="examine" label="审批意见" width="110">
        <template v-slot="slotProps">
          <el-select 
          v-model="slotProps.row.examine" 
          placeholder="请选择"
          @change="changeSelect(slotProps.row.id,slotProps.row.examine)"
          >
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column prop="remark" label="备注" width="100">
      </el-table-column>
      <!-- <el-table-column prop="statu" width="160" label="状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.statu === '1'" type="success">正常</el-tag>
          <el-tag v-if="scope.row.statu === '0'" type="danger">禁用</el-tag>
        </template>
      </el-table-column> -->
      <el-table-column label="操作" width="170">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row.id)"
            >编辑</el-button
          >
          <!-- <el-button size="mini" @click="disAuth(scope.row.id)"
            >分配权限</el-button
          > -->
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
      width="38.2%"
      :before-close="closeDialog"
    >
      <el-form
        :model="addForm"
        :rules="rules"
        ref="addForm"
        label-width="100px"
        class="demo-ruleForm"
      >
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
        <el-form-item label="是否离校" prop="isLeave">
          <!-- <el-input v-model="addForm.isLeave"></el-input> -->
          <template >
          <el-select v-model="addForm.isLeave" clearable placeholder="是否离校">
            <el-option
              v-for="item in isLeaveOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          <el-input style="width:75%" v-model="addForm.destination"></el-input>
          <el-button style="width:20%" type="primary" @click="searchDestination">查询</el-button>
        </el-form-item>
        <el-form-item label="地址" prop="area">
          <el-input style="width:22%;padding-right:5px" v-model="areaForm.country"></el-input>
          <el-input style="width:22%;padding-right:5px" v-model="areaForm.province"></el-input>
          
          <el-input style="width:22%;padding-right:5px"  v-model="areaForm.city"></el-input>
          <el-input style="width:22%;padding-right:5px" v-model="areaForm.district"></el-input>
        </el-form-item>
        <el-form-item label="请假事由" prop="reason">
          <el-input v-model="addForm.reason"></el-input>
        </el-form-item>
        
        <el-form-item label="核酸证明" prop="evidence">
          <!-- <el-input v-model="addForm.evidence"></el-input> -->
          <template >
          <el-select v-model="addForm.evidence" clearable placeholder="核酸证明">
            <el-option
              v-for="item in evidenceOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
        </el-form-item>
        <el-form-item label="状态" prop="statues">
          <!-- <el-input v-model="addForm.statues"></el-input> -->
          <template >
          <el-select v-model="addForm.statues" clearable placeholder="状态">
            <el-option
              v-for="item in statuesOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
        </el-form-item>
        <el-form-item label="审批意见" prop="examine">
        <template >
          <el-select v-model="addForm.examine" clearable placeholder="审批意见">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
        
      </el-form-item>
      <el-form-item label="备注" prop="remark">
          <el-input
          type="textarea"
          :rows="2"
           v-model="addForm.remark"></el-input>
        </el-form-item>
        <!-- <el-form-item label="" prop="statu">
          <el-radio-group v-model="addForm.statu">
            <el-radio label="0">禁用</el-radio>
            <el-radio label="1">正常</el-radio>
          </el-radio-group>
        </el-form-item> -->
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
    <!-- <el-dialog
      title="分配权限"
      :visible.sync="disDialogVisible"
      width="30%"
      
    >
    <el-form :model="TreeData">    
    <el-tree
      :data="data"
      show-checkbox
      node-key="id"
      ref="AuthTree"
      default-expand-all
      check-strictly
      :props="defaultProps">
    </el-tree>
    </el-form>
    <span slot="footer" class="dialog-footer">
    <el-button @click="disDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="putData">确 定</el-button>
    </span>
    </el-dialog> -->
  </div>
</template>

<script>
import { request } from "@/axios/request"
import qs from 'qs'
export default {
  name: "Role",
  data() {
    return {
      //applyDisabled:true,
      applyDate:["2020-02-01 19:00:00", "2020-02-01 20:00:00"],
      addForm: {
        // id:null,
        // name: "",
        // code: "",
        // remark:"",
        // statu: "",
      },
      options: [
        {
          value: '未审批',
          label: '未审批'
        }, {
          value: '已审批',
          label: '已审批'
        }, {
          value: '已拒绝',
          label: '已拒绝'
        }],
      statuesOptions: [
      {
        value: '未出校',
        label: '未出校'
      }, {
        value: '已出校',
        label: '已出校'
      }, {
        value: '已归校',
        label: '已归校'
      }],
      areaForm:{
        country:null,
        province:null,
        city:null,
        district:null
      },
      evidenceOptions: [
      {
        value: '有',
        label: '有'
      }, {
        value: '无',
        label: '无'
      }],
      isLeaveOptions: [
      {
        value: '是',
        label: '是'
      }, {
        value: '否',
        label: '否'
      }],
      value: null,
      editvalue:null,
      data: [],
      loading:false,
      TreeData:{}, 
      currentRoleId:null,
      addDialogVisible: false,
      //disDialogVisible:false,
      searchForm: {
        Name: '',
        Id:null
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
          { required: true, message: "请输入角色名称", trigger: "blur" },
          { min: 3, max: 8, message: "长度在 3 到 8 个字符", trigger: "blur" },
        ],
        code: [
          { required: true, message: "请输入唯一状态码", trigger: "blur" },
        ],
        statu: [{ required: true, message: "请输入状态", trigger: "blur" }],
      },
       defaultProps: {
          children: 'children',
          label: 'name'
        },
    };
  },
  
  methods: {
    submitForm(addForm) {
      this.$refs[addForm].validate((valid) => {
        if (valid) {
          this.loading = true;

          this.puttableData();
 
        } else {
          alert("error submit!!");
          return false;
        }
      });
    },
    changeSelect(ex,examine){
      console.log(ex)
      console.log(examine)
      request({
        url:'/examine/'+ex+'/'+examine,
        method:'put',
        
      }).then(res=>{
        //this.gettableData()
        this.$message({
                message:res.data.msg,
                type:'success'
                })
      })
    },
    //查询位置
    searchDestination(){
      request({
        url:"/Address/"+this.addForm.destination,
        method:"get"
      }).then(res=>{
        if(res.data.stateCode==200){
          //this.applyDisabled = false
          
          this.areaForm.country=res.data.object.country=="[]" ? "":res.data.object.country  
          this.areaForm.province=res.data.object.province=="[]" ? "":res.data.object.province
          
          this.areaForm.city=res.data.object.city=="[]" ? "":res.data.object.city
          
          this.areaForm.district=res.data.object.district=="[]" ? "":res.data.object.district
          this.addForm.destination=this.areaForm.country+this.areaForm.province+this.areaForm.city+this.areaForm.district
          this.$message({
            message:res.data.msg,
            type:'success'
            })
        }else{
          //this.applyDisabled = true
          this.$message({
            message:res.data.msg,
            type:'error'
            })
        }
          
      })
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
        url: "/Leave",
        method: "get",
        params:{
            Name:this.searchForm.Name,
            Id:this.searchForm.Id,
            Examine:this.value,
            CurrentPage:this.page.CurrentPage,
            Size:this.page.Size,

        }
      }).then(res => {
        //this.tableData=[]
        //console.log(res.data)
        if(res.data.object.data==null){
          this.tableData = []
          this.page.Total=res.data.object.TotalCount;
        }else{
          this.tableData = res.data.object.data
          this.page.Total=res.data.object.TotalCount;
        }
        
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    closeDialog(done) {
      this.resetForm('addForm')
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
    deleteLeaves(){
      request({
        url:'/Leave',
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
    //查找符合条件的角色
    searchRole() {
      this.gettableData()
    },
    //修改请假信息
    puttableData() {
      this.addForm.startDate=this.applyDate[0]
      this.addForm.endDate=this.applyDate[1]
      this.loading = true
      request({
        url: "/Leave",
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
    //根据id回写审批信息
    handleEdit(id) {
      request({
        url: "/Leave/"+id,
        method: "get",
      }).then((res) => {
        this.addForm = res.data.object;
        this.applyDate=[],
        this.applyDate.push(res.data.object.startDate)
        this.applyDate.push(res.data.object.endDate)
        this.editvalue=this.addForm.examine
        this.addDialogVisible = true;
      });
    },
    //删除数据
    handleDelete(id) {
      this.selectIds=[]
      this.selectIds.push(id)
      this.deleteLeaves()
    },
   },
  created() {
    this.gettableData()
    //this.disAuthTree()
  },
}
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
