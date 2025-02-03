package edu.java.access07;

public class AccessMain07 {

	public static void main(String[] args) {
		MyNumber num1 = new MyNumber(5);
		System.out.println(num1); // num1 의 인스턴스 참조값(주소값) 출력
		System.out.println(num1.getNumber());
		
		MyNumber num2 = new MyNumber(10);
		System.out.println(num2.getNumber());
		
		MyNumber result = num1.add(num2);
		System.out.println(result);
		System.out.println(result.getNumber());
		
		System.out.println("=============");
		MyNumber x = new MyNumber(1);
		MyNumber y = new MyNumber(2);
		MyNumber z = new MyNumber(3);
		MyNumber end = new MyNumber(4);
		
		x.add(y).add(z).add(end);
		System.out.println(x.getNumber());
	}

}
