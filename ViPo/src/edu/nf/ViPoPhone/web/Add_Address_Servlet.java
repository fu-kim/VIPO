package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.ShoppingAddress;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.Shopping_Address_Service;

@WebServlet("/saveaddress")
public class Add_Address_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseVO vo=null;
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		Users users=(Users)session.getAttribute("user");
		
		String u_phone = users.getU_phone();
		String s_name = request.getParameter("s_name");
		String s_phone = request.getParameter("s_phone");
		
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String qu = request.getParameter("qu");
		String jiedao = request.getParameter("jiedao");
		String address = request.getParameter("address");
		String s_address = sheng+" "+shi+" "+qu+" "+jiedao+" "+address;
		
		ShoppingAddress sa = new ShoppingAddress();
		sa.setU_phone(u_phone);
		sa.setS_adress(s_address);
		sa.setS_name(s_name);
		sa.setS_phone(s_phone);
		sa.setS_status("否");
		
		Shopping_Address_Service sas = new Shopping_Address_Service();
		try {
			sas.insertAddress(sa);
			
			vo = success(200);
		} catch (DaoException e) {
			vo = success(401);
			throw new UsersException(e.getMessage());
		}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
		
	}
}
