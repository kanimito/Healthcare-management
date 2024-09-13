<template>
    <div id="app">
      <el-table :data="doctorData" border style="width: 100%">
    <el-table-column prop="ppatitentId" label="病人身份证" align="center" width="240">
    </el-table-column>
    <el-table-column prop="pname" label="病人姓名" align="center" width="150">
    </el-table-column>
    <el-table-column prop="dname" label="医生姓名" align="center" width="200">
    </el-table-column>
    <el-table-column prop="radvice" label="医嘱" align="center" width="200">
    </el-table-column>
    <el-table-column prop="createTime" label="处方创建时间" align="center" width="211">
    </el-table-column>
  </el-table>
    </div>
  </template>

<script>
import { getDoctorRecord } from '@/api/admin';
export default {
  name: 'dotorRecords',

  data() {
    return {
      doctorData: [],
    };
  },

  mounted() {
    getDoctorRecord().then((resp) => {
      let result = resp.data;
      this.doctorData = result;
    })
    .catch((error) => {
      this.$message.error("请求出错啦！")
    })
  },

  methods: {
    
  },
};
</script>