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

import edu.nf.ViPoPhone.entity.Coupon;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.Coupon_Service;

@WebServlet("/couponokinfo")
public class CouponOKInfo_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;

			String cid = request.getParameter("cid");
			
			Coupon_Service cs = new Coupon_Service();
			try {
				List<Coupon> coupons = cs.CouponsByCid(cid);
				vo = success(200,coupons);
			} catch (UsersException e) {
				vo = err(402,e.getMessage());
			}

		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
