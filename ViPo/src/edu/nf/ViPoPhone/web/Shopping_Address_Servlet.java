package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ShoppingAddress;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.service.Shopping_Address_Service;

@WebServlet("/address")
public class Shopping_Address_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		List<ShoppingAddress> addresslist = null;
		String uphone = null;
		
		Users users=(Users)session.getAttribute("user");
		uphone = users.getU_phone();
			

		Shopping_Address_Service sas = new Shopping_Address_Service();
	
		addresslist = sas.getaddress(uphone);
		
		String json = new Gson().toJson(addresslist);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
		
	}
}
