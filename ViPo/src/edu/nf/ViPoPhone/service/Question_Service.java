package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.Question_Dao;
import edu.nf.ViPoPhone.entity.Question;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;


public class Question_Service {
	public List<Question> cityList(String title) {
		Question_Dao qd = new Question_Dao();
		try {
			return qd.listQuestions(title);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
}
