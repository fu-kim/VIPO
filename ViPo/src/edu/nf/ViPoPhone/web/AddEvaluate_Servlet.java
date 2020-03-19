package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Evaluate;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.service.Evaluate_Service;
import edu.nf.ViPoPhone.service.Orders_Service;
import edu.nf.ViPoPhone.util.CodeUtil;
import edu.nf.ViPoPhone.util.FileNameUtil;
import edu.nf.ViPoPhone.util.UploadUtil;

@WebServlet("/addEvaluate")
@MultipartConfig
public class AddEvaluate_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String url="http://127.0.0.1:8089/Evaluate_image/";
		
		
		Date currentTime = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		String year =String.valueOf(c.get(Calendar.YEAR)); 
		String month = String.valueOf(c.get(Calendar.MONTH)+1); 
		String date = String.valueOf(c.get(Calendar.DATE)); 
		
		String evaluateid = year+month+date+CodeUtil.randomCode(6);
		String orderid = request.getParameter("orderid");
		String EText = request.getParameter("comtext");
		String etime = formatter.format(currentTime);
		String rating = request.getParameter("rating");
		String uphone = request.getParameter("uphone");
		//System.out.println(orderid+"  "+EText+"  "+rating+"  "+uphone);
		ResponseVO vo=null;
		try {
			String ename1;
			String ename2;
			String ename3;
			Part part1=request.getPart("loadcomimage1");
			Part part2=request.getPart("loadcomimage2");
			Part part3=request.getPart("loadcomimage3");
			if (part1.getSize()>0) {
				InputStream is=part1.getInputStream();
				//System.out.println(part);
				String filename=part1.getSubmittedFileName();
				ename1=FileNameUtil.newFileName(filename);
				
				UploadUtil.upload(url, is, ename1);
			}else {
				ename1=null;
			}
			
			if (part2.getSize()>0) {
				InputStream is=part2.getInputStream();
				//System.out.println(part);
				String filename=part2.getSubmittedFileName();
				ename2=FileNameUtil.newFileName(filename);
				
				UploadUtil.upload(url, is, ename2);
			}else {
				ename2=null;
			}
			
			if (part3.getSize()>0) {
				InputStream is=part3.getInputStream();
				//System.out.println(part);
				String filename=part3.getSubmittedFileName();
				ename3=FileNameUtil.newFileName(filename);
				
				UploadUtil.upload(url, is, ename3);
			}else {
				ename3=null;
			}
			
			Evaluate evaluate = new Evaluate();
			evaluate.setE_id(evaluateid);
			evaluate.setU_phone(uphone);
			evaluate.setE_text(EText);
			evaluate.setE_image1(ename1);
			evaluate.setE_image2(ename2);
			evaluate.setE_image3(ename3);
			evaluate.setE_rating(rating);
			evaluate.setE_date(etime);
			
			Evaluate_Service es = new Evaluate_Service();
			es.insertEvaluate(evaluate);
			
			Orders_Service od= new Orders_Service();
			od.updateOrderEvaluate(evaluateid, orderid);
			
			vo=success(200);
		} catch (Exception e) {
			vo=err(401,e.getMessage());
		}
		String json=new Gson().toJson(vo);
		pw.println(json);
	}
}
