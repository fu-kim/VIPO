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

@WebServlet("/logout")
public class LogoutServlet extends BasicServlet{
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
			PrintWriter pw=response.getWriter();
			
			String path = request.getParameter("path");
			
			HttpSession session=request.getSession();
			session.removeAttribute("user");
			
			ResponseVO vo=success(401);
			String json = new Gson().toJson(vo);
			pw.println(json);
			
			response.sendRedirect(path);
	}
}
