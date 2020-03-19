package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.City;
import edu.nf.ViPoPhone.entity.ShoppingAddress;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class Shopping_Address_Dao {
	public List<ShoppingAddress> getaddress(String uphone) {
		List<ShoppingAddress> addresslist = new ArrayList<ShoppingAddress>();
		String sql = "select * from shipping_address where u_phone = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, uphone);
				try(ResultSet rs = ps.executeQuery()){
					ShoppingAddress sa = null;
					while(rs.next()) {
						sa = new ShoppingAddress();
						sa.setS_id(rs.getString(1));
						sa.setU_phone(rs.getString(2));
						sa.setS_name(rs.getString(3));
						sa.setS_phone(rs.getString(4));
						sa.setS_adress(rs.getString(5));
						sa.setS_status(rs.getString(6));
						addresslist.add(sa);
					}
					return addresslist;
				} catch (Exception e) {
					throw new DaoException(e.getMessage());
				}
				
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	
	public void insertAddress(ShoppingAddress address) {
		String sql = "insert shipping_address values(?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, address.getU_phone());
			ps.setString(2, address.getS_name());
			ps.setString(3, address.getS_phone());
			ps.setString(4, address.getS_adress());
			ps.setString(5, address.getS_status());
			int i = ps.executeUpdate();
			if (i<=0) {
				throw new DaoException("添加失败");
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public void updateAddress(ShoppingAddress address) {
		String sql = "update shipping_address set s_name=?,s_phone=?,s_adress=?,s_status=? where s_id=?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, address.getS_name());
			ps.setString(2, address.getS_phone());
			ps.setString(3, address.getS_adress());
			ps.setString(4, address.getS_status());
			ps.setString(5, address.getS_id());
			int i = ps.executeUpdate();
			if (i<=0) {
				throw new DaoException("修改失败");
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void deleteAddress(String s_id) {
		String  sql = "delete from shipping_address where s_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, s_id);
				int i = ps.executeUpdate();
				if (i<=0) {
					throw new DaoException("删除失败");
				}
			}catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
}
