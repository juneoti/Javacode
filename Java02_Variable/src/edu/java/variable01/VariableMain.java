package edu.java.variable01;

public class VariableMain {
	
	// 주석 : 컴파일러가 읽지 못하는 메모
	// 프로그램의 시작점 : main()메소드
	public static void main(String[] args) {
		//println() : 데이터를 console 창에 보여주는 함수
		System.out.println("변수(variable)");
		// Ctrl + Space bar : 자동완성 단축키
		System.out.println();
		//Ctrl + F11 : 자동실행 단축키
		
		int x = 10; // 변수 x에 10을 저장
		System.out.println("x = " + x);
		
		int y; // 변수 y 선언
		y = 20; // 변수 초기화 (값을 저장)
		System.out.println("y = " + y);
		
		x = 12; // 이미 선언된 변수의 값을 변경
		x = 12 + y;
		y = 10;
		System.out.println("x = "+ x);
		System.out.println("y = "+ y);
		
		
	} // end main()

} // end VariableMain
