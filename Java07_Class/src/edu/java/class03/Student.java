package edu.java.class03;

public class Student {
	// 멤버 변수(필드, 프로퍼티)
	int stuNo; // 학생 번호
	String name; // 학생 이름
	Scores scores; // 학생 점수
	
	// 매개 변수가 있는 생성자를 만들면
	// 기본 생성자는 생략해도 됨
	// * 하지만 그냥 만드는 게 편함
	
	public Student() {}
	
	public Student(int stuNo, String name, Scores scores) {
		this.stuNo = stuNo;
		this.name = name;
		this.scores = scores;
	}
	
	// 출력 메소드
	public void printStudentInfo() {
		System.out.println("--- 학생 정보 ---");
		System.out.println("번호 : " + stuNo);
		System.out.println("이름 : " + name);
		System.out.println("국어 점수 : " + scores.korean);
		System.out.println("영어 점수 : " + scores.english);
		System.out.println("수학 점수 : " + scores.math);
		System.out.println("총점 : " + scores.calcTotal());
		System.out.println("평균 : " + scores.calcAverage());
	}
}
