package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Spare_Parts;
import edu.nf.ViPoPhone.service.Spare_Parts_Service;

@WebServlet("/Spare_Parts")
public class Spare_Parts_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("pname");
		
		Spare_Parts_Service sps = new Spare_Parts_Service();
	
		List<Spare_Parts> sparelist = sps.spareList(pname);
		
		String json = new Gson().toJson(sparelist);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
	
}
