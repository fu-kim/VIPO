package edu.nf.ViPoPhone.listnener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MessageBroker implements ServletContextListener {
	
	public static final String BROKER_KEY = "ViPo";

	
	/**
	 * 清空消息中心的阻塞队列
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		Map<String, ArrayBlockingQueue<Integer>> broker = 
				(Map<String, ArrayBlockingQueue<Integer>>)event.getServletContext().getAttribute(BROKER_KEY);
		broker.clear();
	}

	/**
	 * 初始化方法中创建一个消息队列中心，
	 * key为用户ID，value是一个阻塞队列
	 * 每一个用户都拥有自己的阻塞队列。
	 * 并将消息中心存入上下文作用域
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		Map<String, ArrayBlockingQueue<Integer>> broker = new HashMap<>();
		event.getServletContext().setAttribute(BROKER_KEY, broker);
	}
	
	

}
