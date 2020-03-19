package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.Orders_Dao;
import edu.nf.ViPoPhone.entity.Orders;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class Orders_Service {
	public void addOrders(Orders orders) {
		Orders_Dao od = new Orders_Dao();
		try {
			od.addOrders(orders);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public List<Orders> orderInfo(String orderId) {
		Orders_Dao od = new Orders_Dao();
		try {
			return od.orderInfo(orderId);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public Orders orderInfoCoupon(String orderId) {
		Orders_Dao od = new Orders_Dao();
		try {
			return od.orderInfoCoupon(orderId);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public List<Orders> selectOrderInfo(String uphone) {
		Orders_Dao od = new Orders_Dao();
		try {
			return od.selectOrderInfo(uphone);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public void updateOrderStatus(String orderId) {
		Orders_Dao od = new Orders_Dao();
		try {
			od.updateOrderStatus(orderId);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public void deleteOrder(String orderId) {
		Orders_Dao od = new Orders_Dao();
		try {
			od.deleteOrder(orderId);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public void updateOrderStatusIsSigned(String orderId) {
		Orders_Dao od = new Orders_Dao();
		try {
			od.updateOrderStatusIsSigned(orderId);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public void updateOrderEvaluate(String evaluateid,String orderId) {
		Orders_Dao od = new Orders_Dao();
		try {
			od.updateOrderEvaluate(evaluateid,orderId);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
}
