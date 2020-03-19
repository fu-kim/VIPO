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

import edu.nf.ViPoPhone.listnener.MessageBroker;


@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			String userId = request.getParameter("userId");
			//System.out.println(userId);
			//执行支付请求处理
			//从上下文获取消息中心实例
			Map<String, ArrayBlockingQueue<Integer>> broker = 
					(Map<String, ArrayBlockingQueue<Integer>>)request.getServletContext().getAttribute(MessageBroker.BROKER_KEY);
			//根据用户ID获取对应的阻塞队列
			BlockingQueue<Integer> queue = broker.get(userId);
			//放入状态信息
			try {
				queue.put(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

}
