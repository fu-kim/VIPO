package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.Shopping_Address_Service;

@WebServlet("/deleteaddress")
public class Delete_Address_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseVO vo=null;
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		
		String s_id = request.getParameter("s_id");


		Shopping_Address_Service sas = new Shopping_Address_Service();
		try {
			
			sas.deleteAddress(s_id);
			vo = success(200);
			
		} catch (DaoException e) {
			vo = success(401);
			throw new UsersException(e.getMessage());
		}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
		
	}
}
