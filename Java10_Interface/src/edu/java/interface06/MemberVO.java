package edu.java.interface06;

// VO(Value Object) : MVC 디자인 패턴에서 Model 클래스. 데이터 정보
// or DTO(Data Transfer Object)
public class MemberVO {
	// 멤버 변수(필드, 프로퍼티)
	private String id; // 회원 아이디
	private String pw; // 회원 비밀번호
	private String email; // 회원 이메일
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String id, String pw, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
	
	
}
