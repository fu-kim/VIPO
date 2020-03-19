package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;


public class UserDao {
	/**
	 * 用户登录
	 */
	public Users loginUser(String name) {
		String sql="select * from users where u_name=?";
		try (Connection con=ConnUtils.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, name);
			try (ResultSet rs=ps.executeQuery()){
				Users user=null;
				if(rs.next()) {
					user=new Users();
					user.setU_id(rs.getInt(1));
					user.setU_name(rs.getString(2));
					user.setU_phone(rs.getString(3));
					user.setU_password(rs.getString(4));
					user.setU_mailbox(rs.getString(5));
					user.setU_birthday(rs.getString(6));
					user.setU_sex(rs.getString(7));
					user.setU_head(rs.getString(8));
					user.setU_integral(rs.getInt(9));
				}
				return user;
				
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public Users userInfo(String uphone) {
		String sql="select * from users where u_phone=?";
		try (Connection con=ConnUtils.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, uphone);
			try (ResultSet rs=ps.executeQuery()){
				Users user=null;
				if(rs.next()) {
					user=new Users();
					user.setU_id(rs.getInt(1));
					user.setU_name(rs.getString(2));
					user.setU_phone(rs.getString(3));
					user.setU_password(rs.getString(4));
					user.setU_mailbox(rs.getString(5));
					user.setU_birthday(rs.getString(6));
					user.setU_sex(rs.getString(7));
					user.setU_head(rs.getString(8));
					user.setU_integral(rs.getInt(9));
				}
				return user;
				
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	/**
	 * 用户注册
	 */
	public void regisUser(Users user) {
		String sql="insert into users(u_name,u_phone,u_password) values(?,?,?)";
		try (Connection con=ConnUtils.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, user.getU_name());
			ps.setString(2, user.getU_phone());
			ps.setString(3, user.getU_password());
			int row=ps.executeUpdate();
			if(row==0) {
				throw new DaoException("注册失败");
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void updatePwd(Users user) {
		String sql="update users set u_password = ? where u_phone = ?";
		try (Connection con=ConnUtils.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, user.getU_password());
			ps.setString(2,user. getU_phone());
			int row=ps.executeUpdate();
			if(row==0) {
				throw new DaoException("修改失败");
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void updateMailbox(Users user) {
		String sql="update users set u_mailbox = ? where u_phone = ?";
		try (Connection con=ConnUtils.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, user.getU_mailbox());
			ps.setString(2,user. getU_phone());
			int row=ps.executeUpdate();
			if(row==0) {
				throw new DaoException("失败");
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void updateMyInfo(Users user) {
		String sql="update users set u_name = ?,u_birthday = ?,u_sex = ?,u_head = ? where u_phone = ?";
		try (Connection con=ConnUtils.getConnection();
			PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, user.getU_name());
			ps.setString(2, user.getU_birthday());
			ps.setString(3, user.getU_sex());
			ps.setString(4, user.getU_head());
			ps.setString(5, user.getU_phone());
			int row=ps.executeUpdate();
			if(row==0) {
				throw new DaoException("失败");
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public void updateUPhone(Users user,String newPhone) {
		String sql="update users set u_phone = ? where u_phone = ?";
		try (Connection con=ConnUtils.getConnection();
			PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, newPhone);
			ps.setString(2, user.getU_phone());
			user.setU_phone(newPhone);
			int row=ps.executeUpdate();
			if(row==0) {
				throw new DaoException("失败");
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
}
