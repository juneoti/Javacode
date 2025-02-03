package edu.java.class03;

public class Scores {
	int korean;
	int english;
	int math;
	
	// 기본 생성자
	public Scores() {
		
	}
	
	// 매개변수 생성자
	public Scores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	// 세 과목의 총합을 구하는 메소드
	public int calcTotal() {
		return korean + english + math;
	}
	
	// 세 과목의 평균을 구하는 메소드
	public double calcAverage() {
		return (double) calcTotal() / 3;
	}
	
	// 세 과목의 각 점수를 출력하는 메소드
	public void printScores() {
		System.out.println("국어 : " + korean);
		System.out.println("영어 : " + english);
		System.out.println("수학 : " + math);
	}
}
