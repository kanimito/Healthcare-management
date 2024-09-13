<template>
    <div id="app">
        <el-table :data="orderData" borderstyle="width: 100%">
            <el-table-column prop="shiftId" label="排班id"> </el-table-column>
            <el-table-column prop="date" label="排班日期"> </el-table-column>
            <el-table-column prop="dcId" label="科室小类id"> </el-table-column>
            <el-table-column prop="dId" label="办公室id"> </el-table-column>
            <el-table-column prop="dDoctorId" label="医生id"> </el-table-column>
            <el-table-column prop="time" label="排班时间段"> </el-table-column>
            <el-table-column prop="count" label="放号数量"> </el-table-column>
        </el-table>
    </div>
</template>
  
  <script>
import { seepaiban } from '@/api/doctor';
export default {
    name: 'paiban',

    data() {
        return {
            orderData: [],
            loading: true,
            editDialogFormVisible: false,
            orderInfo: {
                shiftId: null,
                date: null,
                dcId: null,
                dId: null,
                dDoctorId: null,
                time: null,
                count: null,
            }
        };
    },

    mounted() {
        this.getList();
    },

    methods: {
        getList() {
            seepaiban().then((response) => {
                console.log(response);
                this.orderData = response.data;
                //关闭加载遮罩
                this.loading = false;
            });
        },
        //打开编辑对话框
        openEditOrderDialog(orderId) {
            this.editDialogFormVisible = true;
            //发送ajax请求从后台拉取数据
        },
        handleClick(row) {
            console.log(row);
        }
    }
};
</script>