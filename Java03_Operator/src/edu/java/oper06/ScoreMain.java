package edu.java.oper06;

import java.util.Scanner;
public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수 입력");
		int kor = sc.nextInt();
		System.out.println("수학 점수 입력");
		int math = sc.nextInt();
		System.out.println("영어 점수 입력");
		int eng = sc.nextInt();
		
		System.out.printf("국어:%d 수학:%d 영어:%d\n", + kor, math, eng);
		System.out.println("총점:" + (kor + math + eng));
		System.out.printf("평균:%.3f\n",(double)(kor + math + eng) / 3.0);
		sc.close();
	}

}
