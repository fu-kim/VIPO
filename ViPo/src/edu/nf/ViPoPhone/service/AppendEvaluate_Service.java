package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.AppendEvaluate_Dao;
import edu.nf.ViPoPhone.entity.AppendEvaluate;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class AppendEvaluate_Service {
	public void insertAppendEvaluate(AppendEvaluate appendEvaluate) {
		AppendEvaluate_Dao aed = new AppendEvaluate_Dao();
		try {
			aed.insertAppendEvaluate(appendEvaluate);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public List<AppendEvaluate> selectAppendEvaluateByAid(String eid) {
		AppendEvaluate_Dao aed = new AppendEvaluate_Dao();
		try {
			return aed.selectAppendEvaluateByAid(eid);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
}
