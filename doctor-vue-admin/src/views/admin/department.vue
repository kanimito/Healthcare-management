<template>
  <div id="app">
    <el-row>
      <el-button type="primary" @click="addDepartmentInfo()">增加科室信息 <i class="el-icon-circle-plus-outline"
          style="font-size: large;"></i></el-button>
    </el-row>

    <template>
      <el-tabs v-model="activeName" @tab-click="handleTabClick">
        <el-tab-pane label="主科室" name="first">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="dcId" label="科室小类ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dcName" label="主科室" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcParentId" label="科室大类ID" align="center" width="150">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="内科" name="second">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="外科" name="third">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="妇产科" name="fourth">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="儿科" name="fifth">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="五官科" name="sixth">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="肿瘤科" name="seventh">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="中医科" name="eighth">
          <el-table v-loading="loading" :data="departmentData" border style="width: 100%">
            <el-table-column prop="did" label="科室ID" align="center" width="100">
            </el-table-column>
            <el-table-column prop="dpName" label="科室名称" align="center" width="173">
            </el-table-column>
            <el-table-column prop="daddress" label="科室地址" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dphone" label="科室电话" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcId" label="大科室编号" align="center" width="173">
            </el-table-column>
            <el-table-column prop="dcChildId" label="小科室编号" align="center" width="173">
            </el-table-column>
          </el-table>
        </el-tab-pane>
      </el-tabs>
    </template>

    <!-- 增加信息框 -->
    <el-dialog title="增加科室信息" :visible.sync="addDialogFormVisible">
      <el-form :model="departmentInfo" label-width="85px">
        <el-form-item label="科室名称">
          <el-input v-model="departmentInfo.dpName"></el-input>
        </el-form-item>
        <el-form-item label="科室地址">
          <el-input v-model="departmentInfo.daddress"></el-input>
        </el-form-item>
        <el-form-item label="科室电话">
          <el-input v-model="departmentInfo.dphone"></el-input>
        </el-form-item>
        <el-form-item label="大科室编号">
          <el-input v-model="departmentInfo.dcId"></el-input>
        </el-form-item>
        <el-form-item label="小科室编号">
          <el-input v-model="departmentInfo.dcChildId"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addDepartment">增加</el-button>
      </div>
    </el-dialog>
  </div>
</template>
  
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  /* min-height: 400px; */
}
</style>

<script>
import { getDepartmentList, getDepartmentList1, getDepartmentList2, getDepartmentList3, } from "@/api/admin";
import { getDepartmentList4, getDepartmentList5, getDepartmentList6, getDepartmentList7, } from "@/api/admin";
import { insertDepartment } from "@/api/admin";

export default {
  name: 'Department',

  data() {
    return {
      activeName: 'first',
      departmentData: [],
      loading: true,
      addDialogFormVisible: false,
      departmentInfo:
      {
        "dId": null,
        "dpName": null,
        "dAddress": null,
        "dPhone": null,
        "dcId": null,
        "dcChildId": null
      }
    };
  },

  mounted() {
    this.getDepartment();
    // this.getDepartment1();
  },

  methods: {
    getDepartment() {
      //获取主科室数据
      getDepartmentList().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment1() {
      //获取内科数据
      getDepartmentList1().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment2() {
      //获取外科数据
      getDepartmentList2().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment3() {
      //获取妇产科数据
      getDepartmentList3().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment4() {
      //获取儿科数据
      getDepartmentList4().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment5() {
      //获取五官科数据
      getDepartmentList5().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment6() {
      //获取肿瘤科数据
      getDepartmentList6().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    getDepartment7() {
      //获取中医科数据
      getDepartmentList7().then((resp) => {
        let result = resp.data;
        this.departmentData = result;
        this.loading = false;
      })
        .catch((error) => {
          this.$message.error("请求出错啦！");
          this.loading = false;
        });
    },
    mainDepartment() {
      this.getDepartment();
    },
    internalMedicine() {
      this.getDepartment1();
    },
    surgery() {
      this.getDepartment2();
    },
    obstetricsGynecology() {
      this.getDepartment3();
    },
    pediatrics() {
      this.getDepartment4();
    },
    otorhinolaryngology() {
      this.getDepartment5();
    },
    oncology() {
      this.getDepartment6();
    },
    tcm() {
      this.getDepartment7();
    },
    //标签卡点击事件
    handleTabClick(tab) {
      switch (tab.name) {
        case 'first':
          this.mainDepartment();
          break;
        case 'second':
          this.internalMedicine();
          break;
        case 'third':
          this.surgery();
          break;
        case 'fourth':
          this.obstetricsGynecology();
          break;
        case 'fifth':
          this.pediatrics();
          break;
        case 'sixth':
          this.otorhinolaryngology();
          break;
        case 'seventh':
          this.oncology();
          break;
        case 'eighth':
          this.tcm();
          break;
        default:
          break;
      }
    },
    //添加科室信息
    addDepartment() {
      insertDepartment(this.departmentInfo)
        .then((resp) => {
          this.$message.success("科室信息添加成功！")
          this.addDialogFormVisible = false;
          this.getDepartmentList1();
        })
    },
    addDepartmentInfo() {
      this.addDialogFormVisible = true;
    }
  },
};
</script>