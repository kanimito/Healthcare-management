<template>
  <div id="app">
    <el-table v-loading="loading" :data="orderData" borderstyle="width: 100%">
      <el-table-column fixed prop="rgNum" label="挂号编号">
      </el-table-column>
      <el-table-column prop="pname" label="姓名">
      </el-table-column>
      <el-table-column prop="psex" label="性别">
      </el-table-column>
      <el-table-column prop="page" label="年龄"> </el-table-column>
      <el-table-column prop="rgStatus" label="状态码"> </el-table-column>
      <el-table-column prop="realName" label="负责医生"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="jiaohao(scope.row)" v-if="scope.row.rgStatus === 0">叫号</el-button>
          <el-button @click="huizhen(scope.row)" v-else-if="scope.row.rgStatus === 1">会诊</el-button>
          <el-tag disable-transition v-else-if="scope.row.rgStatus === 2">
            会诊中
          </el-tag>
          <el-tag disable-transition v-else-if="scope.row.rgStatus === 3">
            会诊完成
          </el-tag>
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
import { jiaohao1, selectPatientPage,huizhenye } from "@/api/doctor";
export default {
  name: 'syspatientpage',

  data() {
    return {
      orderData: [],
      loading: true,
      editDialogFormVisible: false,
      orderInfo: {
        rgNum: null,
        pName: null,
        pSex: null,
        pAge: null,
        rgStatus: null,
        username: null,
      }
    };
  },

  mounted() {
    this.getList();
  },

  methods: {
    getList() {
      selectPatientPage().then((response) => {
        console.log(response);
        this.orderData = response.data;
        //关闭加载遮罩
        this.loading = false;
      })
    },
    huizhen(row) {
       huizhenye({id:row.rgNum}).then((result) => {
         if (result.code == 0) {
           this.$message({
            message: result.message,
             type: 'success'
           });
           this.getList();
           console.log(row.rgNum);
           
           this.$router.push({path:'/doctorsys/seedoctor',query: {id:row.rgNum}});
        }
       }).catch((err) => {
         this.$message.error('网络连接错误');
       });
    },
    jiaohao(row) {
      console.log(row);
      jiaohao1({id:row.rgNum}).then((result) => {
        if (result.code == 0) {
          this.$message({
            message: result.data,
            type: 'success'
          });
          this.getList();
        }
      }).catch((err) => {
        this.$message.error('网络连接错误');
      });
    }
  },
};
</script>
