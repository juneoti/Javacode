package edu.java.method05;

// 메소드 overloading
// 1. 매개변수의 개수가 다르거나
// 2. 매개변수의 타입이 다른 경우
// 같은 이름으로 메소드 정의 가능
// (주의) 메소드의 리턴타입만 다른 경우는 메소드 overloading 불가능
public class MethodMain05 {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("문자열");
		System.out.println(1);
		System.out.println(1.0);
		System.out.println(true);
		
		sayHello();
		
		

	}
	public static void sayHello() {
		System.out.println("안녕하세요.");
	}
	
	public static void sayHello(String name) {
		System.out.println("안녕하세요.");
		System.out.println("제 이름은 " + name + "입니다.");
	}
}
