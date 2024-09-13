<template>
    <div id="app">
      <el-table v-loading="loading" :data="orderData" borderstyle="width: 100%">
        <el-table-column fixed prop="drugId" label="id" >
        </el-table-column>
        <el-table-column prop="drugName" label="药品名" >
        </el-table-column>
        <el-table-column prop="drugIntoPrice" label="进价" >
        </el-table-column>
        <el-table-column prop="drugExitPrice" label="售价" >
        </el-table-column>
        <el-table-column prop="drugQuantity" label="药品数量" > </el-table-column>
        <el-table-column prop="drugUnit" label="药品单位" > </el-table-column>
        <el-table-column prop="drugStorage" label="存储位置" >
        </el-table-column>
        <el-table-column prop="drugDate" label="生产日期" >
        </el-table-column>
        <el-table-column prop="usefullLife" label="有效期" >
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >查看</el-button
            >
            <el-button
              @click="openEditOrderDialog(scope.row.eoId)"
              type="text"
              size="small"
              >编辑</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <!--分页-->
      <!--<el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="page.pageNow"
        :page-sizes="[2,4,6,8]"
        :page-size="page.pageSize"
        layout="total,sizes, prev, pager, next,jumper"
        :total="page.total">
      </el-pagination>
      -->
      <!--编辑对话框-->
      <!--<el-dialog title="用户名" :visible.sync="editDialogFormVisible">
        <el-form :model="orderInfo">
          <el-form-item label="id">
            <el-input v-moddel="orderInfo.id" clearable></el-input>
          </el-form-item>
        </el-form>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="orderInfo.password" autocomplete="off"></el-input>
        </el-form-item>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="editDialogFormVisible = false">
            确 定</el-button
          >
        </div>
      </el-dialog>-->
    </div>
  </template>
  
  <script>
  import { selectDrugsList } from "@/api/doctor";
  export default {
    name: 'sysdoctor',
  
    data() {
      return {
        orderData:[],
        loading:true,
        editDialogFormVisible: false,
        orderInfo:{
            drugId:null,
            drugName:null,
            drugIntoPrice:null,
            drugExitPrice:null,
            drugQuantity:null,
            drugUnit:null,
            parentdrugStorageId:null,
            drugDate:null,
            usefullLife:null,
        }
      };
    },
  
    mounted() {
      this.getList();
    },
  
    methods: {
      getList(){
        selectDrugsList().then((response)=>{
          console.log(response);
          this.orderData = response.data;
            //关闭加载遮罩
          this.loading=false;
        })
    },
      //打开编辑对话框
      openEditOrderDialog(orderId) {
        this.editDialogFormVisible = true;
        //发送ajax请求从后台拉取数据
      },
      handleClick(row) {
        console.log(row);
      },
    },
  };
  </script>