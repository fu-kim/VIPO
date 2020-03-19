package edu.nf.ViPoPhone.entity;

public class Pay {
	private String oid;
	private String name;
	private String price;
	private String message;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Pay(String oid, String name, String price, String message) {
		super();
		this.oid = oid;
		this.name = name;
		this.price = price;
		this.message = message;
	}
	public Pay() {
		super();
	}
	
	
}
