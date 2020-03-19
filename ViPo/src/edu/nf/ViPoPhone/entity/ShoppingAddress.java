package edu.nf.ViPoPhone.entity;

public class ShoppingAddress {
	private String s_id;
	private String u_phone;
	private String s_name;
	private String s_phone;
	private String s_adress;
	private String s_status;
	

	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_adress() {
		return s_adress;
	}
	public void setS_adress(String s_adress) {
		this.s_adress = s_adress;
	}
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	
	
	
	public ShoppingAddress(String s_id, String u_phone, String s_name, String s_phone, String s_adress,
			String s_status) {
		super();
		this.s_id = s_id;
		this.u_phone = u_phone;
		this.s_name = s_name;
		this.s_phone = s_phone;
		this.s_adress = s_adress;
		this.s_status = s_status;
	}
	public ShoppingAddress() {
		super();
	}
	
	
}
