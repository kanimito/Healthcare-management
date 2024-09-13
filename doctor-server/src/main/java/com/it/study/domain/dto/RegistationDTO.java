package com.it.study.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\  =  /O
 * ____/`---'\____
 * .'  \\|     |//  `.
 * /  \\|||  :  |||//  \
 * /  _||||| -:- |||||-  \
 * |   | \\\  -  /// |   |
 * | \_|  ''\---/''  |   |
 * \  .-\__  `-`  ___/-. /
 * ___`. .'  /--.--\  `. . __
 * ."" '<  `.___\_<|>_/___.'  >'"".
 * | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * \  \ `-.   \_ __\ /__ _/   .-` /  /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 佛祖保佑        永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 *
 * @BelongsProject: doctor-server
 * @BelongsPackage: com.it.study.domain.dto
 * @Author: kanimito
 * @CreateTime: 2024-09-08  23:56
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class RegistationDTO {
    /** 挂号编号 */
    private Integer rgNum;

    /** 病人身份证号 */
    private String pPatientId;

    /** 病人姓名 */
    private String pName;

    /** 病人性别 */
    private String pSex;

    /** 病人年龄 */
    private Integer pAge;

    /** 挂号时间 */
    private Date rgCreatetime;

    /** 挂号状态(0、未叫号 1、已叫号 2、就诊中 3、就诊完成) */
    private Integer rgStatus;

    /** 排班id */
    private Integer shiftId;

    /** 排班时间段id */
    private Integer shiftTimeId;

    private String rAdvice;
    private String dName;
    private Date createTime;
}
