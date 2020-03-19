package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.Shopping_Address_Dao;
import edu.nf.ViPoPhone.entity.ShoppingAddress;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class Shopping_Address_Service {
	public List<ShoppingAddress> getaddress(String uphone) {
		Shopping_Address_Dao sad = new Shopping_Address_Dao();
		try {
			return sad.getaddress(uphone);
			
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	
	public void insertAddress(ShoppingAddress address) {
		Shopping_Address_Dao sad = new Shopping_Address_Dao();
		try {
			 sad.insertAddress(address);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	
	public void updateAddress(ShoppingAddress address) {
		Shopping_Address_Dao sad = new Shopping_Address_Dao();
		try {
			 sad.updateAddress(address);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
	public void deleteAddress(String s_id) {
		Shopping_Address_Dao sad = new Shopping_Address_Dao();
		try {
			 sad.deleteAddress(s_id);
		} catch (DaoException e) {
			throw new UsersException(e.getMessage());
		}
	}
}
