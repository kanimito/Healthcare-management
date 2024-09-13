<template>
    <div id="app">
        <el-row>
            <el-button
                type="primary"
                @click="scehduling()"
                icon="el-icon-edit-outline"
                >排班</el-button
            >
        </el-row>
        <el-table :data="shiftData" border style="width: 100%">
            <el-table-column
                prop="dcId"
                label="主科室ID"
                align="center"
                width="80"
            >
            </el-table-column>
            <el-table-column
                prop="dcName"
                label="主科室名称"
                align="center"
                width="95"
            >
            </el-table-column>
            <el-table-column
                prop="dId"
                label="科室ID"
                align="center"
                width="80"
            >
            </el-table-column>
            <el-table-column
                prop="dpName"
                label="科室名称"
                align="center"
                width="95"
            >
            </el-table-column>
            <el-table-column
                prop="dAddress"
                label="科室地址"
                align="center"
                width="100"
            >
            </el-table-column>
            <el-table-column
                prop="dPhone"
                label="科室电话"
                align="center"
                width="120"
            >
            </el-table-column>
            <el-table-column
                prop="realName"
                label="医生姓名"
                align="center"
                width="80"
            >
            </el-table-column>
            <el-table-column
                prop="sex"
                label="医生性别"
                align="center"
                width="80"
            >
                <template slot-scope="scope">
                    <el-tag disable-transition v-if="scope.row.sex === 0">
                        女
                    </el-tag>
                    <el-tag disable-transition v-else-if="scope.row.sex === 1">
                        男
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column
                prop="email"
                label="医生邮箱"
                align="center"
                width="160"
            >
            </el-table-column>
            <el-table-column
                prop="mobile"
                label="医生电话"
                align="center"
                width="110"
            >
            </el-table-column>
            <el-table-column
                prop="date"
                label="排班日期"
                align="center"
                width="125"
            >
            </el-table-column>
            <el-table-column
                prop="time"
                label="排班时间段"
                align="center"
                width="95"
            >
            </el-table-column>
            <el-table-column
                prop="status"
                label="排班状态"
                align="center"
                width="82"
            >
                <template slot-scope="scope">
                    <el-tag disable-transition v-if="scope.row.status === 0">
                        未发布
                    </el-tag>
                    <el-tag
                        disable-transition
                        v-else-if="scope.row.status === 1"
                    >
                        已发布
                    </el-tag>
                </template>
            </el-table-column>
        </el-table>

        <!-- 排班对话框 -->
        <el-dialog
            title="排班信息表"
            :visible.sync="schedulingDialogFormVisible"
        >
            <el-form ref="form" :model="ShiftList" label-width="110px">
                <el-form-item label="选择科室">
                    <el-select
                        v-model="parentDepartmentInfo.dcId"
                        placeholder="请选择科室"
                        @change="showDepartment"
                    >
                        <el-option
                            v-for="item in parentDepartmentList"
                            :key="item.key"
                            :label="item.dcName"
                            :value="item.dcId"
                        ></el-option>
                    </el-select>
                    <el-select
                        v-if="showSpecificDepartment1"
                        v-model="sonDepartmentInfo.dcId"
                        placeholder="请选择具体科室"
                        @change="showDepartment1"
                    >
                        <el-option
                            v-for="item in sonDepartmentList"
                            :key="item.key"
                            :label="item.dcName"
                            :value="item.dcId"
                        ></el-option>
                    </el-select>
                    <el-select
                        v-if="showSpecificDepartment2"
                        v-model="ShiftList.did"
                        placeholder="请选择办公室"
                        @change="selDepartment"
                    >
                        <el-option
                            v-for="item in workDepartmentList"
                            :key="item.key"
                            :label="item.dpName"
                            :value="item.did"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="选择医生">
                    <el-select
                        v-model="ShiftList.ddoctorId"
                        placeholder="请选择医生"
                    >
                        <el-option
                            v-for="item in doctorList"
                            :key="item.key"
                            :label="item.realName"
                            :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="选择排班日期">
                    <div class="block">
                        <span class="demonstration"></span>
                        <el-date-picker
                            type="dates"
                            v-model="ShiftList.date"
                            placeholder="选择一个或多个日期"
                            @change="clickDate()"
                        >
                        </el-date-picker>
                    </div>
                    <!-- <div class="block">
                        <span class="demonstration"></span>
                        <el-date-picker
                            v-model="ShiftList.date"
                            type="date"
                            placeholder="选择日期"
                        >
                        </el-date-picker>
                    </div> -->
                </el-form-item>
                <el-form-item label="选择排班时间段">
                    <el-select
                        v-model="selectedTimePeriod"
                        placeholder="请选择排班时间段"
                        @change="selectTime()"
                    >
                        <el-option label="上午" value="morning"></el-option>
                        <el-option label="下午" value="afternoon"></el-option>
                        <el-option label="晚上" value="night"></el-option>
                        <el-option label="其他" value="other"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <el-row justify="center">
                <el-button
                    type="primary"
                    icon="el-icon-edit-outline"
                    @click="shift1()"
                    >发布排班信息</el-button
                >
            </el-row>
        </el-dialog>
    </div>
