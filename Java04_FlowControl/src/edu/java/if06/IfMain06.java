package edu.java.if06;
import java.util.Scanner;

public class IfMain06 {

	public static void main(String[] args) {
		System.out.println("if 중첩문 연습");
		
		// - 정수 하나를 입력받는다.
		// - 입력된 정수가 짝수인 경우 : "짝수" 출력
		//      ㄴ 이 경우에서 입력된 정수가 4의 배수인 경우 : 4의 배수 출력
		//		ㄴ 이 경우에서 입력된 정수가 4의 배수가 아닌 경우: 4의 배수가 아닌 짝수 출력
		// - 입력된 정수가 홀수인 경우 : "홀수" 출력
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num % 2 == 0) { // 짝수일 때
			System.out.println("짝수");
			if(num % 4 == 0) {
				System.out.println("4의 배수");
			} else {
				System.out.println("4의 배수가 아닌 짝수");
			}
		}
		else { // 홀수일 때
			System.out.println("홀수");
		
		}
		sc.close();
	} // end main()

} // end IfMain06
