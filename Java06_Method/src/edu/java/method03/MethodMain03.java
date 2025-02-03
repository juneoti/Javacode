package edu.java.method03;
import java.util.Scanner;
public class MethodMain03 {

	public static void main(String[] args) {
		// 1. 국어, 영어, 수학 점수를 입력받아서 3개의 변수에 저장
		Scanner sc = new Scanner(System.in);
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		// 2. 입력 받은 정수를 출력
		System.out.println("국어 점수 = " + kor);
		System.out.println("영어 점수 = " + eng);
		System.out.println("수학 점수 = " + math);
		int total = calcTotal(kor, eng, math);
		System.out.println("총점 = " + total);
		double avg = calcAverage(total, 3);
		System.out.println("평균 = " + avg);
		char grade = selectGrade(avg);
		System.out.println("당신의 평균 등급은 = " + grade + " 입니다");
		sc.close();
		// 3. 메소드를 정의하여 세 과목의 총점을 출력
		
		// 4. 메소드를 정의하여 세 과목의 평균을 출력 (소수점까지)
		
		// 5. 메소드를 정의하여 평균에 따른 등급을 출력
	}

	// 기능 : 총점을 리턴하는 메소드
	// 메소드 이름 : calcTotal
	
	// 기능 : 평균을 리턴하는 메소드
	// 메소드 이름 : calcAverage
	
	// 기능 : 등급을 리턴하는 메소드
	// 메소드 이름 : selectGrade
	// 				100 ~ 90 -> 'A'
	//				89 ~ 80 -> 'B'
	//				79 ~ 70 -> 'C'
	//				69 미만 -> 'F'
	
	public static int calcTotal(int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	public static double calcAverage(double total, double count) {
		return total / count;
	}
	
	public static char selectGrade(double avg) {
		if(100 >= avg && avg >= 90) { 
			return 'A';
		}
		if(avg >= 80) {
			return 'B';
		}
		if(avg >= 70) {
			return 'C';
		}else {
			return 'F';
		}
	}
	
}

