<template>
    <div class="app-container">
        <div class="filter-container">
            <!-- <el-input v-model="listQuery.userCode" :placeholder="$t('table.userCode')" style="width: 200px"
                class="filter-item" @keyup.enter.native="handleFilter" /> -->
            <!-- <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
                {{ $t("table.search") }}
            </el-button> -->
            <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-edit"
                @click="handleCreate">
                {{ $t("table.add") }}
            </el-button>
            <!-- <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"
                @click="handleDownload">
                {{ $t("table.export") }}
            </el-button> -->
        </div>
        <el-table v-loading="listLoading" :data="resourceList" border fit highlight-current-row style="width: 100%">
            <!-- @sort-change="sortChange"> -->
            <!-- 序号 -->
            <el-table-column :label="$t('table.id')" prop="id" sortable="custom" align="center" width="80">
                <!-- :class-name="getSortClass('id')"> -->
                <template slot-scope="{ row }">
                    <span>{{ row.id }}</span>
                </template>
            </el-table-column>
            <!-- 资源名称 -->
            <el-table-column :label="$t('table.resourceName')" prop="name" width="150px" align="center">
                <template slot-scope="{ row }">
                    <span>{{ row.name }}</span>
                </template>
            </el-table-column>
            <!-- url -->
            <el-table-column label="url" prop="url" width="150px" align="center">
                <template slot-scope="{ row }">
                    <span>{{ row.url }}</span>
                </template>
            </el-table-column>
            <!-- 许可证 -->
            <el-table-column :label="$t('table.permission')" prop="url" width="150px" align="center">
                <template slot-scope="{ row }">
                    <span>{{ row.permission }}</span>
                </template>
            </el-table-column>
            <!-- 备注 -->
            <el-table-column :label="$t('table.resourceNote')" prop="note" width="150px" align="center">
                <template slot-scope="{ row }">
                    <span>{{ row.note }}</span>
                    <!-- <el-tag>{{ row.type | typeFilter }}</el-tag> -->
                </template>
            </el-table-column>
            <el-table-column :label="$t('table.actions')" align="center" width="230"
                class-name="small-padding fixed-width">
                <template slot-scope="{ row }">
                    <el-button size="mini" type="success" @click="handleUpdate(row.id)">
                        {{ $t("table.edit") }}
                    </el-button>

                    <el-button size="mini" type="danger" @click="handleDelete(row.id)">
                        {{ $t("table.delete") }}
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- <pagination v-show="total > 0" :total="total" :page.sync="listQuery.pageNow" :limit.sync="listQuery.pageSize"
            @pagination="getUserList" /> -->
        <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
            <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="90px"
                style="width: 400px; margin-left: 50px">
                <!-- 资源名称 -->
                <el-form-item :label="$t('table.resourceName')" prop="name">
                    <!-- <el-select v-model="temp.type" class="filter-item" placeholder="Please select">
                        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name"
                            :value="item.key" />
                    </el-select> -->
                    <el-input v-model="temp.name" :placeholder="$t('placeholder.resourceName')" />

                </el-form-item>
                 <!-- url -->
                 <el-form-item label="url" prop="name">
                    <!-- <el-select v-model="temp.type" class="filter-item" placeholder="Please select">
                        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name"
                            :value="item.key" />
                    </el-select> -->
                    <el-input v-model="temp.url" :placeholder="$t('placeholder.url')" />

                </el-form-item>
                <!-- 许可证 -->
                <el-form-item :label="$t('table.permission')" prop="name">
                    <!-- <el-select v-model="temp.type" class="filter-item" placeholder="Please select">
                        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name"
                            :value="item.key" />
                    </el-select> -->
                    <el-input v-model="temp.permission" :placeholder="$t('placeholder.permission')" />

                </el-form-item>
                <!-- 备注 -->
                <el-form-item :label="$t('table.resourceNote')" prop="note">
                    <!-- <el-date-picker v-model="temp.timestamp" type="datetime" placeholder="Please pick a date" /> -->
                    <el-input v-model="temp.note" :placeholder="$t('placeholder.resourceNote')" />
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">
                    {{ $t("table.cancel") }}
                </el-button>
                <el-button type="primary" @click="dialogStatus === 'create' ? createResource() : updateResource()">
                    {{ $t("table.confirm") }}
                </el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { resourceList, addResource, getResourceById, deleteResourceById, updateResourceById } from '@/api/resourceInfo';
import Pagination from "@/components/Pagination";
import { parseTime } from "@/utils";
import waves from "@/directive/waves"; // waves directive
export default {
    data() {
        return {
            resourceList: [],
            total: 0,
            listLoading: false,
            dialogStatus: "",
            textMap: ["create", "edit"],
            dialogFormVisible: false,
            temp: {
                name: "",
                note: "",
                url:"",
                permission:""
            },
            // 添加 rules 校验规则
            rules: {
                name: [
                    { required: true, message: "需要输入资源名称", trigger: "blur" },
                    { min: 2, max: 50, message: "长度应该在2到50之间", trigger: "blur" }
                ],
                note: [
                    { required: true, message: "需要备注", trigger: "blur" }
                ]
            }
        }
    },
    mounted() {
        this.getList()
    },
    methods: {
        getList() {
            resourceList().then((result) => {
                console.log(result);
                this.resourceList = result.data;
                this.total = result.total;
                this.listLoading = false;
            }).catch((err) => {
                this.$message.error("")
            });
        },
        handleCreate() {
            this.dialogStatus = "create";
            this.dialogFormVisible = true;
        },
        createResource() {
            console.log(this.temp);
            addResource(this.temp).then((result) => {
                if (result.code == 0) {
                    this.$notify({
                        title: "成功",
                        message: "创建成功",
                        type: "success",
                        duration: 2000,
                    });
                    this.dialogFormVisible = false;
                    this.getList();
                }
            }).catch((err) => {

            });
        },
        fetchResourceInfo(id) {
            getResourceById({ id: id }).then((response) => {
                this.temp = response.data; // 将获取的角色信息赋值给表单

            }).catch((error) => {
                this.$message.error("请求失败！！！");
            });
        },
        handleUpdate(id) {
            this.dialogStatus = "edit";
            this.fetchResourceInfo(id);
            this.dialogFormVisible = true;
        },
        updateResource() {
            console.log(this.temp);
            updateResourceById(this.temp).then((result) => {
                if (result.code == 0) {
                    this.$notify({
                        title: "成功",
                        message: "更新成功",
                        type: "success",
                        duration: 2000,
                    }); 
                    this.dialogFormVisible = false;
                    this.getList();
                }

            }).catch((err) => {

            });
        },
        handleDelete(id) {
            deleteResourceById({ id: id }).then((result) => {
                if (result.code == 0) {
                    this.$notify({
                        title: "成功",
                        message: "删除成功",
                        type: "success",
                        duration: 2000,
                    });
                }
                this.getList();
            }).catch((err) => {

            });
        },
    }
}
</script>