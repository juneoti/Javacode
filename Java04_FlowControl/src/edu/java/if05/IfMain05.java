package edu.java.if05;
import java.util.Scanner;

public class IfMain05 {

	public static void main(String[] args) {
		System.out.println("if-else if 문자 조건 연습");
		//퀴즈) 문자 하나를 입력받아서 그 글자가
		// 1) A ~ Z이면, "영대문자" 출력
		// 2) a ~ z이면, "영소문자" 출력
		// 3) 그 외 경우, "몰라요" 출력
		Scanner sc = new Scanner(System.in);
		String alph = sc.next();
		char ch = alph.charAt(0);
		
		// 풀이
		if ('A' <= ch && ch <= 'Z') {
			System.out.println("영대문자");
		}
		else if ('a' <= ch && ch <= 'z'){
			System.out.println("영소문자");
		}
		else {
			System.out.println("몰라요");
		}
		
		// 내 풀이
		if (alph.matches(".*[A-Z].*")) {
			System.out.println("영대문자");
		}
		else if (alph.matches(".*[a-z].*")) {
			System.out.println("영소문자");		
		}
		else {
			System.out.println("몰라요");
		}
		sc.close();
	}

}
