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
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.UserService;

@WebServlet("/updatemailbox")
public class Update_MailBox_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseVO vo=null;
		PrintWriter pw=response.getWriter();
		response.setContentType("application/json");
		
		String mailbox = request.getParameter("mailbox");
		
		System.out.println(mailbox);
		
		HttpSession session=request.getSession();
		Users users=(Users)session.getAttribute("user");
		users.setU_mailbox(mailbox);
		
			UserService us = new UserService();
			try {
				System.out.println(users.getU_mailbox());
				us.updateMailbox(users);
				vo = success(200);
				
			} catch (UsersException e) {
				vo = success(401);
				throw new UsersException(e.getMessage());
			}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
