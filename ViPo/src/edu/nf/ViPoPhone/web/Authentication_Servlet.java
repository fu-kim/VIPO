package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.StringValueExp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Code;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.util.CodeUtil;
import edu.nf.ViPoPhone.util.DateUtil;
import edu.nf.ViPoPhone.util.SmsUtil;

@WebServlet("/Authentication")
public class Authentication_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		ResponseVO vo = null;
		
		String phone = request.getParameter("phone");
		
		String code = CodeUtil.randomCode(6);
		//System.out.println(phone+"      "+code);
		boolean flag=SmsUtil.send(code, phone);
		if (flag) {
			Long startTime = new Date().getTime();
			Long endTime = DateUtil.getExpDate(3);
			Code c=new Code();
			
			c.setCode(code);
			c.setStartTime(startTime);
			c.setEndTime(endTime);
			
			request.getSession().setAttribute("code", c);
			
			vo=success(200);
			
		}else {
			vo=err(401,"发送失败");
		}
	
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
