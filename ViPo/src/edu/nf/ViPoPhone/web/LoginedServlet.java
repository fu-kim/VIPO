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

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;

@WebServlet("/logined")
public class LoginedServlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		
		HttpSession session=request.getSession();
		Users users=(Users)session.getAttribute("user");
		ResponseVO vo = null;
		if (users!=null) {
			 vo=success(200,users);
		}
		else {
			vo=err(401,"请登录");
		}
		String json = new Gson().toJson(vo);
		pw.println(json);
		
	}
}
