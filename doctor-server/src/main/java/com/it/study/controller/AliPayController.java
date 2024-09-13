package com.it.study.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.it.study.common.Result;
import com.it.study.domain.entity.OrderInfo;
import com.it.study.infrastructure.alipay.AlipayConfig;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: doctor-server @BelongsPackage: com.it.study.controller @Author:
 * kanimito @CreateTime: 2024-08-20 22:59 @Description: TODO @Version: 1.0
 */
@Controller
@RequestMapping("/alipay")
@Log4j
public class AliPayController {
  @Resource private AlipayConfig alipayConfig;

  // 踩坑记录->这里不可直接return result;
  // 必须要response.getWriter().print(result);或者以map键值对方法返回
  @RequestMapping("/pay")
  @ResponseBody
  public Result toPay(String out_trade_no, String total_amount, String subject, Integer status)
      throws AlipayApiException, IOException, AlipayApiException, IOException {
    //        if (ParamsUtil.checkNull(order.getOno(), order.getPrice())) {
    //            return "<script>alert('支付请求失败！')</script>";
    //        }
    // 获得初始化的AlipayClient
    AlipayClient alipayClient =
        new DefaultAlipayClient(
            alipayConfig.getGatewayUrl(),
            alipayConfig.getApp_id(),
            alipayConfig.getMerchant_private_key(),
            "json",
            alipayConfig.getCharset(),
            alipayConfig.getAlipay_public_key(),
            alipayConfig.getSign_type());

    log.info("支付宝支付");
    log.info(alipayConfig.getAlipay_public_key());
    // 设置请求参数
    AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
    AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
    //        alipayRequest.setReturnUrl(AlipayConfig.return_url);
    alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());

    // 商户订单号，商户网站订单系统中唯一订单号，必填
    //        String out_trade_no = String.valueOf("20240820");
    // 付款金额，必填
    //        String total_amount = String.valueOf(6);
    // 订单名称，必填
    //        String subject = "挂号";
    if (status == 0) {
      model.setOutTradeNo(out_trade_no + "131516");
    } else {
      model.setOutTradeNo(out_trade_no + "131516");
    }
    model.setTotalAmount(String.valueOf(total_amount));
    model.setSubject(subject);
    alipayRequest.setBizModel(model);
    AlipayTradeAppPayResponse response = alipayClient.sdkExecute(alipayRequest);

    String result = response.getBody();

    return Result.ok(result);
  }
}
