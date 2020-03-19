package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.City;
import edu.nf.ViPoPhone.service.City_Service;

@WebServlet("/city")
public class City_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cityName = request.getParameter("cityName");
		
		City_Service cs = new City_Service();
		
		List<City> clist = cs.cityList(cityName);
		
		String json = new Gson().toJson(clist);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
