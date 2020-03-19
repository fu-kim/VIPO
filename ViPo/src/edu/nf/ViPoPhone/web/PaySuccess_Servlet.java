package edu.nf.ViPoPhone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nf.ViPoPhone.service.Orders_Service;
import edu.nf.ViPoPhone.service.ShoppingCartService;

@WebServlet("/paysuccess")
public class PaySuccess_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String orderid = (String) request.getSession().getAttribute("payOrderId");
		 ShoppingCartService scs = new ShoppingCartService();
		scs.updatepayedorno(orderid);
		Orders_Service os = new Orders_Service();
		os.updateOrderStatus(orderid);
			
		response.sendRedirect("Payed.html");
	}
}
