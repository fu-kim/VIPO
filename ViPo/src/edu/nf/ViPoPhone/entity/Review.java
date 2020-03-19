package edu.nf.ViPoPhone.entity;

public class Review {
	private Integer r_id;
	private String  u_phone;
	private String r_text;
	private String r_date;
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getR_text() {
		return r_text;
	}
	public void setR_text(String r_text) {
		this.r_text = r_text;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public Review(Integer r_id, String u_phone, String r_text, String r_date) {
		super();
		this.r_id = r_id;
		this.u_phone = u_phone;
		this.r_text = r_text;
		this.r_date = r_date;
	}
	public Review() {
		super();
	}
	
	
}
