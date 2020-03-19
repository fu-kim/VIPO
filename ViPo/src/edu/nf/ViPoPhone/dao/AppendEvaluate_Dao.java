package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.AppendEvaluate;
import edu.nf.ViPoPhone.entity.Evaluate;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class AppendEvaluate_Dao {
	public void insertAppendEvaluate(AppendEvaluate appendEvaluate) {
		String sql = "insert e_append_review values(?,?,?,?,?,?,?)";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, appendEvaluate.getA_id());
			ps.setString(2, appendEvaluate.getE_id());
			ps.setString(3, appendEvaluate.getA_text());
			ps.setString(4, appendEvaluate.getA_image1());
			ps.setString(5, appendEvaluate.getA_image2());
			ps.setString(6, appendEvaluate.getA_image3());
			ps.setString(7, appendEvaluate.getA_date());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	public List<AppendEvaluate> selectAppendEvaluateByAid(String aid) {
		List<AppendEvaluate> appendevaluates = new ArrayList<AppendEvaluate>();
		String sql = "select * from e_append_review where a_id = ?";
		try(Connection conn = ConnUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, aid);
				try(ResultSet rs = ps.executeQuery()){
					AppendEvaluate a = null;
					if(rs.next()) {
						a = new AppendEvaluate();
						a.setA_id(rs.getString(1));
						a.setE_id(rs.getString(2));
						a.setA_text(rs.getString(3));
						a.setA_image1(rs.getString(4));
						a.setA_image2(rs.getString(5));
						a.setA_image3(rs.getString(6));
						a.setA_date(rs.getString(7));
						appendevaluates.add(a);
					}
					return appendevaluates;
				} catch (Exception e) {
					throw new DaoException(e.getMessage());
				}
				
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}

	}
}
