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

@WebServlet("/couponok")
public class CouponOk_Servlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		ResponseVO vo=null;
		HttpSession session = request.getSession();
		Users users =  (Users) session.getAttribute("user");
		if (users==null) {
			vo = err(401,"请先登录");
		}
		else {
			String uphone = users.getU_phone();
			String cid = request.getParameter("cid");
			Coupon_Service cs = new Coupon_Service();
			try {
				List<Coupon> coupons = cs.CouponsByUphoneCid(uphone, cid);
				if(coupons.size()<=0) {
					vo = err(402,"优惠券码不正确");
				}else {
					vo = success(200,coupons);
				}
			} catch (UsersException e) {
				vo = err(402,e.getMessage());
			}

		}
		
		String json = new Gson().toJson(vo);
		pw.println(json);
	}
}
