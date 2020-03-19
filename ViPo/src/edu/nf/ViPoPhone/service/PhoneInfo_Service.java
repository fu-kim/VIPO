package edu.nf.ViPoPhone.service;

import edu.nf.ViPoPhone.dao.PhoneInfo_Dao;
import edu.nf.ViPoPhone.entity.PhoneInfo;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class PhoneInfo_Service {
	
	public PhoneInfo getPhoneInfoByName(String name) {
		PhoneInfo_Dao dao = new PhoneInfo_Dao();
		try {
			return dao.getPhoneInfoByName(name);
		}catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	
}
