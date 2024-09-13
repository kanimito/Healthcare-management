package com.it.study.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-study @BelongsPackage: com.it.study.controller @Author:
 * kanimito @CreateTime: 2024-08-01 14:48 @Description: TODO 文件管理控制器 @Version: 1.0
 */
@Log4j
@RestController
public class FileManageController {
  @Value("${allow.upload.suffix}")
  private String allowSuffix;

  @Value("${base.upload.path}")
  private String basePath;

  /** 单文件上传 */
  @PostMapping("/upload")
  public String upload(String user, @RequestParam("uploadFile") CommonsMultipartFile uploadFile) {
    String originalFilename = uploadFile.getOriginalFilename();
    log.info(String.format("name=%s,源文件名=%s", user, originalFilename));
    int i = originalFilename.lastIndexOf(".");
    String substring = originalFilename.substring(i + 1);
    log.info(String.format("后缀为:%s", substring));
    log.info(String.format("后缀限制为%s,基础路径为%s", allowSuffix, basePath));
    if (allowSuffix.indexOf(substring) < 0) {
      return "上传失败，文件类型被限制";
    }
    // 获取上传的文件名

    try {
      uploadFile.transferTo(new File(basePath + originalFilename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "上传成功";
  }

  /** 多文件上传 */
  @PostMapping("/filUploads")
  public String fileUploads(MultipartFile[] uploadFiles) {
    Arrays.stream(uploadFiles)
        .forEach(
            (uploadFile -> {
              String originalFilename = uploadFile.getOriginalFilename();
              log.info(String.format("源文件名=%s", originalFilename));

              //        System.out.println(String.format("name=%s",user));
              // 获取上传的文件名

              //        System.out.println(String.format("源文件名=%s",originalFilename));
              try {
                uploadFile.transferTo(new File("C:\\upload\\" + originalFilename));
              } catch (IOException e) {
                e.printStackTrace();
              }
            }));
    return "上传成功";
  }
}
