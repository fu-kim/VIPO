package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.security.interfaces.RSAKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/paying2")
public class Paying2_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		
		request.getSession().setAttribute("payOrderId", orderId);
		
		response.sendRedirect("Paying.html");
	}
}
