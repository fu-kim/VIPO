package edu.nf.ViPoPhone.service;


import java.util.Date;

import edu.nf.ViPoPhone.dao.UserDao;
import edu.nf.ViPoPhone.entity.Code;
import edu.nf.ViPoPhone.entity.Users;
import edu.nf.ViPoPhone.exception.DaoException;
import edu.nf.ViPoPhone.exception.UsersException;

public class UserService {
	/**
	 * 用户登录
	 */
	public Users loginUser(Users user) {
		UserDao dao=new UserDao();
		Users name=dao.loginUser(user.getU_name());
		if(name!=null && user.getU_password().equals(name.getU_password())) {
			return name;
		}
		throw new UsersException("账号或密码错误");
	}
	
	
	public Users userInfo(String uphone) {
		UserDao dao=new UserDao();
		try {
			return dao.userInfo(uphone);
		} catch (DaoException e) {
			throw new UsersException(e);
		}
	}
	/**
	 * 注册
	 */
	public void regisUser(Users user) {
		try {
			UserDao dao=new UserDao();
			Users name=dao.loginUser(user.getU_name());//判断用户是否存在
			if(name==null) {//用户不存在执行注册
				dao.regisUser(user);
			}else {
				throw new UsersException("账号已存在");
			}
		} catch (DaoException e) {
			throw new UsersException("服务错误");
		}
	}
	
	public void updatePwd(Users user) {
		try {
			UserDao dao=new UserDao();
			dao.updatePwd(user);
		} catch (DaoException e) {
			throw new UsersException("服务错误");
		}
	}
	
	public void updateMailbox(Users user) {
		try {
			UserDao dao=new UserDao();
			dao.updateMailbox(user);
		} catch (DaoException e) {
			throw new UsersException("服务错误");
		}
	}
	
	public void updateMyInfo(Users user) {
		try {
			UserDao dao=new UserDao();
			dao.updateMyInfo(user);
		} catch (DaoException e) {
			throw new UsersException("服务错误");
		}
	}
	
	public void updateMailbox(Users user,String code,Code c) {
		Long now = new Date().getTime();
		if (code.equals(c.getCode())) {
			if (now<=c.getEndTime()) {
				try {
					UserDao dao=new UserDao();
					dao.updateMailbox(user);
				} catch (DaoException e) {
					throw new UsersException("服务错误");
				}
			}else {
				throw new UsersException("验证码过时，请重新认证");
			}
		}else {
			throw new UsersException("验证码错误，请重新输入");
		}
		
	}
	
	public void updatePhone(Users user,String code,Code c,String newPhone) {
		Long now = new Date().getTime();
		if (code.equals(c.getCode())) {
			if (now<=c.getEndTime()) {
				try {
					UserDao dao=new UserDao();
					dao.updateUPhone(user,newPhone);
				} catch (DaoException e) {
					throw new UsersException(e.getMessage());
				}
			}else {
				throw new UsersException("验证码过时，请重新认证");
			}
		}else {
			throw new UsersException("验证码错误，请重新输入");
		}
		
	}
	/*
	 * public static void main(String[] args) { UserService service=new
	 * UserService(); Users user=new Users(); user.setName("yxd");
	 * user.setPassword("123"); user.setPhone("123333"); service.regisUser(user); }
	 */
}
