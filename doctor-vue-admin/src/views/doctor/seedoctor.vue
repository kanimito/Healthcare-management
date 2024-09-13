<template>
    <div>
        <el-descriptions title="病人信息" border :column="2">
            <el-descriptions-item label="挂号编号">{{
                orderData.rgNum
            }}</el-descriptions-item>
            <el-descriptions-item label="姓名">{{
                orderData.pname
            }}</el-descriptions-item>
            <el-descriptions-item label="身份证号">{{
                orderData.ppatientId
            }}</el-descriptions-item>
            <el-descriptions-item label="性别">{{
                orderData.psex
            }}</el-descriptions-item>
            <el-descriptions-item label="年龄">{{
                orderData.page
            }}</el-descriptions-item>
        </el-descriptions>
        <div class="input-container">
            <label for="textarea-input" class="input-label">医嘱</label>
            <el-input
                id="textarea-input"
                type="textarea"
                :rows="2"
                placeholder="请输入医嘱内容"
                v-model="textarea"
            >
            </el-input>
            <el-button v-if="!isSubmitted" type="primary" @click="handleSubmit">
                提交医嘱
            </el-button>
            <!-- 开药按钮 -->
            <el-button v-if="isSubmitted" type="success" @click="kaimed">
                开药
            </el-button>
        </div>
        <div v-if="showTable">
            <template>
                <el-table :data="tableData" style="width: 100%">
                    <el-table-column prop="drugName" label="药品名" width="180">
                    </el-table-column>
                    <el-table-column prop="" label="数量" width="300">
                        <template slot-scope="scope">
                            <el-input-number
                                v-model="scope.row.quantity"
                                :min="1"
                                :max="100"
                                label="数量"
                            ></el-input-number>
                        </template>
                    </el-table-column>
                    <el-table-column
                        prop="drugUnit"
                        label="计量单位"
                    ></el-table-column>
                    <el-table-column prop="totalPrice" label="总价">
                        <template slot-scope="scope">
                            {{
                                (
                                    scope.row.drugExitPrice * scope.row.quantity
                                ).toFixed(2)
                            }}
                        </template>
                    </el-table-column>
                </el-table>
            </template>
            <div class="submit-button-container">
                <p>总价: {{ totalPrice.toFixed(2) }}</p>
                <el-button @click="tijiaokaiyao"> 提交开药 </el-button>
            </div>
        </div>
        <!-- 弹窗组件 -->
        <popup
            :visible="showPopup"
            content="开药"
            @close="kaimed"
            @update:selectedItems="handleSelectedItems"
            @update:showTable="showTable = $event"
        />
    </div>
</template>
    
    <script>
import Popup from '@/views/doctor/Popup';
import { huizhenye } from '@/api/doctor';
import { tijiao } from '@/api/doctor';
import { tijiaodingdan } from '@/api/doctor';
import { buquan } from '@/api/doctor';
export default {
    name: 'seedoctor',
    components: {
        Popup
    },

    data() {
        return {
            textarea: '',
            orderData: {},
            loading: true,
            isSubmitted: false, 
            editDialogFormVisible: false,
            showPopup: false, //弹窗控制

            orderInfo: {
                rgNum: null,
                pname: null,
                psex: null,
                page: null,
                ppatientId: null
            },

            tableData: [],
            totalPrice: 0
        };
    },

    mounted() {
        //console.log(this.$route.query.id);
        this.getList();
    },

    methods: {
        getList() {
            const id = this.$route.query.id;
            console.log("sadasdasdasdasdasdasdasdasdasda");
            
            console.log(id);
            
            if (id) {
                huizhenye({ id: id })
                    .then((response) => {
                        console.log(response);
                        this.orderData = response.data[0];
                        this.loading = false;
                    })
                    .catch((error) => {
                        this.$msg.error('请求出错!');
                    });
            } else {
                this.$msg.error('缺少参数ID');
            }
        },
        handleSubmit() {
            const data = {
                rgNum: this.orderData.rgNum,
                pName: this.orderData.pname,
                pPatientId: this.orderData.ppatientId,
                rAdvice: this.textarea
            };
            console.log(data);
            tijiao(data)
                .then((response) => {
                    console.log('提交成功:', response);
                    this.$message.success('医嘱提交成功');
                    this.isSubmitted = true;
                })
                .catch((error) => {
                    console.error('提交失败:', error);
                    this.$message.error('提交失败，请稍后重试');
                });
        },
        kaimed() {
            // 开药按钮的点击处理逻辑
            console.log('开药按钮被点击');
            // 这里可以添加开药的相关操作
            this.showPopup = !this.showPopup;
            //this.showTable = true; // 点击开药后显示表格
        },
        handleSelectedItems(selectedItems) {
            // 处理从子组件传递过来的选中药品数据
            this.tableData = selectedItems.map((item) => ({
                drugName: item.drugName,
                drugUnit: item.drugUnit,
                quantity: 1,
                drugExitPrice: item.drugExitPrice || 0, // 添加价格属性
                drugId: item.drugId,
                totalPrice: item.drugExitPrice || 0
            }));
            this.calculateTotalPrice(); // 计算总价
            console.log('Selected items:', this.tableData);
        },
        calculateTotalPrice() {
            this.totalPrice = this.tableData.reduce(
                (sum, item) => sum + item.drugExitPrice * item.quantity,
                0
            );
        },
        
        tijiaokaiyao() {
            const orderDetail = this.tableData.map((item) => ({
                ...item,
                dodCost: item.drugExitPrice * item.quantity // 更新 dodCost 为药品的总价
            }));
            const data1 = {
                rgNum: this.orderData.rgNum,
                pname: this.orderData.pname,
                ppatitentId: this.orderData.ppatientId,
                doCost: this.totalPrice,
                doStatus: 0,
                orderDetail: orderDetail
            };
            const data2 = {
                rgNum: this.rgNum
            };
            console.log(data1);
            tijiaodingdan(data1)
                //.then(() => Promise.all(requests))
                .then((responses) => {
                    console.log('订单提交成功:', responses);
                    this.$message.success('开药成功');
                    this.$router.push("/doctorsys/patientpage")
                    //return buquan(data2);
                })
                .then((responses) => {
            console.log('补充成功:', responses);
            this.$message.success('成功');
        })
        .catch((error) => {
            // 错误处理，如果订单提交失败，或补充操作失败
            console.error('操作失败:', error);
            this.$message.error('补充失败，请稍后重试');
        });
        }
    },
    watch: {
        tableData: {
            deep: true,
            handler() {
                this.calculateTotalPrice();
            }
        }
    }
};
</script>

<style scoped>
.input-container {
    margin-top: 20px;
}
.input-label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
}
.input-container {
    margin-top: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.el-button {
    margin-top: 10px;
}
.submit-button-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
    margin-bottom: 20px;
}
</style>