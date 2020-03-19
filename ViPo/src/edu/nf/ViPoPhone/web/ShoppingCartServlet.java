package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.ShoppingCart;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.service.ShoppingCartService;


@WebServlet("/shop_cart")
public class ShoppingCartServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		ShoppingCartService service = new ShoppingCartService();
		String uphone = request.getParameter("uphone");
		//String phone  = request.getParameter("phone");
		List<ShoppingCart> sc = service.getShoppingCart(uphone);
		response.setContentType("application/json;charset=utf-8");
		String json = new Gson().toJson(sc);
		response.getWriter().println(json);
	}
}
