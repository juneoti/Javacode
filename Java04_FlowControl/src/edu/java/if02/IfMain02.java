package edu.java.if02;
import java.util.Scanner;

public class IfMain02 {

	public static void main(String[] args) {
		System.out.println("if-else 문");
		// if(조건) { 본문A }
		// else { 본문B }
		// - 조건이 참이면 본문A가 실행되고 거짓이면 본문B가 실행
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if (x > 0) { // 만약 x가 0보다 크면 "양수" 출력
			System.out.println("양수");
		}
		else { // 그게 아니면 (x <= 0) "0보다 크지 않음" 출력
			System.out.println("0보다 크지 않음");
		}
		
		sc.close();
		
	}

}
