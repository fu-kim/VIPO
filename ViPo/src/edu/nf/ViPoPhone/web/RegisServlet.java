package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.UserService;

@WebServlet(urlPatterns = "/regis")
public class RegisServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String code=request.getParameter("code");	
		
		Users user=new Users();
		user.setU_name(name);
		user.setU_phone(phone);
		user.setU_password(password);
		
		
		ResponseVO vo=null;
		try {
			String sessionCode=(String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
			if(code.equals(sessionCode)) {
				UserService service=new UserService();
				service.regisUser(user);
				vo=success(200);
				
			}else {
				vo=err(401, "验证码错误");
				
			}
		} catch (UsersException e) {
			vo=err(401, e.getMessage());
			
		}
		String json=new Gson().toJson(vo);
		pw.println(json);
	}
}
