package edu.java.if03;
import java.util.Scanner;

public class IfMain03 {

	public static void main(String[] args) {
		System.out.println("if - else if - else문");
		/*
		 * if(조건1) { 본문A } else if(조건2) { 본문B } ... else { 본문C } 
		 * - 조건1이 참일 경우 본문A, 조건2가 참일 경우 본문B, 그 외의 경우 본문C 실행
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		// x가 0보다 크면 - 양수
		// x가 0이면 - 0
		// x가 0보다 작으면 - 음수
		
		if (x > 0) {
			System.out.println("양수");
		}
		else if (x == 0) {
			System.out.println("0");
		}
		else if (x < 0) {
			System.out.println("음수");
		}
		sc.close();
	}

}
