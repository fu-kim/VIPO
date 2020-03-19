package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Code;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.UserService;

@WebServlet("/updatemailboxCode")
public class Update_MailBox_Code_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseVO vo=null;
		PrintWriter pw=response.getWriter();
		response.setContentType("application/json");
		
		String mailbox = request.getParameter("mailbox");
		String code = request.getParameter("codeInfo");
		
		
		
		HttpSession session=request.getSession();
		Code c = (Code) session.getAttribute("code");
		
		Users users=(Users)session.getAttribute("user");
		users.setU_mailbox(mailbox);
		
			UserService us = new UserService();
			try {
				us.updateMailbox(users,code,c);
				vo = success(200,users);
				
			} catch (UsersException e) {
				vo = err(401,e.getMessage());
			}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
