package edu.java.array09;
import java.util.Scanner;
import java.util.*;

public class ArrayMain09 {

	public static void main(String[] args) {
		System.out.println("학생 점수 관리 프로그램");
		
		// 변수 명명 규척
		// 1. 첫 번째 글자는 문자, '$', '_' 로 시작해야 하고, 숫자로 시작 할 수 없다(필수)
		// 2. 영어 대소문자 구분 (필수)
		// 3. 첫 문자는 영어 소문자로 시작, 다른 단어가 붙는 경우 붙는 단어의 시작을 대문자로 한다 (관례)
		// 4. 문자 수(길이)의 제한은 없다
		// 5. 자바 예약어는 사용할 수 없다
		
		// 자바 예약어:
		// boolean, byte, char, private, public, new, true, if 등등
		Scanner sc = new Scanner(System.in);
		int stuNo = sc.nextInt();
		System.out.println("입력된 학생 수 : " + stuNo);
		Integer[] stuScores = new Integer[stuNo];
		
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------");
			System.out.println("1. 점수입력 | 2. 점수리스트 | 3. 분석 | 4. 종료");
			System.out.println("------------------------------------------");
			
			System.out.print("선택> ");
			
			int selectNo = sc.nextInt();
			switch(selectNo) {
			case 1: // 각 학생의 점수 입력
				for(int i = 0; i < stuNo; i++) {
					System.out.println((i + 1) + "번 학생의 점수를 입력하세요>");
					stuScores[i] = sc.nextInt();
				}
				break;
			case 2: // 점수 리스트 출력
				Arrays.sort(stuScores);
				for(int i = 0; i < stuScores.length; i++) {
					System.out.println((i + 1) + "번 학생>" + stuScores[i]);
					
				}
				
				break;
			case 3: // 각 학생 점수 랭킹 출력
				Arrays.sort(stuScores, Collections.reverseOrder());
				for(int i = 0; i < stuScores.length; i++) {
					System.out.println((i + 1) + "등: " + stuScores[i]);
				}
				break;
			case 4:
				break;
			default:
				break;
			}
		}
		sc.close();
	}

}
