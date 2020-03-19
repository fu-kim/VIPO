package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.City;
import edu.nf.ViPoPhone.entity.Question;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;


public class Question_Dao {
	public List<Question> listQuestions(String title){
		List<Question> que = new ArrayList<Question>();
		String sql = "select * from question_info where q_title like ?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, "%"+title+"%");
			try(ResultSet rs = ps.executeQuery()){
				Question q = null;
				while(rs.next()) {
					q = new Question();
					q.setQ_id(rs.getInt(1));
					q.setQ_title(rs.getString(2));
					q.setQ_text(rs.getString(3));
					que.add(q);
				}
				return que;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
}
