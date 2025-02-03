package edu.java.homework;

public class MyCircle {

	double radius;
	
	public MyCircle() {} // 기본 생성자
	
	public MyCircle(double radius) { // 매개변수 생성자
		this.radius = radius;
	}
	
	public double calcArea() { // 원의 면적 계산
		return 3.14 * radius * radius;
	}
}