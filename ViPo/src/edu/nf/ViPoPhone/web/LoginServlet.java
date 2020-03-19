package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.listnener.MessageBroker;
import edu.nf.ViPoPhone.service.UserService;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		Users user=new Users();
		user.setU_name(name);
		user.setU_password(password);
		ResponseVO vo=null;
		UserService service=new UserService();
		try {
			Users users=service.loginUser(user);
			request.getSession().setAttribute("user", users);
			
			Map<String, ArrayBlockingQueue<Integer>> broker = (Map<String, ArrayBlockingQueue<Integer>>)request.getServletContext().getAttribute(MessageBroker.BROKER_KEY);
			broker.put(String.valueOf(users.getU_id()), new ArrayBlockingQueue<Integer>(1));
			
			vo=success(200,users);
		} catch (Exception e) {
			vo=err(401, e.getMessage());
		}
		String json=new Gson().toJson(vo);
		pw.println(json);
	}
	
}
