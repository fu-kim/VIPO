package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.Evaluate;
import edu.nf.ViPoPhone.entity.Orders;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class Evaluate_Dao {
	public void insertEvaluate(Evaluate evaluate) {
		String sql = "insert user_evaluate(e_id,u_phone,e_text,e_image1,e_image2,e_image3,e_rating,e_date) values(?,?,?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, evaluate.getE_id());
			ps.setString(2, evaluate.getU_phone());
			ps.setString(3, evaluate.getE_text());
			ps.setString(4, evaluate.getE_image1());
			ps.setString(5, evaluate.getE_image2());
			ps.setString(6, evaluate.getE_image3());
			ps.setString(7, evaluate.getE_rating());
			ps.setString(8, evaluate.getE_date());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public List<Evaluate> selectEvaluateByEid(String eid) {
		List<Evaluate> evaluates = new ArrayList<Evaluate>();
		String sql = "select * from user_evaluate where e_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, eid);
				try(ResultSet rs = ps.executeQuery()){
					Evaluate e = null;
					if(rs.next()) {
						e = new Evaluate();
						e.setE_id(rs.getString(1));
						e.setU_phone(rs.getString(2));
						e.setE_text(rs.getString(3));
						e.setE_image1(rs.getString(4));
						e.setE_image2(rs.getString(5));
						e.setE_image3(rs.getString(6));
						e.setE_rating(rs.getString(7));
						e.setE_date(rs.getString(8));
						e.setA_id(rs.getString(9));
						evaluates.add(e);
					}
					return evaluates;
				} catch (Exception e) {
					throw new DaoException(e.getMessage());
				}
				
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
	public void updateEvaluateAid(String aid,String eid) {
		String sql = "update user_evaluate set a_id=? where e_id=?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, aid);
			ps.setString(2, eid);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public List<Evaluate> selectEvaluateAll() {
		List<Evaluate> evaluates = new ArrayList<Evaluate>();
		String sql = "select * from user_evaluate order by e_date asc";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					Evaluate e = null;
					while(rs.next()) {
						e = new Evaluate();
						e.setE_id(rs.getString(1));
						e.setU_phone(rs.getString(2));
						e.setE_text(rs.getString(3));
						e.setE_image1(rs.getString(4));
						e.setE_image2(rs.getString(5));
						e.setE_image3(rs.getString(6));
						e.setE_rating(rs.getString(7));
						e.setE_date(rs.getString(8));
						e.setA_id(rs.getString(9));
						evaluates.add(e);
					}
					return evaluates;
				} catch (Exception e) {
					throw new DaoException(e.getMessage());
				}
				
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
	}
}
