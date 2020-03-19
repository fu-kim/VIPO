package edu.nf.ViPoPhone.entity;

public class Evaluate {
	private String e_id;
	private String u_phone;
	private String e_text;
	private String e_image1;
	private String e_image2;
	private String e_image3;
	private String e_rating;
	private String e_date;
	private String a_id;
	
	
	public String getA_id() {
		return a_id;
	}


	public void setA_id(String a_id) {
		this.a_id = a_id;
	}


	public String getE_id() {
		return e_id;
	}


	public void setE_id(String e_id) {
		this.e_id = e_id;
	}


	public String getU_phone() {
		return u_phone;
	}


	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}


	public String getE_text() {
		return e_text;
	}


	public void setE_text(String e_text) {
		this.e_text = e_text;
	}


	public String getE_image1() {
		return e_image1;
	}


	public void setE_image1(String e_image1) {
		this.e_image1 = e_image1;
	}


	public String getE_image2() {
		return e_image2;
	}


	public void setE_image2(String e_image2) {
		this.e_image2 = e_image2;
	}


	public String getE_image3() {
		return e_image3;
	}


	public void setE_image3(String e_image3) {
		this.e_image3 = e_image3;
	}


	public String getE_rating() {
		return e_rating;
	}


	public void setE_rating(String e_rating) {
		this.e_rating = e_rating;
	}


	public String getE_date() {
		return e_date;
	}


	public void setE_date(String e_date) {
		this.e_date = e_date;
	}


	public Evaluate(String e_id, String u_phone, String e_text, String e_image1, String e_image2, String e_image3,
			String e_rating, String e_date) {
		super();
		this.e_id = e_id;
		this.u_phone = u_phone;
		this.e_text = e_text;
		this.e_image1 = e_image1;
		this.e_image2 = e_image2;
		this.e_image3 = e_image3;
		this.e_rating = e_rating;
		this.e_date = e_date;
	}


	public Evaluate() {
		super();
	}
	
	
}
