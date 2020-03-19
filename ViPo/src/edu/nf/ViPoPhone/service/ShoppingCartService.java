package edu.nf.ViPoPhone.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import edu.nf.ViPoPhone.dao.ShoppingCartsDao;
import edu.nf.ViPoPhone.entity.ShoppingCart;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;
import edu.nf.ViPoPhone.util.ConnUtils;


public class ShoppingCartService {
	
	public List<ShoppingCart> getShoppingCart(String phone) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try{
			return dao.getShoppingCartByPhone(phone);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public List<ShoppingCart> getShoppingCartsByPhone(String phone) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try{
			return dao.getShoppingCartsByPhone(phone);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public ShoppingCart getShoppingCartTotal(String phone) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try{
			return dao.getShoppingCartTotal(phone);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public ShoppingCart getShoppingCartTotalByOrderid(String orderid) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try{
			return dao.getShoppingCartTotalByOrderid(orderid);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	public int deleteCart(int id) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try{
			return dao.deleteCart(id);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public void insertCart(ShoppingCart sc) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try{
			dao.insertCart(sc);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public int updateCart(Integer amount,Double total,Integer sid) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			return dao.updateShoppingCart(amount,total,sid);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public int updateShoppingCartChecked(Integer chec,Integer sid) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			return dao.updateShoppingCartChecked(chec,sid);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public int updateCartAmount(Integer amount,Double total,String name) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			return dao.updateShoppingCartAmount(amount,total,name);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public ShoppingCart getShoppingIdByName(String phone,String name) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			return dao.getShoppingIdByName(phone,name);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public ShoppingCart getCountByPhone(String phone) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			return dao.getCountByPhone(phone);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public ShoppingCart getCountByOrderId(String orderid) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			return dao.getCountByOrderId(orderid);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	
	public void updatepayorno(String orderid,String uphone) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			dao.updatepayorno(orderid,uphone);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
	public void updatepayedorno(String orderid) {
		ShoppingCartsDao dao = new ShoppingCartsDao();
		try {
			dao.updatepayedorno(orderid);
		}catch(DaoException e) {
			throw new UsersException("SQL������"+e.getMessage());
		}
	}
}
