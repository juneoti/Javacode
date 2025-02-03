package edu.java.method04;

import java.util.Scanner;

public class MethodMain04 {

	public static void main(String[] args) {
		System.out.println("배열을 매개변수로 갖는 메소드");
		
		// 변수 선언 -> 공간 생성 -> 주소값 존재
		int[]scores = new int[5];
		System.out.println("주소값 : " + scores);
		
		inputScores(scores);
		printScores(scores);
		//scores의 주소값이 같으면 모두 같은 위치에 존재하는 변수
	}
	
	// 배열에 각 점수를 입력하는 기능
	private static void inputScores(int[] scores) {
		System.out.println("input scores 주소값 : " + scores);
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < scores.length; i++) {
			System.out.println("점수 : " + i + "번째 입력>");
			scores[i] = sc.nextInt();
		}
		sc.close();
	}
	
	private static void printScores(int[] scores) {
		System.out.println("print scores 주소값 : " + scores);
		for(int x : scores) {
			System.out.println("입력한 점수 : " + x);
		}
	}

}
