package edu.nf.ViPoPhone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ShoppingCart;
import edu.nf.ViPoPhone.service.ShoppingCartService;

@WebServlet("/count_cart")
public class ShoppingCountServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ShoppingCartService service = new ShoppingCartService();
		String phone  = request.getParameter("uphone");
		ShoppingCart count = service.getCountByPhone(phone);
		response.setContentType("application/json;charset=utf-8");
		String json = new Gson().toJson(count);
		response.getWriter().println(json);
	}
}
