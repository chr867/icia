package com.sihyeon.demo.bean;

public class Member {
	private String id; //필드명==파라미터명
	private String pw;
	
	@Override
	public String toString() {
		return "id:"+this.id+", pw:"+this.pw;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
