<template>
  <div id="app">
    <el-row>
      <el-button type="primary" @click="addDrugInfo()">增加药品信息
        <i class="el-icon-circle-plus-outline" style="font-size: large"></i></el-button>
    </el-row>
    <el-table :data="drugsData" border style="width: 100%">
      <el-table-column prop="drugId" label="药品编号" align="center" width="100">
      </el-table-column>
      <el-table-column prop="drugName" label="药品名称" align="center" width="132">
      </el-table-column>
      <el-table-column prop="drugIntoPrice" label="药品进价" align="center" width="132">
      </el-table-column>
      <el-table-column prop="drugExitPrice" label="药品售价" align="center" width="125">
      </el-table-column>
      <el-table-column prop="drugQuantity" label="药品数量" align="center" width="125">
      </el-table-column>
      <el-table-column prop="drugUnit" label="药品单位" align="center" width="125">
      </el-table-column>
      <el-table-column prop="drugStorage" label="存放位置" align="center" width="132">
      </el-table-column>
      <el-table-column prop="drugDate" label="生产日期" align="center" width="132">
      </el-table-column>
      <el-table-column prop="usefullLife" label="有效日期" align="center" width="132">
      </el-table-column>
      <el-table-column label="操作" align="center" width="175">
        <template slot-scope="scope">
          <el-button @click="seeDetail(scope.row.drugId)" type="text" size="small"><i
              class="el-icon-view el-icon--right"></i>查看</el-button>
          <el-button @click="openEditDrug(scope.row.drugId)" type="text" size="small"
            icon="el-icon-edit-outline">编辑</el-button>
          <el-button @click="delDrug(scope.row.drugId)" type="text" size="small" icon="el-icon-delete"
            style="color: red">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 查看详情对话框 -->
    <el-dialog title="查看药品详情" :visible.sync="seeDetailDialogVisible">
      <el-form :model="drugsInfo">
        <el-descriptions title="查看药品" border>
          <el-descriptions-item label="药品编号">{{
            drugsInfo.drugId
          }}</el-descriptions-item>
          <el-descriptions-item label="药品名称">{{
            drugsInfo.drugName
          }}</el-descriptions-item>
          <el-descriptions-item label="药品进价">{{
            drugsInfo.drugIntoPrice
          }}</el-descriptions-item>
          <el-descriptions-item label="药品售价">{{
            drugsInfo.drugExitPrice
          }}</el-descriptions-item>
          <el-descriptions-item label="药品数量">{{
            drugsInfo.drugQuantity
          }}</el-descriptions-item>
          <el-descriptions-item label="药品单位">{{
            drugsInfo.drugUnit
          }}</el-descriptions-item>
          <el-descriptions-item label="存放位置">{{
            drugsInfo.drugStorage
          }}</el-descriptions-item>
          <el-descriptions-item label="生产日期">{{
            drugsInfo.drugDate
          }}</el-descriptions-item>
          <el-descriptions-item label="有效日期">{{
            drugsInfo.usefullLife
          }}</el-descriptions-item>
        </el-descriptions>
      </el-form>
      <span slot="footer">
        <el-button @click="seeDetailDialogVisible = false">关闭</el-button>
      </span>
    </el-dialog>

    <!-- 编辑对话框 -->
    <el-dialog title="编辑药品信息" :visible.sync="editDialogFormVisible">
      <el-form :model="drugsInfo" label-width="85px">
        <el-form-item label="药品编号">
          <el-input v-model="drugsInfo.drugId"></el-input>
        </el-form-item>
        <el-form-item label="药品名称">
          <el-input v-model="drugsInfo.drugName"></el-input>
        </el-form-item>
        <el-form-item label="药品进价">
          <el-input v-model="drugsInfo.drugIntoPrice"></el-input>
        </el-form-item>
        <el-form-item label="药品售价">
          <el-input v-model="drugsInfo.drugExitPrice"></el-input>
        </el-form-item>
        <el-form-item label="药品数量">
          <el-input v-model="drugsInfo.drugQuantity"></el-input>
        </el-form-item>
        <el-form-item label="药品单位">
          <el-input v-model="drugsInfo.drugUnit"></el-input>
        </el-form-item>
        <el-form-item label="存放位置">
          <el-input v-model="drugsInfo.drugStorage"></el-input>
        </el-form-item>
        <el-form-item label="生产日期">
          <el-input v-model="drugsInfo.drugDate"></el-input>
        </el-form-item>
        <el-form-item label="有效日期">
          <el-input v-model="drugsInfo.usefullLife"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="editDrug">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 增加对话框 -->
    <el-dialog title="增加药品信息" :visible.sync="addDialogFormVisible">
      <el-form :model="drugsInfo" label-width="85px">
        <el-form-item label="药品编号">
          <el-input v-model="drugsInfo.drugId"></el-input>
        </el-form-item>
        <el-form-item label="药品名称">
          <el-input v-model="drugsInfo.drugName"></el-input>
        </el-form-item>
        <el-form-item label="药品进价">
          <el-input v-model="drugsInfo.drugIntoPrice"></el-input>
        </el-form-item>
        <el-form-item label="药品售价">
          <el-input v-model="drugsInfo.drugExitPrice"></el-input>
        </el-form-item>
        <el-form-item label="药品数量">
          <el-input v-model="drugsInfo.drugQuantity"></el-input>
        </el-form-item>
        <el-form-item label="药品单位">
          <el-input v-model="drugsInfo.drugUnit"></el-input>
        </el-form-item>
        <el-form-item label="存放位置">
          <el-input v-model="drugsInfo.drugStorage"></el-input>
        </el-form-item>
        <el-form-item label="生产日期">
          <el-input v-model="drugsInfo.drugDate"></el-input>
        </el-form-item>
        <el-form-item label="有效日期">
          <el-input v-model="drugsInfo.usefullLife"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addDrugs">增加</el-button>
      </div>
    </el-dialog>
  </div>
