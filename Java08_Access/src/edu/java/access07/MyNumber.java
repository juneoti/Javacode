package edu.java.access07;

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
	
	// 기능 : 현재 객체(this : MyNumber)의 number 변수와
	//		 매개변수 number를 더한 후, 현재의 객체에 number 저장
	// 리턴타입 : MyNumber
	// 함수 이름 : add
	// 매개변수 : MyNumber number
	public MyNumber add(MyNumber number) {
		this.number = this.number + number.number;
		return this;
	}
}
