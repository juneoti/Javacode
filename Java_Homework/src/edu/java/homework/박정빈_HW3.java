package edu.java.homework;

public class 박정빈_HW3 {
	public static void main(String[] args) {
		// 과제 1 MyCirclaMain.java
		MyCircle circle1 = new MyCircle(); // MyCircle 클래스 인스턴스 생성
		
		// 기본 생성자를 호출하여 인스턴스 생성
		circle1.radius = 4.0;
		System.out.println("원의 반지름 : " + circle1.radius);
		System.out.println("원의 면적 : " + circle1.calcArea());
		System.out.println("=================");
		// 매개변수가 있는 생성자를 호출하여 인스턴스 생성
		MyCircle circle2 = new MyCircle(7.0);
		System.out.println("원의 반지름 : " + circle2.radius);
		System.out.println("원의 면적 : " + circle2.calcArea());
	}
}
