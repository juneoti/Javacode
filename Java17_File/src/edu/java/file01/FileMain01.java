package edu.java.file01;

import java.util.Scanner;

// 프로그램 <=== InputStream <=== 입력장치(키보드, 마우스, 파일, ...)
// 프로그램 ===> OutputStream ===> 출력장치(모니터, 프린터, 파일, ...)
public class FileMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// in : InputStream 클래스의 인스턴스
		// 외부 입력장치(키보드, 마우스)로부터 데이터를 읽어올 수 있는 통로
		
		System.out.println("테스트");
		// out : PrintStream 클래스의 인스턴스
		// PrintStream은 OutputStream 클래스의 하위 클래스
		// 콘솔화면으로 데이터를 출력하는 통로
		
	} // end main()

} // end FileMain01





