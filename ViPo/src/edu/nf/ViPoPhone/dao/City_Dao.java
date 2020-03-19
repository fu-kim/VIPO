package edu.nf.ViPoPhone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nf.ViPoPhone.entity.City;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.util.ConnUtils;

public class City_Dao {
	public List<City> cityList(String cityName) {
		List<City> clist =new ArrayList<City>();
		String sql = "select * from city_info where s_city = ?";
		try(Connection conn = ConnUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, cityName);
			try(ResultSet rs = ps.executeQuery()){
				City c = null;
				while(rs.next()) {
					c = new City();
					c.setS_city(rs.getString(1));
					c.setS_city_a(rs.getString(2));
					c.setS_adress(rs.getString(3));
					c.setS_phone(rs.getString(4));
					c.setS_time(rs.getString(5));
					clist.add(c);
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
