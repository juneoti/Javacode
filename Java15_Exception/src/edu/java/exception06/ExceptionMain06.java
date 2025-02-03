package edu.java.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) {
		// 하나의 try 구문에서 여러 개의 catch를 사용하는 방법2 : Java 7 버전부터
		// try {
		// 		정상 상황일 때 사용할 코드;
		// } catch ( Ex1 | Ex2 | Ex3 | ... e) {
		// 		예외 상황일 때 실행할 코드
		// } catch (Exception e) { ... }
		try {
			System.out.println("try 시작");
			int result = 123 / 0;
			int[] array = new int[10];
			array[10] = 10;
			System.out.println("try 끝");
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 : " + e.toString());
		} catch (Exception e) {
			System.out.println("예외 : " + e.toString());
		}
		
	} // end main()

} // end ExcetionMain06









