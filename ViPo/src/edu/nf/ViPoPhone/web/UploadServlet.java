package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.service.UserService;
import edu.nf.ViPoPhone.util.FileNameUtil;
import edu.nf.ViPoPhone.util.UploadUtil;


@WebServlet(urlPatterns = "/myupload")
@MultipartConfig
public class UploadServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String url="http://127.0.0.1:8089/myface/";
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");	
		
		String userName = request.getParameter("userName");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		
		//System.out.println("part"+fname+"  "+userName+"  "+sex+"  "+birthday);
		
		
		ResponseVO vo=null;
		try {
			String fname;
			Part part=request.getPart("load");
			System.out.println(part.getSize());
			if (part.getSize()>0) {
				InputStream is=part.getInputStream();
				//System.out.println(part);
				String filename=part.getSubmittedFileName();
				fname=FileNameUtil.newFileName(filename);
				
				UploadUtil.upload(url, is, fname);
			}else {
				fname=user.getU_head();
				
			}
			user.setU_name(userName);
			user.setU_sex(sex);
			user.setU_birthday(birthday);
			user.setU_head(fname);
			
			UserService us = new UserService();
			
			us.updateMyInfo(user);
			
			
			vo=success(200);
		} catch (Exception e) {
			vo=err(401,"错误");
		}
		String json=new Gson().toJson(vo);
		pw.println(json);
	}
}
