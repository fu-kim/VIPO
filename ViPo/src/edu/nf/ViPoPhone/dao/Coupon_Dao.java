package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.City;
import edu.nf.ViPoPhone.entity.Coupon;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class Coupon_Dao {
	public List<Coupon> CouponsByUphone(String uphone) {
		List<Coupon> Couponlist =new ArrayList<Coupon>();
		String sql = "select * from coupon where c_u_phone = ? and c_status=0";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, uphone);
			try(ResultSet rs = ps.executeQuery()){
				Coupon c = null;
				while(rs.next()) {
					c = new Coupon();
					c.setC_id(rs.getString(1));
					c.setU_phone(rs.getString(2));
					c.setC_name(rs.getString(3));
					c.setC_price(rs.getInt(4));
					c.setC_time(rs.getString(5));
					Couponlist.add(c);
				}
				return Couponlist;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	public List<Coupon> CouponsByCid(String cid) {
		List<Coupon> Couponlist =new ArrayList<Coupon>();
		String sql = "select * from coupon where c_id = ? and c_status=1";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, cid);
			try(ResultSet rs = ps.executeQuery()){
				Coupon c = null;
				if(rs.next()) {
					c = new Coupon();
					c.setC_id(rs.getString(1));
					c.setU_phone(rs.getString(2));
					c.setC_name(rs.getString(3));
					c.setC_price(rs.getInt(4));
					c.setC_time(rs.getString(5));
					Couponlist.add(c);
				}
				return Couponlist;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	public List<Coupon> CouponsByUphoneCid(String uphone,String cid) {
		List<Coupon> Couponlist =new ArrayList<Coupon>();
		String sql = "select * from coupon where c_u_phone = ? and c_id = ?  and c_status=0";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, uphone);
			ps.setString(2, cid);
			try(ResultSet rs = ps.executeQuery()){
				Coupon c = null;
				if(rs.next()) {
					c = new Coupon();
					c.setC_id(rs.getString(1));
					c.setU_phone(rs.getString(2));
					c.setC_name(rs.getString(3));
					c.setC_price(rs.getInt(4));
					c.setC_time(rs.getString(5));
					Couponlist.add(c);
				}
				return Couponlist;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	public void UpdateCouponStatusno(String uphone,String cid) {
		String sql="update coupon set c_status=1  where c_u_phone=? and c_id=?  and c_status=0";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, uphone);
			ps.setString(2, cid);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	public void UpdateCouponStatusyes(String cid) {
		String sql="update coupon set c_status=0  where c_id=?  and c_status=1";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, cid);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	
	public void insertCoupon(Coupon coupon) {
		String sql="insert coupon values(?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, coupon.getC_id());
			ps.setString(2, coupon.getU_phone());
			ps.setString(3, coupon.getC_name());
			ps.setInt(4, coupon.getC_price());
			ps.setString(5, coupon.getC_time());
			ps.setInt(6, coupon.getC_status());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
}
