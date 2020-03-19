package edu.nf.ViPoPhone.entity;

public class Code {
	private String code;
	private Long startTime;
	private Long endTime;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Code(String code, Long startTime, Long endTime) {
		super();
		this.code = code;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Code() {
		super();
	}
	
	
}
