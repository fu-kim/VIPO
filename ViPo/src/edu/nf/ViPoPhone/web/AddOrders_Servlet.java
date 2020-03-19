package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Orders;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.Coupon_Service;
import edu.nf.ViPoPhone.service.Orders_Service;
import edu.nf.ViPoPhone.service.ShoppingCartService;
import edu.nf.ViPoPhone.util.CodeUtil;

@WebServlet("/addorder")
public class AddOrders_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;
		Date currentTime = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String otime = formatter.format(currentTime); 
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		String year =String.valueOf(c.get(Calendar.YEAR)); 
		String month = String.valueOf(c.get(Calendar.MONTH)+1); 
		String date = String.valueOf(c.get(Calendar.DATE)); 
		
		String orderid = year+month+date+CodeUtil.randomCode(6);
		Double total = Double.valueOf(request.getParameter("total"));
		String sname = request.getParameter("sname");
		String sphone = request.getParameter("sphone");
		String saddress = request.getParameter("saddress");
		String fapiao = request.getParameter("fapiao");
		String uphone = request.getParameter("uphone");
		String coupon = request.getParameter("coupon");
		
		Orders order = new Orders();
		order.setO_id(orderid);
		order.setO_address(saddress);
		order.setU_phone(uphone);
		order.setO_coupon_id(coupon);
		order.setInvoice(fapiao);
		order.setO_name(sname);
		order.setO_status("未付款");
		order.setO_tel(sphone);
		order.setO_total(total);
		order.setO_time(otime);
		try {
			ShoppingCartService sc = new ShoppingCartService();
			Orders_Service os = new Orders_Service();
			if (coupon!="") {
				Coupon_Service cs = new Coupon_Service();
				cs.UpdateCouponStatusno(uphone, coupon);
			}
			os.addOrders(order);
			sc.updatepayorno(orderid,uphone);
			request.getSession().setAttribute("payOrderId", orderid);
			
			vo = success(200);
		} catch (UsersException e) {
			vo = err(401,e.getMessage());
		}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
		
	}
}
