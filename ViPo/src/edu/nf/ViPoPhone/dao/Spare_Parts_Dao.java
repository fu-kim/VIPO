package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.Spare_Parts;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class Spare_Parts_Dao {
	public List<Spare_Parts> spareList(String pname) {
		List<Spare_Parts> clist =new ArrayList<Spare_Parts>();
		String sql = "select * from spare_parts where p_name = ?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, pname);
			try(ResultSet rs = ps.executeQuery()){
				Spare_Parts sp = null;
				while(rs.next()) {
					sp = new Spare_Parts();
					sp.setP_name(rs.getString(1));
					sp.setP_spare_name(rs.getString(2));
					sp.setP_price(rs.getString(3));
					clist.add(sp);
				}
				return clist;
			} catch (Exception e) {
				throw new DaoException(e.getMessage());
			}
			
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
}
