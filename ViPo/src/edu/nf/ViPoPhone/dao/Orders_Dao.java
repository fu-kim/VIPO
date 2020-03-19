package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.Orders;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class Orders_Dao {
	public void addOrders(Orders orders) {
		String sql = "insert order_info(o_id,u_phone,o_time,o_address,o_name,o_tel,o_status,o_shopinfo,o_coupon_id,o_total,invoice_head) values(?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orders.getO_id());
			ps.setString(2, orders.getU_phone());
			ps.setString(3, orders.getO_time());
			ps.setString(4, orders.getO_address());
			ps.setString(5, orders.getO_name());
			ps.setString(6, orders.getO_tel());
			ps.setString(7, orders.getO_status());
			ps.setString(8, orders.getU_phone());
			ps.setString(9, orders.getO_coupon_id());
			ps.setDouble(10, orders.getO_total());
			ps.setString(11, orders.getInvoice());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public List<Orders> orderInfo(String orderId) {
		List<Orders> orders = new ArrayList<Orders>();
		String sql = "select * from order_info where o_id = ?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orderId);
			try(ResultSet rs = ps.executeQuery()){
				Orders o = null;
				ShoppingCartsDao scd = new ShoppingCartsDao();
				if(rs.next()) {
					o = new Orders();
					o.setO_id(rs.getString(1));
					o.setU_phone(rs.getString(2));
					o.setO_time(rs.getString(3));
					o.setO_address(rs.getString(4));
					o.setO_name(rs.getString(5));
					o.setO_tel(rs.getString(6));
					o.setO_status(rs.getString(7));
					//System.out.println(rs.getString(7));
					if (rs.getString(7).equals("未付款")) {
						o.setO_shop_info(scd.getShoppingPayByPhone(rs.getString(8),rs.getString(1)));
					}else{
						o.setO_shop_info(scd.getShoppingPayedByPhone(rs.getString(8),rs.getString(1)));
					}
					o.setO_coupon_id(rs.getString(9));
					o.setO_total(rs.getDouble(10));
					o.setInvoice(rs.getString(11));
					o.setEvaluate(rs.getString(12));
					orders.add(o);
				}
				return orders;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	public Orders orderInfoCoupon(String orderId) {
		String sql = "select o_coupon_id from order_info where o_id = ?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orderId);
			try(ResultSet rs = ps.executeQuery()){
				Orders o = null;
				ShoppingCartsDao scd = new ShoppingCartsDao();
				if(rs.next()) {
					o = new Orders();
					o.setO_coupon_id(rs.getString(1));
				}
				return o;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	public List<Orders> selectOrderInfo(String uphone) {
		List<Orders> orders = new ArrayList<Orders>();
		String sql = "select * from order_info where u_phone = ?  order by o_time asc";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, uphone);
			try(ResultSet rs = ps.executeQuery()){
				Orders o = null;
				ShoppingCartsDao scd = new ShoppingCartsDao();
				while(rs.next()) {
					o = new Orders();
					o.setO_id(rs.getString(1));
					o.setU_phone(rs.getString(2));
					o.setO_time(rs.getString(3));
					o.setO_address(rs.getString(4));
					o.setO_name(rs.getString(5));
					o.setO_tel(rs.getString(6));
					o.setO_status(rs.getString(7));
					//System.out.println(rs.getString(7));
					if (rs.getString(7).equals("未付款")) {
						o.setO_shop_info(scd.getShoppingPayByPhone(rs.getString(8),rs.getString(1)));
					}else{
						o.setO_shop_info(scd.getShoppingPayedByPhone(rs.getString(8),rs.getString(1)));
					}
					o.setO_coupon_id(rs.getString(9));
					o.setO_total(rs.getDouble(10));
					o.setInvoice(rs.getString(11));
					o.setEvaluate(rs.getString(12));
					orders.add(o);
				}
				return orders;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
		
	}
	public void updateOrderStatus(String orderId) {
		String sql = "update order_info set o_status='已付款' where o_id=?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orderId);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public void deleteOrder(String orderId) {
		String sql = "delete from order_info where o_id=?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orderId);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public void updateOrderStatusIsSigned(String orderId) {
		String sql = "update order_info set o_status='已签收' where o_id=?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orderId);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void updateOrderEvaluate(String evaluateid,String orderId) {
		String sql = "update order_info set evaluate=? where o_id=?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, evaluateid);
			ps.setString(2, orderId);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
}
