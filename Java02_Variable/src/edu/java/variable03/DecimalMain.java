package edu.java.variable03;

public class DecimalMain {

	public static void main(String[] args) {
		System.out.println("실수(Decimal) 자료형");
		
		// double 타입은 float 타입보다 크고
		// 더 정밀한(소수점 이하 자릿수가 더 큼) 수를 표현할 수 있음
		float y = 3.14f;
		System.out.println("y = " + y);
		
		y = Float.MAX_VALUE;
		System.out.println("y = " + y);
		
		double x = 3.14;
		System.out.println("x = " + x);
		
		x = Double.MAX_VALUE;
		System.out.println("x = " + x);
		
	} // end main()

} //end DecimalMain
