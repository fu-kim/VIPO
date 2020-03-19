package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.UserService;

@WebServlet("/updatepwd")
public class Update_Password_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseVO vo=null;
		PrintWriter pw=response.getWriter();
		response.setContentType("application/json");
		
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		
		HttpSession session=request.getSession();
		Users users=(Users)session.getAttribute("user");
		if (oldpwd.equals(users.getU_password())) {
			users.setU_password(newpwd);

			UserService us = new UserService();
			try {
				
				us.updatePwd(users);
				vo = success(200);
				
			} catch (DaoException e) {
				vo = success(401);
				throw new UsersException(e.getMessage());
			}
		}else {
			vo = success(402);
		}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
