package edu.java.for05;

public class ForMain05 {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		// 1 + 2 + 3 + ... + 10 계산
		int sum1 = 0;
		
		for(int x = 1; x <= 10; x++) {
			sum1 += x;
		}
		System.out.println(sum1);
		
		// 1 ~ 100까지의 숫자 중 짝수들의 합을 출력
		
		int sum2 = 0;
		for(int x = 1; x <= 100; x++) {
			if(x % 2 == 0) {
				sum2 += x;
			}
		}
		System.out.println(sum2);
	}

}
