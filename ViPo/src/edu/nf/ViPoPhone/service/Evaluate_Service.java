package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.Evaluate_Dao;
import edu.nf.ViPoPhone.entity.Evaluate;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class Evaluate_Service {
	public void insertEvaluate(Evaluate evaluate) {
		Evaluate_Dao ed = new Evaluate_Dao();
		try {
			ed.insertEvaluate(evaluate);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public List<Evaluate> selectEvaluateByEid(String eid) {
		Evaluate_Dao ed = new Evaluate_Dao();
		try {
			return ed.selectEvaluateByEid(eid);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public void updateEvaluateAid(String aid,String eid) {
		Evaluate_Dao ed = new Evaluate_Dao();
		try {
			ed.updateEvaluateAid(aid,eid);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public List<Evaluate> selectEvaluateAll() {
		Evaluate_Dao ed = new Evaluate_Dao();
		try {
			return ed.selectEvaluateAll();
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
}
