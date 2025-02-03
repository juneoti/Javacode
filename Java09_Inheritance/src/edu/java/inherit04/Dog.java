package edu.java.inherit04;

public class Dog extends Animal {
	
	// 메소드 재정의(override)
	// - 부모 클래스가 가지고 있는 메소드를 자식 클래스에서 재정의(다시 정의)
	// - 메소드의 리턴 타입, 이름, 매개변수 모두 부모 클래스의 메소드와 일치해야 함
	@Override
	public void speak() {
		System.out.println("멍멍");
	}
}
