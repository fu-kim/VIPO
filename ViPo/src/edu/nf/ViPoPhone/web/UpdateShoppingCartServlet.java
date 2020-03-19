package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.ShoppingCartService;

@WebServlet("/update_cart")
public class UpdateShoppingCartServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ShoppingCartService service = new ShoppingCartService();
		try {
			int amount = Integer.parseInt(request.getParameter("amount"));
			Double price = Double.parseDouble(request.getParameter("price"));
			String sname = request.getParameter("sname");
			int a = service.updateCartAmount(amount,(amount * price),sname);
			
			response.sendRedirect("Shopping_Carts.html");
			response.setContentType("application/json;charset=utf-8");
			String json = new Gson().toJson(a);
			response.getWriter().println(json);
		}catch(UsersException e) {
			e.printStackTrace();
			response.getWriter().println(e.getMessage());
		}
	}

	
	
}
