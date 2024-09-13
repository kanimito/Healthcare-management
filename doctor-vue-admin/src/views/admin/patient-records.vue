<template>
    <div id="app">
      <el-table :data="patientData" border style="width: 100%">
    <el-table-column prop="rgNum" label="挂号编号" align="center" width="100">
    </el-table-column>
    <el-table-column prop="ppatientId" label="病人身份证" align="center" width="173">
    </el-table-column>
    <el-table-column prop="pname" label="病人姓名" align="center" width="100">
    </el-table-column>
    <el-table-column prop="psex" label="病人性别" align="center" width="103">
    </el-table-column>
    <el-table-column prop="page" label="病人年龄" align="center" width="105">
    </el-table-column>
    <el-table-column prop="rgCreatetime" label="挂号时间" align="center" width="147">
    </el-table-column>
    <el-table-column prop="rgStatus" label="挂号状态" align="center" width="147">
      <template slot-scope="scope">
          <el-tag disable-transition v-if="scope.row.rgStatus === 0">
            未叫号
          </el-tag>
          <el-tag disable-transition v-else-if="scope.row.rgStatus === 1">
            已叫号
          </el-tag>
          <el-tag disable-transition v-else-if="scope.row.rgStatus === 2">
            就诊中
          </el-tag>
          <el-tag disable-transition v-else>
            就诊完
          </el-tag>
        </template>
    </el-table-column>
    <el-table-column prop="radvice" label="就诊疾病" align="center" width="147">
    </el-table-column>
    <el-table-column prop="dname" label="就诊医生" align="center" width="147">
    </el-table-column>
    <el-table-column prop="createTime" label="就诊时间" align="center" width="132">
    </el-table-column>
  </el-table>
    </div>
  </template>

<script>
import { getPatientRecord } from "@/api/admin";

export default {
  name: 'PatientRecords',

  data() {
    return {
      patientData: [],
    };
  },

  mounted() {
    getPatientRecord().then((resp) => {
      let result = resp.data;
      this.patientData = result;
    })
    .catch((error) => {
      this.$message.error("请求出错啦！")
    })
  },

  methods: {
    
  },
};
</script>