package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.PhoneInfo;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;



public class PhoneInfo_Dao {
	
	public PhoneInfo getPhoneInfoByName(String phone) {
		String sql="select u_phone,p_pic,p_series_name,p_phone_name,p_amount,p_price,p_gift,p_gift_pic,p_memory,p_total from phone_info where p_phone_name=?";
		PhoneInfo sc = null;
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, phone);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					sc = new PhoneInfo();
					sc.setU_phone(rs.getString(1));
					sc.setP_pic(rs.getString(2));
					sc.setP_series_name(rs.getString(3));
					sc.setP_phone_name(rs.getString(4));
					sc.setP_amount(rs.getInt(5));
					sc.setP_price(rs.getDouble(6));
					sc.setP_gift(rs.getString(7));
					sc.setP_gift_pic(rs.getString(8));
					sc.setP_memory(rs.getString(9));
					sc.setP_total(rs.getDouble(10));
				}
				return sc;
			}catch(Exception e) {
				throw new DaoException(e.getMessage());
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
}
