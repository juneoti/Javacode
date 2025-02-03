package edu.java.array04;

public class ArrayMain04 {

	public static void main(String[] args) {
		System.out.println("배열 초기화 연습");
		
		int[] english = {100, 90, 80};
		System.out.println(english.length);
		
		// for문을 사용한 출력
		for (int i = 0; i < english.length; i++) {
			System.out.println(english[i]);
		}
		
		// for-each 구문 (향상된 for 구문)
		// for (타입 변수 이름 : 배열){...}
		// - 타입은 배열과 동일한 타입으로 선언
		// - 배열에 있는 모든 데이터를 접근할 때 사용
		
		for (int x : english) {
			System.out.println(x);
		}

	}

}
