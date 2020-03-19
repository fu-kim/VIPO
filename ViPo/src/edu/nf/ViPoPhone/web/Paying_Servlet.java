package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Orders;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.Orders_Service;

@WebServlet("/paying")
public class Paying_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;
		HttpSession session = request.getSession();
		String orderId = (String) session.getAttribute("payOrderId");
		
		Orders_Service os = new Orders_Service();
		try {
			List<Orders> orders = os.orderInfo(orderId);
			vo = success(200,orders);
		} catch (UsersException e) {
			vo = err(401,e.getMessage());
		}

		String json = new Gson().toJson(vo);
		pw.println(json);
		
	}
}
