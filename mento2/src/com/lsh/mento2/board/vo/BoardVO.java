package com.lsh.mento2.board.vo;

public class BoardVO {//VO : value object  == DTO  ,MVC패턴 중 model에 해당
	//캡슐화 , 은닉화 
	private int pk;
	private String id;
	private String pw;
	private String name;
	
	// private 접근하는법
	//값을 넣는방법은 -> 2가지  : 메서드(set), 생성자
	//값을 쓰는방법은 -> 1가지  : 메서드(get)
	
	
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
}
