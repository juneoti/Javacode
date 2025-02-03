package edu.java.variable06;

public class LiteralMain {

	public static void main(String[] args) {
		System.out.println("리터럴(Literal) 상수");
		int integer1 = 1234;  // 정수 리터럴은 기본적으로 int
		long integer2 = 12345678900L; // long 타입 리터럴 뒤에 l 또는 L을 추가
		
		double decimal1 = 3.1415; // 실수 리터럴은 기본적으로 double
		float decimal2 = 3.14f; // float 타입 리터럴 뒤에 f 또는 F를 추가
		
		char ch1 = 'A'; // 문자 리터럴은 기본적으로 char
		String str1 = "문자열"; // 문자열 리터럴은 기본적으로 String
		
		System.out.println(integer1);
		System.out.println(integer2);
		System.out.println(decimal1);
		System.out.println(decimal2);
		System.out.println(ch1);
		System.out.println(str1);
	}

}
