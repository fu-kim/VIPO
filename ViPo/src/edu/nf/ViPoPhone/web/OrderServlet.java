package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;

import edu.nf.ViPoPhone.entity.Pay;
import edu.nf.ViPoPhone.pay.AlipayConfig;

public class OrderServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
		String orderId = (String) session.getAttribute("payOrderId");
	
        String price = request.getParameter("price");

            Pay pay = new Pay();
            pay.setOid(orderId);
            pay.setName("手机商品");
            pay.setPrice(price);
            pay.setMessage("ViPo电子商城手机商品");
            
            //向支付宝发送请求
            //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                    AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
                    AlipayConfig.sign_type);
                    
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = pay.getOid()+"";
            //付款金额，必填
            String total_amount = pay.getPrice()+"";
            //订单名称，必填
            String subject = pay.getName();
            //商品描述，可空
            String body = pay.getMessage();
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\""
                    + total_amount + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            
            AlipayTradePagePayResponse alipayResponse = null;
            try {
                alipayResponse=alipayClient.pageExecute(alipayRequest);
                
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(alipayResponse.getBody());
    }
	
}
