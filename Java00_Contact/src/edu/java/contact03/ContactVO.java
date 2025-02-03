package edu.java.contact03;

public class ContactVO {
	private String name; // 이름
	private String phone; // 전화번호
	private String email; // 이메일
	
	public ContactVO() {
	}
	
	public ContactVO(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "ContactVO [name= " + name + ", phone= " + phone + ", email= " + email + "]";
	}
	
	
}
