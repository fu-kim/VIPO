package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.City_Dao;
import edu.nf.ViPoPhone.entity.City;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class City_Service {
	public List<City> cityList(String cityName) {
		City_Dao cd = new City_Dao();
		try {
			return cd.cityList(cityName);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
		
	}
}
