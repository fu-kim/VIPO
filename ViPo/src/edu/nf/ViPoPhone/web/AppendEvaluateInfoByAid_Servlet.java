package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.AppendEvaluate;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.AppendEvaluate_Service;

@WebServlet("/appendevaluateinfobyaid")
public class AppendEvaluateInfoByAid_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;
		String aid = request.getParameter("aid");
		try {
			AppendEvaluate_Service aes = new AppendEvaluate_Service();
			List<AppendEvaluate> appendEvaluates = aes.selectAppendEvaluateByAid(aid);
			//System.out.println(evaluates);
			//System.out.println(appendEvaluates);
			vo = success(200,appendEvaluates);
			
		} catch (UsersException e) {
			vo = err(402,e.getMessage());
		}
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
