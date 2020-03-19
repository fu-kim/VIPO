package edu.nf.ViPoPhone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.PhoneInfo;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.ShoppingCart;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.service.PhoneInfo_Service;
import edu.nf.ViPoPhone.service.ShoppingCartService;

@WebServlet("/phone_info")
public class PhoneInfoServlet extends BasicServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("user");
		ResponseVO vo=null;
		String phone=user.getU_phone();
		//String pphone = request.getParameter("phone");
		String name = request.getParameter("pname");
		Integer number =Integer.valueOf(request.getParameter("pnumber"));
		PhoneInfo_Service service = new PhoneInfo_Service();
		PhoneInfo pi =service.getPhoneInfoByName(name);
		
		ShoppingCart sc = new ShoppingCart(); 
		sc.setU_phone(phone); 
		sc.setShop_pic(pi.getP_pic());
		sc.setShop_name(pi.getP_phone_name());
		sc.setShop_price(pi.getP_price());
		sc.setShop_amount(number);
		sc.setShop_gift(pi.getP_gift());
		sc.setShop_gift_pic(pi.getP_gift_pic());
		sc.setShop_total(pi.getP_total()*number);
		sc.setPayorno("否");
		sc.setShop_checked(1);
		
		ShoppingCartService scs = new ShoppingCartService();
		ShoppingCart cart = scs.getShoppingIdByName(phone,name);
		
		  try { 
			  if(cart == null ){
				  scs.insertCart(sc);
			  }else {
				  System.out.println(pi.getP_price() * (cart.getShop_amount() + number));
				  scs.updateCartAmount(cart.getShop_amount() + number,pi.getP_price() * (cart.getShop_amount() + number),
						  cart.getShop_name()); 
			 }
			  vo=success(200);
		  }
		  catch(UsersException e) {
			  vo=err(400,e.getMessage()); 
			  //response.getWriter().println("添加失败！"); 
		  }
		// System.out.println(cart.getShop_total());
		response.setContentType("application/json;charset=utf-8");
		String json = new Gson().toJson(vo);
		response.getWriter().println(json);
	}
	
}
