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

import edu.nf.ViPoPhone.entity.AppendEvaluate;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.service.AppendEvaluate_Service;
import edu.nf.ViPoPhone.service.Evaluate_Service;
import edu.nf.ViPoPhone.util.CodeUtil;
import edu.nf.ViPoPhone.util.FileNameUtil;
import edu.nf.ViPoPhone.util.UploadUtil;

@WebServlet("/addAppendEvaluate")
@MultipartConfig
public class AddAppendEvaluate_Servlet extends BasicServlet{
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
		
		String appendevaluateid = year+month+date+CodeUtil.randomCode(6);
		String appendtext = request.getParameter("appendtext");
		String atime = formatter.format(currentTime);
		String eid = request.getParameter("eid");
		//System.out.println(orderid+"  "+EText+"  "+rating+"  "+uphone);
		ResponseVO vo=null;
		try {
			String ename1;
			String ename2;
			String ename3;
			Part part1=request.getPart("loadcomimages1");
			Part part2=request.getPart("loadcomimages2");
			Part part3=request.getPart("loadcomimages3");
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
			
			AppendEvaluate ae = new AppendEvaluate();
			ae.setA_id(appendevaluateid);
			ae.setE_id(eid);
			ae.setA_text(appendtext);
			ae.setA_image1(ename1);
			ae.setA_image2(ename2);
			ae.setA_image3(ename3);
			ae.setA_date(atime);
			
			AppendEvaluate_Service aes = new AppendEvaluate_Service();
			aes.insertAppendEvaluate(ae);
			
			Evaluate_Service es = new Evaluate_Service();
			es.updateEvaluateAid(appendevaluateid, eid);
			
			vo=success(200);
		} catch (Exception e) {
			vo=err(401,e.getMessage());
		}
		String json=new Gson().toJson(vo);
		pw.println(json);
	}
}
