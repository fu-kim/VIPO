package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.ShoppingCart;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;


public class ShoppingCartsDao {

	public List<ShoppingCart> getShoppingCartByPhone(String phone) {
		String sql="select * from shopping_cart where u_phone = ? and payorno='否'";
		List<ShoppingCart> lsc = new ArrayList<>();
		
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					ShoppingCart sc = new ShoppingCart();
					sc.setShop_id(rs.getInt(1));
					sc.setU_phone(rs.getString(2));
					sc.setShop_pic(rs.getString(3));
					sc.setShop_name(rs.getString(4));
					sc.setShop_price(rs.getDouble(5));
					sc.setShop_amount(rs.getInt(6));
					sc.setShop_gift(rs.getString(7));
					sc.setShop_gift_pic(rs.getString(8));
					sc.setShop_total(rs.getDouble(9));
					sc.setPayorno(rs.getString(10));
					sc.setShop_checked(rs.getInt(11));
					lsc.add(sc);
				}
				return lsc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public List<ShoppingCart> getShoppingPayedByPhone(String phone,String orderid) {
		String sql="select * from shopping_cart where u_phone = ? and payorno='已付款'  and shop_checked='1' and order_id=?";
		List<ShoppingCart> lsc = new ArrayList<>();
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			ps.setString(2, orderid);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					ShoppingCart sc = new ShoppingCart();
					sc.setShop_id(rs.getInt(1));
					sc.setU_phone(rs.getString(2));
					sc.setShop_pic(rs.getString(3));
					sc.setShop_name(rs.getString(4));
					sc.setShop_price(rs.getDouble(5));
					sc.setShop_amount(rs.getInt(6));
					sc.setShop_gift(rs.getString(7));
					sc.setShop_gift_pic(rs.getString(8));
					sc.setShop_total(rs.getDouble(9));
					sc.setPayorno(rs.getString(10));
					sc.setShop_checked(rs.getInt(11));
					sc.setOrder_id(rs.getString(12));
					lsc.add(sc);
				}
				return lsc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public List<ShoppingCart> getShoppingPayByPhone(String phone,String orderid) {
		String sql="select * from shopping_cart where u_phone = ? and payorno='未支付'  and shop_checked='1' and order_id=?";
		List<ShoppingCart> lsc = new ArrayList<>();
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			ps.setString(2, orderid);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					ShoppingCart sc = new ShoppingCart();
					sc.setShop_id(rs.getInt(1));
					sc.setU_phone(rs.getString(2));
					sc.setShop_pic(rs.getString(3));
					sc.setShop_name(rs.getString(4));
					sc.setShop_price(rs.getDouble(5));
					sc.setShop_amount(rs.getInt(6));
					sc.setShop_gift(rs.getString(7));
					sc.setShop_gift_pic(rs.getString(8));
					sc.setShop_total(rs.getDouble(9));
					sc.setPayorno(rs.getString(10));
					sc.setShop_checked(rs.getInt(11));
					sc.setOrder_id(rs.getString(12));
					lsc.add(sc);
				}
				return lsc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public List<ShoppingCart> getShoppingCartsByPhone(String phone) {
		String sql="select * from shopping_cart where u_phone = ? and payorno='否'  and shop_checked='1'";
		List<ShoppingCart> lsc = new ArrayList<>();
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					ShoppingCart sc = new ShoppingCart();
					sc.setShop_id(rs.getInt(1));
					sc.setU_phone(rs.getString(2));
					sc.setShop_pic(rs.getString(3));
					sc.setShop_name(rs.getString(4));
					sc.setShop_price(rs.getDouble(5));
					sc.setShop_amount(rs.getInt(6));
					sc.setShop_gift(rs.getString(7));
					sc.setShop_gift_pic(rs.getString(8));
					sc.setShop_total(rs.getDouble(9));
					sc.setPayorno(rs.getString(10));
					sc.setShop_checked(rs.getInt(11));
					lsc.add(sc);
				}
				return lsc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public ShoppingCart getShoppingCartTotal(String phone) {
		String sql="select SUM(shop_total) from shopping_cart where u_phone = ? and payorno = '否' and shop_checked = 1 ";
		ShoppingCart sc = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new ShoppingCart();
					sc.setShop_total(rs.getDouble(1));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public ShoppingCart getShoppingCartTotalByOrderid(String orderid) {
		String sql="select SUM(shop_total) from shopping_cart where order_id = ?";
		ShoppingCart sc = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, orderid);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new ShoppingCart();
					sc.setShop_total(rs.getDouble(1));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public ShoppingCart getShoppingIdByName(String phone ,String name) {
		String sql="select shop_id,shop_name,shop_amount,shop_total from shopping_cart where u_phone=? and shop_name = ? and payorno='否'";
		ShoppingCart sc= null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			ps.setString(2, name);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new ShoppingCart();
					sc.setShop_id(rs.getInt(1));
					sc.setShop_name(rs.getString(2));
					sc.setShop_amount(rs.getInt(3));
					sc.setShop_total(rs.getDouble(4));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void insertCart(ShoppingCart sc) {
		String sql = "insert shopping_cart values(?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,sc.getU_phone());
			ps.setString(2, sc.getShop_pic());
			ps.setString(3, sc.getShop_name());
			ps.setDouble(4, sc.getShop_price());
			ps.setInt(5, sc.getShop_amount());
			ps.setString(6, sc.getShop_gift());
			ps.setString(7, sc.getShop_gift_pic());
			ps.setDouble(8, sc.getShop_total());
			ps.setString(9, sc.getPayorno());
			ps.setInt(10, sc.getShop_checked());
			ps.setInt(11, 0);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	
	public int deleteCart(int id) {
		String sql = "delete from shopping_cart where shop_id= ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			return ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public int updateShoppingCart(Integer amount,Double total,Integer sid) {
		String sql="update shopping_cart set shop_amount=?,shop_total=? where shop_id=?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, amount);
			ps.setDouble(2,total);
			ps.setInt(3, sid);
			return ps.executeUpdate();
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	
	public int updateShoppingCartChecked(int chec,int sid) {
		String sql="update shopping_cart set shop_checked = ? where shop_id= ? ";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, chec);
			ps.setInt(2, sid);
			return ps.executeUpdate();
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	
	public int updateShoppingCartAmount(Integer amount,Double total,String name) {
		String sql="update shopping_cart set shop_amount=?,shop_total=? where shop_name = ? and shop_checked = '1' ";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, amount);
			ps.setDouble(2, total);
			ps.setString(3, name);
			return ps.executeUpdate();
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	
	public ShoppingCart getCountByPhone(String phone) {
		String sql = "select sum(shop_amount) from shopping_cart where u_phone = ? and shop_checked = 1 and payorno='否'";
		ShoppingCart sc = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, phone);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new ShoppingCart();
					sc.setShop_amount(rs.getInt(1));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	public ShoppingCart getCountByOrderId(String orderid) {
		String sql = "select sum(shop_amount) from shopping_cart where order_id = ?";
		ShoppingCart sc = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, orderid);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new ShoppingCart();
					sc.setShop_amount(rs.getInt(1));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	public ShoppingCart getCheckByPhone(int sid) {
		String sql = "select shop_checked from shopping_cart where shop_id = ? ";
		ShoppingCart sc = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, sid);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new ShoppingCart();
					sc.setShop_checked(rs.getInt(1));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	
	public void updatepayorno(String orderid,String uphone) {
		String sql="update shopping_cart set payorno='未支付',order_id=? where u_phone=? and shop_checked = 1 and payorno='否'";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1,orderid);
			ps.setString(2,uphone);
			ps.executeUpdate();
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
	public void updatepayedorno(String orderid) {
		String sql="update shopping_cart set payorno='已付款' where order_id=? and shop_checked = 1 and payorno='未支付'";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1,orderid);
			ps.executeUpdate();
		}catch(Exception e) {
			 throw new DaoException(e.getMessage());
		 }
	}
}
