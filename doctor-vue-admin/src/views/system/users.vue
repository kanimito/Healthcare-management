<template>
    <div class="app-container">
        <div class="filter-container">
            <el-input v-model="listQuery.userCode" :placeholder="$t('table.userCode')" style="width: 200px"
                class="filter-item" @keyup.enter.native="handleFilter" />
            <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
                {{ $t("table.search") }}
            </el-button>
            <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-edit"
                @click="handleCreate">
                {{ $t("table.add") }}
            </el-button>
            <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"
                @click="handleDownload">
                {{ $t("table.export") }}
            </el-button>
        </div>
        <el-table v-loading="listLoading" @row-click="handleCurrentChange" :data="userList" border fit
            highlight-current-row style="width: 100%">
            <!-- @sort-change="sortChange"> -->
            <!-- 序号 -->
            <el-table-column :label="$t('table.id')" prop="id" sortable="custom" align="center" width="80">
                <!-- :class-name="getSortClass('id')"> -->
                <template slot-scope="{ row }">
                    <span>{{ row.id }}</span>
                </template>
            </el-table-column>
            <!-- 用户名 -->
            <el-table-column :label="$t('table.username')" prop="username" width="150px" align="center">
                <template slot-scope="{ row }">
                    <span>{{ row.username }}</span>
                </template>
            </el-table-column>
            <!-- 密码 -->
            <el-table-column :label="$t('table.password')" prop="password" width="150px" align="center">
                <template slot-scope="{ row }">
                    <span>{{ row.password }}</span>
                    <!-- <el-tag>{{ row.type | typeFilter }}</el-tag> -->
                </template>
            </el-table-column>
            <!-- 性别 -->
            <el-table-column :label="$t('table.sex')" prop="sex" width="50px" align="center">
                <template slot-scope="{ row }">
                    <span v-if="row.sex == 0">男</span>
                    <span v-else-if="row.sex == 1">女</span>
                </template>
            </el-table-column>
            <!-- 真实姓名 -->
            <el-table-column :label="$t('table.realName')" prop="realName" width="110px" align="center">
                <template slot-scope="{ row }">
                    <span style="color: red">{{ row.realName }}</span>
                </template>
            </el-table-column>
            <!-- 用户编号 -->
            <el-table-column :label="$t('table.userCode')" prop="userCode" width="220px" align="center">
                <template slot-scope="{ row }">
                    <!-- <svg-icon v-for="n in +row.userCode" :key="n" icon-class="star" class="meta-item__icon" /> -->
                    <span>{{ row.userCode }}</span>
                </template>
            </el-table-column>
            <!-- 账号类型 -->
            <el-table-column :label="$t('table.accountType')" prop="accountType" align="center" width="95">
                <template slot-scope="{ row }">
                    <span>{{ row.accountType }}</span>
                </template>
            </el-table-column>
            <!-- 权限类型 -->
            <el-table-column :label="$t('table.role')" prop="accountType" align="center" width="95">
                <template slot-scope="{ row }">
                    <span>{{ row.roleNote }}</span>
                </template>
            </el-table-column>
            <!-- 邮箱 -->
            <el-table-column :label="$t('table.email')" prop="email" width="160" align="center">
                <template slot-scope="{ row }">
                    <!-- <el-tag :type="row.status | statusFilter">
                        {{ row.status }}
                    </el-tag> -->
                    <span>{{ row.email }}</span>
                </template>
            </el-table-column>
            <!-- 手机号 -->
            <el-table-column :label="$t('table.mobile')" prop="mobile" width="140" align="center">
                <template slot-scope="{ row }">

                    <span>{{ row.mobile }}</span>
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
        <pagination v-show="total > 0" :total="total" :page.sync="listQuery.pageNow" :limit.sync="listQuery.pageSize"
            @pagination="getUserList" />
        <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
            <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="90px"
                style="width: 400px; margin-left: 50px">
                <!-- 用户名 -->
                <el-form-item :label="$t('table.username')" prop="username">
                    <!-- <el-select v-model="temp.type" class="filter-item" placeholder="Please select">
                        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name"
                            :value="item.key" />
                    </el-select> -->
                    <el-input v-model="temp.username" :placeholder="$t('placeholder.username')" />

                </el-form-item>
                <!-- 密码 -->
                <el-form-item :label="$t('table.password')" prop="password">
                    <!-- <el-date-picker v-model="temp.timestamp" type="datetime" placeholder="Please pick a date" /> -->
                    <el-input v-model="temp.password" :placeholder="$t('placeholder.password')" />
                </el-form-item>
                <!-- 角色 -->
                <el-form-item :label="$t('table.role')">
                    <el-select v-model="temp.role" :placeholder="$t('placeholder.role')">
                        <el-option v-for="item in roleOption" :key="item.key" :label="item.note" :value="item.id" />
                    </el-select>
                </el-form-item>
                <!-- 性别 -->
                <el-form-item :label="$t('table.sex')" prop="sex">
                    <el-select v-model="temp.sex" :placeholder="$t('placeholder.sex')">
                        <el-option v-for="item in sexOptions" :key="item.key" :label="item.label" :value="item.value" />
                    </el-select>
                </el-form-item>
                <!-- 真实姓名 -->
                <el-form-item :label="$t('table.realName')" prop="realName">
                    <!-- <el-rate v-model="temp.importance" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :max="3"
                        style="margin-top: 8px" /> -->
                    <el-input v-model="temp.realName" :placeholder="$t('placeholder.realName')" />
                </el-form-item>
                <!-- 邮箱 -->
                <el-form-item :label="$t('table.email')" prop="email">
                    <el-input v-model="temp.email" :placeholder="$t('placeholder.email')" />
                </el-form-item>
                <!-- 电话 -->
                <el-form-item :label="$t('table.mobile')" prop="mobile">
                    <el-input v-model="temp.mobile" :placeholder="$t('placeholder.mobile')" />
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">
                    {{ $t("table.cancel") }}
                </el-button>
                <el-button type="primary" @click="dialogStatus === 'create' ? createUser() : updateUser()">
                    {{ $t("table.confirm") }}
                </el-button>
            </div>
        </el-dialog>

        <el-dialog :visible.sync="dialogPvVisible" title="详情">
            <el-descriptions title="用户信息">
                <el-descriptions-item label="用户名">{{ pvData.username }}</el-descriptions-item>
                <el-descriptions-item label="手机号">{{ pvData.mobile }}</el-descriptions-item>
                <el-descriptions-item label="邮箱">{{ pvData.email }}</el-descriptions-item>
                <el-descriptions-item label="账号类型">
                    <el-tag size="small">{{ pvData.accountType }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item label="创建时间">{{ pvData.createdTime | timeFormat }}</el-descriptions-item>
                <el-descriptions-item label="修改时间">{{ pvData.modifiedTime | timeFormat }}</el-descriptions-item>
            </el-descriptions>
            <!-- <el-table :data="tableData" border fit highlight-current-row style="width: 100%">
                <el-table-column prop="key" label="Key" width="200">
                </el-table-column>
                <el-table-column prop="value" label="Value">
                </el-table-column>
            </el-table> -->
            <span slot="footer" class="dialog-footer">

                <el-button type="primary" @click="dialogPvVisible = false">{{
                    $t("table.confirm")
                }}</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
import waves from "@/directive/waves"; // waves directive
import { addUser, updateUser, deleteUser, userlist, getById, getByUserCode } from '@/api/userInfo';
import { roleList,addUserRole } from "@/api/roleInfo";
import Pagination from "@/components/Pagination";
import { parseTime } from "@/utils";
import { getRoles } from "@/api/role";
export default {
    name: "userInfo",

    components: { Pagination },
    directives: { waves },
    data() {
        return {
            pvData: {},
            dialogPvVisible: false,
            downData: [],
            listQuery: {
                userCode: "",
                pageNow: 1,
                pageSize: 10
            },
            roleOption: [],
            userList: [],
            textMap: ["create", "edit"],
            temp: {
                username: "",
                password: "",
                sex: null,
                realName: "",
                email: "",
                mobile: "",
                gmtAddUser: "admin",
                gmtUpdateUser: "admin"
            },
            sexOptions: [
                {
                    label: "男",
                    value: 0
                },
                {
                    label: "女",
                    value: 1
                }
            ],
            total: 0,
            listLoading: true,
            downloadLoading: false,
            dialogFormVisible: false,
            dialogStatus: "",
            rules: {
                username: [
                    { required: true, message: "用户名是必填项", trigger: "blur" },
                    { min: 4, max: 20, message: "用户名长度应在4到20个字符之间", trigger: "blur" },
                    { pattern: /^[a-zA-Z0-9_]+$/, message: "用户名只能包含字母、数字和下划线", trigger: "blur" }
                ],
                password: [
                    { required: true, message: "密码是必填项", trigger: "blur" },
                    { min: 5, max: 20, message: "密码长度应在5到20个字符之间", trigger: "blur" }
                ],
                email: [
                    { required: true, message: "邮箱是必填项", trigger: "blur" },
                    { type: "email", message: "请输入有效的邮箱地址", trigger: ["blur", "change"] }
                ],
                mobile: [
                    { required: true, message: "手机号是必填项", trigger: "blur" },
                    { pattern: /^1[3-9]\d{9}$/, message: "请输入有效的手机号码", trigger: "blur" }
                ],
                realName: [
                    { required: true, message: "真实姓名是必填项", trigger: "blur" },
                    { min: 2, max: 50, message: "真实姓名长度应在2到50个字符之间", trigger: "blur" }
                ],
                sex: [
                    { required: true, message: "请选择性别", trigger: "change" }
                ]
            }
        };
    },
    computed: {
        tableData() {
            return Object.keys(this.pvData).map(key => {
                //     ({
                //     key: key,
                //     value: this.pvData[key]
                // })
                if (key === "createdTime" || key === "modifiedTime") {
                    return {
                        key: key,
                        value: parseTime(this.pvData[key])
                    }
                } else {
                    return {
                        key: key,
                        value: this.pvData[key]
                    }
                }
            });
        }
    },
    filters:{
        timeFormat(value) {
            return parseTime(value);
        }
    },
    mounted() {
        this.getUserList();
        this.getRoles();
    },
    methods: {
        getRoles() {
            roleList().then(res => {
                this.roleOption = res.data;
            }).catch((err) => {
                this.$message.error("请求失败");

            });
        },
        handleCurrentChange(row, column, event) {

            console.log(row);
            if (column.label != "操作") {
                this.pvData = row;
                this.dialogPvVisible = true;
            }

        },
        handleDownload() {
            this.downloadLoading = true;
            let currentTime = new Date().toLocaleString();
            import("@/vendor/Export2Excel").then((excel) => {
                const tHeader = ["序号", "用户名", "性别", "真实姓名", "用户编码", "邮箱", "手机号", "创建时间", "更新时间"];
                const filterVal = ["id", "username", "sex", "realName", "userCode", "email", "mobile", "createdTime", "modifiedTime"];
                userlist({ pageNow: 1, pageSize: 10000 }).then(res => {
                    this.downData = res.data;
                }).catch((err) => {
                    this.$message.error("请求失败");
                });
                setTimeout(() => {
                    const data = this.formatJson(filterVal);
                    excel.export_json_to_excel({
                        header: tHeader,
                        data,
                        filename: "用户信息" + currentTime,
                    });
                    this.downloadLoading = false;
                }, 3000);
            });
        },
        formatJson(filterVal) {
            return this.downData.map((v) =>
                filterVal.map((j) => {
                    if (j === "createdTime" || j === "modifiedTime") {
                        return parseTime(v[j]);
                    } else {
                        return v[j];
                    }
                })
            );
        },
        handleDelete(id) {
            this.$confirm('确定删除吗？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                deleteUser({ id: id }).then(res => {
                    if (res.code == 0) {
                        this.$notify({
                            title: "成功",
                            message: "删除成功",
                            type: "success",
                            duration: 2000,
                        });
                    }
                    this.getUserList();
                }).catch((err) => {
                    this.$message.error("请求失败");
                });
            }).catch(() => {
                this.$message.info('已取消删除');
            });
        },
        getUserFormById(id) {
            getById({ id: id }).then(res => {
                if (res.code == 0) {
                    this.temp = res.data;
                }
            }).catch((err) => {
                this.$message.error("请求失败");
            });
        },
        handleFilter() {
            if (this.listQuery.userCode == "" || this.listQuery.userCode == null) {
                this.getUserList();
            } else {
                getByUserCode({ userCode: this.listQuery.userCode }).then(res => {
                    this.userList = res.data;
                });
            }
        },
        handleCreate() {
            this.dialogStatus = 'create';
            this.dialogFormVisible = true;
            this.$nextTick(() => {
                this.$refs["dataForm"].clearValidate();
            });
        },
        createUser() {
            console.log(this.roleOption);
            addUser(this.temp).then(res => {
                if (res.code == 0) {
                    this.$notify({
                        title: "成功",
                        message: "创建成功",
                        type: "success",
                        duration: 2000,
                    });
                }
                this.dialogFormVisible = false;
                this.getUserList();
            });
            
        },
        handleUpdate(id) {
            this.dialogPvVisible = false;

            this.getUserFormById(id);
            this.dialogStatus = 'update';
            this.dialogFormVisible = true;
            this.$nextTick(() => {
                this.$refs["dataForm"].clearValidate();
            });
        },
        updateUser() {
            this.temp.roleId = this.roleOption.id;
            updateUser(this.temp).then(res => {
                if (res.code == 0) {
                    this.$notify({
                        title: "成功",
                        message: "更新成功",
                        type: "success",
                        duration: 2000,
                    });
                }
                this.dialogFormVisible = false;
                this.getUserList();
            });
        },
        getUserList() {
            userlist(this.listQuery).then(res => {
                this.userList = res.data;
                this.total = res.total;
                this.listLoading = false;
            });
        }
    }
};
</script>