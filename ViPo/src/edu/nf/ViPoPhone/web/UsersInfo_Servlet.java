package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Evaluate;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.Evaluate_Service;
import edu.nf.ViPoPhone.service.UserService;

@WebServlet("/usersinfo")
public class UsersInfo_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;
		
		String uphone = request.getParameter("uphone");
		try {
			UserService us = new UserService();
			Users users = us.userInfo(uphone);
			//System.out.println(evaluates);
			vo = success(200,users);
			
		} catch (UsersException e) {
			vo = err(402,e.getMessage());
		}
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
