package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.ShoppingCartService;

@WebServlet("/update_cart_check")
public class UpdateShoppingCartCheckedServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ShoppingCartService service = new ShoppingCartService();
		try {
			int sid = Integer.valueOf(request.getParameter("sid"));
			System.out.println(sid);
			int cchhee =Integer.valueOf(request.getParameter("shopcheck"));
			System.out.println(cchhee);
			int a = service.updateShoppingCartChecked(cchhee,sid);
			
			response.setContentType("application/json;charset=utf-8");
			String json = new Gson().toJson(a);
			response.getWriter().println(json);
		}catch(UsersException e) {
			e.printStackTrace();
			response.getWriter().println(e.getMessage());
		}
	}

	
	
}
