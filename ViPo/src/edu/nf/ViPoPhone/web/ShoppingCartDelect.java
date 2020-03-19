package edu.nf.ViPoPhone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.ShoppingCartService;

@WebServlet("/delete")
public class ShoppingCartDelect extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ShoppingCartService service = new ShoppingCartService();
		Integer id  = Integer.parseInt(request.getParameter("sid"));
		try {
			Integer a = service.deleteCart(id);
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