</template>



<script>
import { getDrugsList } from '@/api/admin';
import { getDrugsInfo } from '@/api/admin';
import { updateDrugs } from '@/api/admin';
import { deleteDrugs } from '@/api/admin';
import { insertDrugs } from '@/api/admin';

export default {
  name: 'Drugs',

  data() {
    return {
      drugsData: [],
      seeDetailDialogVisible: false,
      editDialogFormVisible: false,
      addDialogFormVisible: false,
      drugsInfo: {
        drugId: null,
        drugName: null,
        drugIntoPrice: null,
        drugExitPrice: null,
        drugQuantity: null,
        drugUnit: null,
        drugStorage: null,
        drugDate: null,
        usefullLife: null,
        serialVersionUID: null
      }
    };
  },

  mounted() {
    this.selectDrugsList();
  },

  methods: {
    //查找所有药品
    selectDrugsList() {
      getDrugsList()
        .then((resp) => {
          let result = resp.data;
          this.drugsData = result;
        })
        .catch((error) => {
          this.$message.error('请求出错啦！');
        });
    },
    //查看药品详情
    selectDrugsInfo(drugId) {
      // console.log(drugId);
      getDrugsInfo({ drugId: drugId })
        .then((resp) => {
          let result = resp.data;
          this.drugsInfo = result;
        })
        .catch((error) => {
          this.$message.error('请求出错啦！');
        });
    },
    //打开查看药品详情框
    seeDetail(drugId) {
      this.seeDetailDialogVisible = true;
      this.selectDrugsInfo(drugId);
    },
    //药品列表修改
    saveEditedDrug() {
      updateDrugs(this.drugsInfo)
        .then((resp) => {
          this.$message.success('药品信息已更新');
          this.selectDrugsList();
          this.editDialogFormVisible = false;
        })
        .catch((error) => {
          this.$message.error('请求出错啦！');
        });
    },
    openEditDrug(drugId) {
      // console.log(drugId);
      this.editDialogFormVisible = true;
      this.selectDrugsInfo(drugId);
    },
    //点击确认后修改
    editDrug() {
      this.saveEditedDrug();
    },
    //点击删除按钮后删除药品
    delDrug(drugId) {
      console.log(drugId);
      deleteDrugs({ drugId: drugId })
        .then((resp) => {
          this.$message.success('药品删除成功！');
          this.selectDrugsList();
        })
        .catch((error) => {
          this.$message.error('请求出错啦！');
        });
    },
    //打开药品增加信息框
    addDrugInfo() {
      this.addDialogFormVisible = true;
    },
    //增加药品
    addDrugs() {
      insertDrugs(this.drugsInfo)
        .then((resp) => {
          this.$message.success('药品增加成功！');
          this.addDialogFormVisible = false;
          this.selectDrugsList();
        })
        .catch((error) => {
          this.$message.error('请求出错啦！');
        });
    }
  }
};
</script>