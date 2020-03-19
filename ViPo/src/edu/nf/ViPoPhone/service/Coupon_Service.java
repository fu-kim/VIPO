package edu.nf.ViPoPhone.service;

import java.util.List;

import edu.nf.ViPoPhone.dao.Coupon_Dao;
import edu.nf.ViPoPhone.entity.Coupon;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class Coupon_Service {
	public List<Coupon> CouponsByUphone(String uphone) {
		Coupon_Dao cd = new Coupon_Dao();
		try {
			return cd.CouponsByUphone(uphone);
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
	public List<Coupon> CouponsByUphoneCid(String uphone,String cid) {
		Coupon_Dao cd = new Coupon_Dao();
		try {
			List<Coupon> cList = cd.CouponsByUphoneCid(uphone,cid);
			return cList;
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
	public void UpdateCouponStatusno(String uphone,String cid) {
		Coupon_Dao cd = new Coupon_Dao();
		try {
			cd.UpdateCouponStatusno(uphone, cid);
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
	public void UpdateCouponStatusyes(String cid) {
		Coupon_Dao cd = new Coupon_Dao();
		try {
			cd.UpdateCouponStatusyes(cid);
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
	public void insertCoupon(Coupon coupon) {
		Coupon_Dao cd = new Coupon_Dao();
		try {
			cd.insertCoupon(coupon);
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
	public List<Coupon> CouponsByCid(String cid) {
		Coupon_Dao cd = new Coupon_Dao();
		try {
			return cd.CouponsByCid(cid);
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
}
