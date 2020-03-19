package edu.nf.ViPoPhone.entity;

public class Question {
	private Integer q_id;
	private String q_title;
	private String q_text;
	public Integer getQ_id() {
		return q_id;
	}
	public void setQ_id(Integer q_id) {
		this.q_id = q_id;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_text() {
		return q_text;
	}
	public void setQ_text(String q_text) {
		this.q_text = q_text;
	}
	public Question(Integer q_id, String q_title, String q_text) {
		super();
		this.q_id = q_id;
		this.q_title = q_title;
		this.q_text = q_text;
	}
	public Question() {
		super();
	}
	
	
}
