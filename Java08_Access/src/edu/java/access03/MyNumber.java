package edu.java.access03;

public class MyNumber {
	//멤버 변수
	private int number;
	
	// 생성자
	public MyNumber(int number) {
		this.number = number;
	}
	
	// private 멤버 변수를 간접적으로 읽어오는 메소드 - getter
	public int getNumber() {
		return number;
	}
	
	// private 멤버 변수를 간접적으로 변경하는 메소드 - setter
	public void setNumber(int number) {
		System.out.println("범인은 이놈이다!");
		this.number = number;
	}
}
