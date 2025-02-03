package edu.java.method02;

public class MethodMain02 {

		// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
		// 메소드 이름 : add
		// 리턴타입 : int
		// 매개변수 : int x, int y
	public static int add(int x, int y) {
		return x + y; // return result;
	} // end add()
	
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 차를 리턴
	public static int subtract(int x, int y) {
		return x - y;
	}
	// 기능 : 두 개의 실수를 매개변수로 전달받아서, 두 실수의 곱을 리턴
	public static double multiply(double x, double y) {
		return x * y;
	}
	// 기능 : 두 개의 실수를 매개변수로 전달받아서, x를 y로 나눈 값을 리턴
	public static double divide(double x, double y) {
		return x / y;
	}
	public static void main(String[] args) {
		System.out.println("메소드 연습");
		int result = add(10, 20);
		System.out.println("result = " + result);
		int sub = subtract(10, 20);
		System.out.println("result2 = " + sub);
		double mul = multiply(10, 20);
		System.out.println("result3 = " + mul);
		double div = divide(10, 20);
		System.out.println("result4 = " + div);
	}

}
