package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/deleteorder")
public class DeleteOrder_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;
		String orderid = request.getParameter("orderid");
		Orders_Service os = new Orders_Service();
		Orders orders=os.orderInfoCoupon(orderid);
		try {
			if (orders.getO_coupon_id()!="") {
				Coupon_Service cs = new Coupon_Service();
				cs.UpdateCouponStatusyes(orders.getO_coupon_id());
			}
			os.deleteOrder(orderid);
			vo = success(200);
		} catch (UsersException e) {
			vo = err(401,e.getMessage());
		}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
