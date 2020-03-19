package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.Coupon;
import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.listnener.MessageBroker;
import edu.nf.ViPoPhone.service.Coupon_Service;

@WebServlet("/shareCallback")
public class ShareCallbackServlet extends BasicServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		    Users user = (Users)request.getSession().getAttribute("user");
		    ResponseVO vo = null;
		    if (user==null) {
		    	 vo = success(401);
			}else {
				Map<String, ArrayBlockingQueue<Integer>> broker = 
						(Map<String, ArrayBlockingQueue<Integer>>)request.getServletContext().getAttribute(MessageBroker.BROKER_KEY);
				BlockingQueue<Integer> queue = broker.get(String.valueOf(user.getU_id()));
				try {
					
					Integer code = queue.take();
					String random = "";
					String[] doc = {"A","B","C","D","P","F","G","H","I","J","K","L","M","N","O","1","2","3","0","4","5","6","7","8","9","Q"};
					for(int i=0;i<8;i++)
					{
						int index = (int) (Math.random() * doc.length);
						random += doc[index];
					}
					Coupon c = new Coupon();
					c.setC_id(random);
					c.setU_phone(user.getU_phone());
					c.setC_name("分享返利，优惠100￥");
					c.setC_price(100);
					c.setC_time("2099/12/23");
					c.setC_status(0);
					Coupon_Service cs = new Coupon_Service();
					cs.insertCoupon(c);
					vo = success(code);
					//vo.setCode(code);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		    
			response.setContentType("application/json;charset=utf-8");
			String json = new Gson().toJson(vo);
			response.getWriter().println(json);
	}
	
	
}
