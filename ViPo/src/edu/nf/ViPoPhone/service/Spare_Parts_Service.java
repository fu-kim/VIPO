package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.Spare_Parts_Dao;
import edu.nf.ViPoPhone.entity.Spare_Parts;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class Spare_Parts_Service {
	public List<Spare_Parts> spareList(String pname) {
		Spare_Parts_Dao spd = new Spare_Parts_Dao();
		try {
			return spd.spareList(pname);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
		
	}
}
