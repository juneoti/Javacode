package edu.java.if04;
import java.util.Scanner;

public class IfMain04 {

	public static void main(String[] args) {
		System.out.println("if - else if - else 연습");
		
		// 퀴즈) Scanner를 사용하여 score 변수에 점수 저장(정수)
		// score가 90점 이상일 경우 "A" 출력
		// score가 80점 이상일 경우 "B" 출력
		// score가 70점 이상일 경우 "C" 출력
		// score가 70점 미만일 경우 "F" 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("score를 입력하면 등급을 알려드립니다. 입력해주세요");
		int score = sc.nextInt();
		
		if (score >= 90) {
			System.out.println("A");
		}
		else if (score>= 80) {
			System.out.println("B");
		}
		else if (score>= 70) {
			System.out.println("C");
	}
		else if (score < 70) {
			System.out.println("F");
		}
	sc.close();
	}
}
