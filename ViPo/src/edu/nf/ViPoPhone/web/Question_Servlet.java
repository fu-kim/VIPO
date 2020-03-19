package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Question;
import edu.nf.ViPoPhone.service.Question_Service;

@WebServlet("/question")
public class Question_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		
		String title = request.getParameter("title");
		
		Question_Service sq = new Question_Service();
		
		List<Question> que = sq.cityList(title);
		
		String json = new Gson().toJson(que);
		pw.println(json);
	}
}
