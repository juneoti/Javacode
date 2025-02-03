package edu.java.variable07;

public class TypeCastingMain {

	public static void main(String[] args) {
		System.out.println("형 변환(Type Casting)");
		byte num1 = 123;
		int num2 = num1;
		System.out.println("num2 = " + num2);
		
		int num3 = 123;
		byte num4 = (byte) num3; // byte < int 이므로 자동 형 변환 불가 manual 로 변환
		System.out.println("num4 = " + num4);
		
		int num5 = Byte.MAX_VALUE +1;
		System.out.println("num5 = " + num5);
		byte num6 = (byte) num5;
		System.out.println("num6 = " + num6);
		// 주의) num5에 저장된 값이 byte의 범위를 넘어가면
		// 형 변환은 가능하지만, 잘못된 값(쓰레기 값)이 저장됨
		
		short num7 = 12345;
		// 12345는 리터럴(상수)이기 때문에 int 타입
		// 정수 리터럴 byte나 short에 저장할 때 해당 타입을 저장할 수 있는 범위만 넘지 않으면
		// 자동 형 변환 해줌
		// int -> byte, int -> short
		
		// long 타입 리터럴은 자동 형 변환을 하지 않음
		int num8 = (int) 100L;
		System.out.println(num7);
		System.out.println(num8);
		
		double num9 = 100; // int -> double 자동 형 변환
		System.out.println("num9 = " + num9);
		
		// 실수 타입 리터럴을 int로 변환
		int num10 = (int) 3.14; // double -> int 강제 형 변환
		System.out.println("num10 = " + num10);
		
		char ch1 = 'A';
		System.out.println("ch1 = " + ch1); // 문자 자체 출력
		System.out.println("ch1 = " + (int) ch1); //문자의 유니코드값 출력
		
		// 퀴즈) ch1을 사용하여 'B'라는 문자를 출력하세요.
		// 힌트 - char 형 변환 예시 > (char) 65;
		char ch2 = (char)(ch1 + 1);
		System.out.println("ch2 = " + ch2 );
		
		System.out.println((char) 66);
		System.out.println((char)(ch1+1));
	}

}
