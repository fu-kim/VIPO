package edu.nf.ViPoPhone.entity;

public class ShoppingCart {
	private Integer shop_id;
	private String u_phone;
	private String shop_pic;
	private String shop_name;
	private Double shop_price;
	private Integer shop_amount;
	private String shop_gift;
	private String shop_gift_pic;
	private Double shop_total;
	private String payorno;
	private Integer shop_checked;
	private String order_id;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getShop_checked() {
		return shop_checked;
	}
	public void setShop_checked(Integer shop_checked) {
		this.shop_checked = shop_checked;
	}
	public String getPayorno() {
		return payorno;
	}
	public void setPayorno(String payorno) {
		this.payorno = payorno;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getShop_pic() {
		return shop_pic;
	}
	public void setShop_pic(String shop_pic) {
		this.shop_pic = shop_pic;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public Integer getShop_amount() {
		return shop_amount;
	}
	public void setShop_amount(Integer shop_amount) {
		this.shop_amount = shop_amount;
	}
	public String getShop_gift() {
		return shop_gift;
	}
	public void setShop_gift(String shop_gift) {
		this.shop_gift = shop_gift;
	}
	public String getShop_gift_pic() {
		return shop_gift_pic;
	}
	public void setShop_gift_pic(String shop_gift_pic) {
		this.shop_gift_pic = shop_gift_pic;
	}
	public Double getShop_total() {
		return shop_total;
	}
	public void setShop_total(Double shop_total) {
		this.shop_total = shop_total;
	}
	public ShoppingCart(Integer shop_id, String u_phone, String shop_pic, String shop_name, Double shop_price,
			Integer shop_amount, String shop_gift, String shop_gift_pic, Double shop_total) {
		super();
		this.shop_id = shop_id;
		this.u_phone = u_phone;
		this.shop_pic = shop_pic;
		this.shop_name = shop_name;
		this.shop_price = shop_price;
		this.shop_amount = shop_amount;
		this.shop_gift = shop_gift;
		this.shop_gift_pic = shop_gift_pic;
		this.shop_total = shop_total;
	}
	public ShoppingCart() {
		super();
	}
	
	
}
