package edu.nf.ViPoPhone.entity;

public class Spare_Parts {
	private String p_name;
	private String p_spare_name;
	private String p_price;
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_spare_name() {
		return p_spare_name;
	}
	public void setP_spare_name(String p_spare_name) {
		this.p_spare_name = p_spare_name;
	}
	public String getP_price() {
		return p_price;
	}
	public void setP_price(String p_price) {
		this.p_price = p_price;
	}
	public Spare_Parts(String p_name, String p_spare_name, String p_price) {
		super();
		this.p_name = p_name;
		this.p_spare_name = p_spare_name;
		this.p_price = p_price;
	}
	public Spare_Parts() {
		super();
	}
	
	
}
