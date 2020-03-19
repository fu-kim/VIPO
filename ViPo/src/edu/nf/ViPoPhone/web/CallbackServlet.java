package edu.nf.ViPoPhone.web;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.nf.ViPoPhone.entity.ResponseVO;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.listnener.MessageBroker;
import edu.nf.ViPoPhone.service.Orders_Service;
import edu.nf.ViPoPhone.service.ShoppingCartService;


@WebServlet("/paymentCallback")
public class CallbackServlet extends BasicServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		    Users user = (Users)request.getSession().getAttribute("user");
		    ResponseVO vo = null;
		    if (user==null) {
		    	 vo = success(401);
			}else {
				String uphone = user.getU_phone();
			    String orderid = (String) request.getSession().getAttribute("payOrderId");
			    //System.out.println("~~~~~~~~~~~~~~~~~"+user.getU_id());
				Map<String, ArrayBlockingQueue<Integer>> broker = 
						(Map<String, ArrayBlockingQueue<Integer>>)request.getServletContext().getAttribute(MessageBroker.BROKER_KEY);
				BlockingQueue<Integer> queue = broker.get(String.valueOf(user.getU_id()));
				try {
					//take方法，如果阻塞队列中没有任何消息，此方法会阻塞
					Integer code = queue.take();
					ShoppingCartService scs = new ShoppingCartService();
					scs.updatepayedorno(orderid);
					Orders_Service os = new Orders_Service();
					os.updateOrderStatus(orderid);
					//System.out.println("code: "+code);
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