</template>

<script>
import {
    getAllDepartmentList,
    getShiftList,
    getDepartmentList,
    selectAllDoctorList,
    insertScheduling
    // insertShiftTime,
    // getLatestShiftId
} from '@/api/admin';

export default {
    name: 'Scheduling',

    data() {
        return {
            selectedTimePeriod: '',
            showSpecificDepartment1: false,
            showSpecificDepartment2: false,
            value1: '',
            latestShiftId: [],
            shiftData: [],
            parentDepartmentInfo: { dcId: '', dcName: '', dcParentId: '' },
            sonDepartmentInfo: { dcId: '', dcName: '', dcParentId: '' },
            ShiftList: {
                shiftId: '',
                date: '',
                dcId: '',
                dId: '',
                dDoctorId: '',
                status: '',
                dcName: '',
                realName: '',
                time: '',
                dpName: '',
                dAddress: '',
                mobile: '',
                email: '',
                dPhone: '',
                sex: ''
            },
            shiftInfo: {
                shiftid: '',
                date: '',
                dcid: '',
                dId: '',
                ddoctorId: '',
                status: '',
                shiftTime: []
            },
            shiftList: [],
            shiftTimeInfo: {
                shiftId: '',
                time: ''
            },
            shiftTimeList: [],
            schedulingDialogFormVisible: false,
            departmentData: {
                dcName: '',
                realName: '',
                dpName: ''
            },
            departmentList: [],
            parentDepartmentList: [],
            sonDepartmentList: [],
            workDepartmentList: [],
            departmentOptions: {},
            doctorList: [],
            allDepartmentList: [],
            timeOptions: {
                other: [
                    {
                        label: '1',
                        value: 1
                    },
                    {
                        label: '2',
                        value: 2
                    },
                    {
                        label: '3',
                        value: 3
                    },
                    {
                        label: '4',
                        value: 4
                    },
                    {
                        label: '5',
                        value: 5
                    },
                    {
                        label: '6',
                        value: 6
                    },
                    {
                        label: '7',
                        value: 7
                    }
                ],
                morning: [
                    {
                        label: '8',
                        value: 8
                    },
                    {
                        label: '9',
                        value: 9
                    },
                    {
                        label: '10',
                        value: 10
                    },
                    {
                        label: '11',
                        value: 11
                    },
                    {
                        label: '12',
                        value: 12
                    }
                ],

                afternoon: [
                    {
                        label: '13',
                        value: 13
                    },
                    {
                        label: '14',
                        value: 14
                    },
                    {
                        label: '15',
                        value: 15
                    },
                    {
                        label: '16',
                        value: 16
                    },
                    {
                        label: '17',
                        value: 17
                    },
                    {
                        label: '18',
                        value: 18
                    }
                ],
                night: [
                    {
                        label: '19',
                        value: 19
                    },
                    {
                        label: '20',
                        value: 20
                    },
                    {
                        label: '21',
                        value: 21
                    },
                    {
                        label: '22',
                        value: 22
                    },
                    {
                        label: '23',
                        value: 23
                    },
                    {
                        label: '24',
                        value: 24
                    }
                ]
            },
            timePeriod: [
                {
                    value: '1',
                    label: '上午'
                },
                {
                    value: '2',
                    label: '下午'
                },
                {
                    value: '3',
                    label: '晚上'
                },
                {
                    value: '4',
                    label: '其他'
                }
            ],
            stringToTime: {
                morning: [6, 7, 8, 9, 10, 11, 12],
                afternoon: [14, 15, 16, 17, 18],
                night: [19, 20, 21, 22, 23, 24],
                other: [1, 2, 3, 4, 5]
            }
            // <el-option label="上午" value="morning"></el-option>
            //             <el-option label="下午" value="afternoon"></el-option>
            //             <el-option label="晚上" value="night"></el-option>
            //             <el-option label="其他" value="other"></el-option>
        };
    },

    mounted() {
        this.shift();
        this.selectDepartment();
        // this.selectAllDepartment1();
        // this.selectAllDoctor();
        // this.selectAllDepartment2();
    },

    methods: {
        selectTime() {
            this.shiftTimeList = [];
            // console.log(this.stringToTime[this.selectedTimePeriod]);
            this.stringToTime[this.selectedTimePeriod].forEach((item) => {
                this.shiftTimeInfo = {
                    shiftId: '',
                    time: item
                };
                this.shiftTimeList.push(this.shiftTimeInfo);
            });
            // console.log(this.shiftTimeList);
            this.shiftList.forEach((item) => {
                item.shiftTime = this.shiftTimeList;
            });
            console.log(this.shiftList);
        },
        clickDate() {
            this.shiftList = [];
            // console.log(this.ShiftList.date);
            this.ShiftList.date.forEach((item) => {
                this.shiftInfo = {
                    shiftid: '',
                    date: item,
                    dcId: this.ShiftList.dcId,
                    did: this.ShiftList.dId,
                    ddoctorId: this.ShiftList.dDoctorId,
                    shiftTime: []
                };
                this.shiftList.push(this.shiftInfo);
            });
            console.log(this.shiftList);
        },
        selDepartment() {
            console.log('获取shiftList');
            console.log(this.ShiftList);
            this.selectAllDoctor(this.ShiftList.did);
        },
        // shift3() {
        //     getLatestShiftId(this.ShiftList)
        //     .then((resp) => {
        //         let result = resp.data;
        //         this.latestShiftId = result;
        //         console.log(result);
        //     })
        // },
        shift1() {
            this.shiftList.forEach((item) => {
                insertScheduling(item)
                    .then((resp) => {
                        this.$message.success('排班信息已发布！');
                        this.shift();
                    })
                    .catch((error) => {
                        this.$message.error('请求出错啦！');
                    });
            });
        },
        // shift2() {
        //     insertShiftTime(this.ShiftList)
        //         .then((resp) => {
        //             this.$message.success('排班时间段已发布！');
        //             this.shift();
        //         })
        //         .catch((error) => {
        //             this.$message.error('请求出错啦！');
        //         });
        // },
        publish() {
            this.shift1();
            this.shift2();
            this.shift3();
        },
        selParentDepartment(value) {
            console.log(value);
        },
        //下拉框选择医生
        selectAllDoctor(dId) {
            console.log(dId);
            this.doctorList = [];
            selectAllDoctorList()
                .then((resp) => {
                    let result = resp.data;
                    console.log(result);
                    result.forEach((item) => {
                        if (item.did == dId) {
                            this.doctorList.push(item);
                        }
                    });
                    // this.doctorList = result;
                    // console.log(result);
                    // console.log(this.doctorList);
                })
                .catch((error) => {
                    this.$message.error('请求出错啦！');
                });
                console.log(this.selectAllDoctorList);
        },
        //下拉框选择主科室
        selectDepartment() {
            getDepartmentList()
                .then((resp) => {
                    let result = resp.data;
                    this.departmentList = result;
                    // console.log(result);
                    result.forEach((item) => {
                        if (item.dcId == item.dcParentId) {
                            this.parentDepartmentList.push(item);
                        } else {
                        }
                    });
                })
                .catch((error) => {
                    this.$message.error('请求出错啦！');
                });
        },
        //选择主科室以后展开相关具体科室的下拉框
        showDepartment() {
            this.sonDepartmentList = [];
            this.sonDepartmentInfo = {};
            this.ShiftList = {};
            console.log(this.parentDepartmentInfo.dcId);
            this.departmentList.forEach((item) => {
                // console.log(item);
                if (item.dcParentId != item.dcId) {
                    if (item.dcParentId == this.parentDepartmentInfo.dcId) {
                        this.sonDepartmentList.push(item);
                        console.log(item);
                    }
                }
            });
            if (this.parentDepartmentInfo.dcId !== '') {
                this.showSpecificDepartment1 = true;
            } else {
                this.showSpecificDepartment1 = false;
            }
        },
        //选择具体科室以后展开相关具体科室附属科室
        showDepartment1() {
            this.workDepartmentList = [];
            this.ShiftList = {};
            console.log(this.sonDepartmentInfo.dcId);
            getAllDepartmentList().then((resp) => {
                let result = resp.data;
                this.allDepartmentList = result;
                result.forEach((item) => {
                    if (item.dcChildId == this.sonDepartmentInfo.dcId) {
                        this.workDepartmentList.push(item);
                        console.log(item);
                    }
                });
            });
            if (this.sonDepartmentInfo.dcId !== '') {
                this.ShiftList.dcId = this.sonDepartmentInfo.dcId;
                this.showSpecificDepartment2 = true;
            } else {
                this.showSpecificDepartment2 = false;
            }
        },
        //展示所有排班信息数据
        shift() {
            getShiftList()
                .then((resp) => {
                    let result = resp.data;
                    this.shiftData = result;
                })
                .catch((error) => {
                    this.$message.error('请求出错啦！');
                });
        },
        scehduling() {
            this.schedulingDialogFormVisible = true;
        }
    }
};
</script>