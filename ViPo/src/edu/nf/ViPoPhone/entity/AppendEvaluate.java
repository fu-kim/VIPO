package edu.nf.ViPoPhone.entity;

public class AppendEvaluate {
	private String a_id;
	private String e_id;
	private String a_text;
	private String a_image1;
	private String a_image2;
	private String a_image3;
	private String a_date;
	
	public AppendEvaluate(String a_id, String e_id, String a_text, String a_image1, String a_image2, String a_image3,
			String a_date) {
		super();
		this.a_id = a_id;
		this.e_id = e_id;
		this.a_text = a_text;
		this.a_image1 = a_image1;
		this.a_image2 = a_image2;
		this.a_image3 = a_image3;
		this.a_date = a_date;
	}

	public AppendEvaluate() {
		super();
	}

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

	public String getA_text() {
		return a_text;
	}

	public void setA_text(String a_text) {
		this.a_text = a_text;
	}

	public String getA_image1() {
		return a_image1;
	}

	public void setA_image1(String a_image1) {
		this.a_image1 = a_image1;
	}

	public String getA_image2() {
		return a_image2;
	}

	public void setA_image2(String a_image2) {
		this.a_image2 = a_image2;
	}

	public String getA_image3() {
		return a_image3;
	}

	public void setA_image3(String a_image3) {
		this.a_image3 = a_image3;
	}

	public String getA_date() {
		return a_date;
	}

	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	
	
}
