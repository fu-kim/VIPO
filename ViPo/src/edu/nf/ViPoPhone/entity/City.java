package edu.nf.ViPoPhone.entity;

public class City {
	private String s_province;
	private String s_city;
	private String s_city_a;
	private String s_adress;
	private String s_time;
	private String s_phone;
	public String getS_province() {
		return s_province;
	}
	public void setS_province(String s_province) {
		this.s_province = s_province;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_city_a() {
		return s_city_a;
	}
	public void setS_city_a(String s_city_a) {
		this.s_city_a = s_city_a;
	}
	public String getS_adress() {
		return s_adress;
	}
	public void setS_adress(String s_adress) {
		this.s_adress = s_adress;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public City(String s_province, String s_city, String s_city_a, String s_adress, String s_time, String s_phone) {
		super();
		this.s_province = s_province;
		this.s_city = s_city;
		this.s_city_a = s_city_a;
		this.s_adress = s_adress;
		this.s_time = s_time;
		this.s_phone = s_phone;
	}
	public City() {
		super();
	}
	
	
}
