package edu.nf.ViPoPhone.entity;

public class Coupon {
	private String c_id;
	private String u_phone;
	private String c_name;
	private Integer c_price;
	private String c_time;
	private Integer c_status;
	
	
	

	public Coupon(String c_id, String u_phone, String c_name, Integer c_price, String c_time, Integer c_status) {
		super();
		this.c_id = c_id;
		this.u_phone = u_phone;
		this.c_name = c_name;
		this.c_price = c_price;
		this.c_time = c_time;
		this.c_status = c_status;
	}


	public Integer getC_status() {
		return c_status;
	}


	public void setC_status(Integer c_status) {
		this.c_status = c_status;
	}


	public String getC_id() {
		return c_id;
	}


	public void setC_id(String c_id) {
		this.c_id = c_id;
	}


	public String getU_phone() {
		return u_phone;
	}


	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public Integer getC_price() {
		return c_price;
	}


	public void setC_price(Integer c_price) {
		this.c_price = c_price;
	}


	public String getC_time() {
		return c_time;
	}


	public void setC_time(String c_time) {
		this.c_time = c_time;
	}


	public Coupon() {
		super();
	}
	
	
}
