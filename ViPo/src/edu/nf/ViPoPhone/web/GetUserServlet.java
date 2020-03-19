package edu.nf.ViPoPhone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;

@WebServlet("/getusers")
public class GetUserServlet extends BasicServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			Users user = (Users)request.getSession().getAttribute("user");
			ResponseVO vo = null;
			vo = success(200,user);
			String json = new Gson().toJson(vo);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().println(json);
	}
	
	

}
