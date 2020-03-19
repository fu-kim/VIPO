package edu.nf.ViPoPhone.entity;

import java.util.List;

public class Orders {
	private String o_id;
	private String  u_phone;
	private String o_time;
	private String o_address;
	private String o_name;
	private String o_tel;
	private List<ShoppingCart> o_shop_info;
	private String o_status;
	private String o_coupon_id;
	private Double o_total;
	private String invoice;
	private String evaluate;
	


	public Orders(String o_id, String u_phone, String o_time, String o_address, String o_name, String o_tel,
			List<ShoppingCart> o_shop_info, String o_status, String o_coupon_id, Double o_total, String invoice,
			String evaluate) {
		super();
		this.o_id = o_id;
		this.u_phone = u_phone;
		this.o_time = o_time;
		this.o_address = o_address;
		this.o_name = o_name;
		this.o_tel = o_tel;
		this.o_shop_info = o_shop_info;
		this.o_status = o_status;
		this.o_coupon_id = o_coupon_id;
		this.o_total = o_total;
		this.invoice = invoice;
		this.evaluate = evaluate;
	}


	public String getEvaluate() {
		return evaluate;
	}


	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}


	public String getO_time() {
		return o_time;
	}


	public void setO_time(String o_time) {
		this.o_time = o_time;
	}


	public String getO_id() {
		return o_id;
	}


	public void setO_id(String o_id) {
		this.o_id = o_id;
	}


	public String getU_phone() {
		return u_phone;
	}


	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}


	public String getO_address() {
		return o_address;
	}


	public void setO_address(String o_address) {
		this.o_address = o_address;
	}


	public String getO_name() {
		return o_name;
	}


	public void setO_name(String o_name) {
		this.o_name = o_name;
	}


	public String getO_tel() {
		return o_tel;
	}


	public void setO_tel(String o_tel) {
		this.o_tel = o_tel;
	}


	public List<ShoppingCart> getO_shop_info() {
		return o_shop_info;
	}


	public void setO_shop_info(List<ShoppingCart> o_shop_info) {
		this.o_shop_info = o_shop_info;
	}


	public String getO_status() {
		return o_status;
	}


	public void setO_status(String o_status) {
		this.o_status = o_status;
	}


	public String getO_coupon_id() {
		return o_coupon_id;
	}


	public void setO_coupon_id(String o_coupon_id) {
		this.o_coupon_id = o_coupon_id;
	}


	public Double getO_total() {
		return o_total;
	}


	public void setO_total(Double o_total) {
		this.o_total = o_total;
	}


	public String getInvoice() {
		return invoice;
	}


	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}


	public Orders() {
		super();
	}
	
	
}
