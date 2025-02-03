package edu.java.member06;

import java.util.Date;

// 데이터 클래스
public class MemberVO {
	// 멤버 변수(필드, 프로퍼티)
	private String id;
	private String pw;
	private String name;
	private String email;
	private String interest;
	private Date regDate;
	
	// 기본 생성자
	public MemberVO() {}
	
	// 매개변수 생성자
	public MemberVO(String id, String pw, 
			String name, String email, 
			String interest, Date regDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.interest = interest;
		this.regDate = regDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", interest=" + interest
				+ ", regDate=" + regDate + "]";
	}
	
	
}







