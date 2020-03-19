package edu.nf.ViPoPhone.entity;

public class Users {
	private Integer u_id;
	private String u_name;
	private String u_phone;
	private String u_password;
	private String u_mailbox;
	private String u_birthday;
	private String u_sex;
	private String u_head;
	private Integer u_integral;
	
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	public String getU_mailbox() {
		return u_mailbox;
	}
	public void setU_mailbox(String u_mailbox) {
		this.u_mailbox = u_mailbox;
	}
	public String getU_birthday() {
		return u_birthday;
	}
	public void setU_birthday(String u_birthday) {
		this.u_birthday = u_birthday;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_head() {
		return u_head;
	}
	public void setU_head(String u_head) {
		this.u_head = u_head;
	}
	public Integer getU_integral() {
		return u_integral;
	}
	public void setU_integral(Integer u_integral) {
		this.u_integral = u_integral;
	}
	
	public Users(Integer u_id, String u_name, String u_phone, String u_password, String u_mailbox, String u_birthday,
			String u_sex, String u_head, Integer u_integral) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_phone = u_phone;
		this.u_password = u_password;
		this.u_mailbox = u_mailbox;
		this.u_birthday = u_birthday;
		this.u_sex = u_sex;
		this.u_head = u_head;
		this.u_integral = u_integral;
	}
	
	public Users() {
		super();
	}
	
	
}
