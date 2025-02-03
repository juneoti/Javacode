package edu.java.array01;

// 배열
// - 같은 타입의 변수들을 하나의 목록으로 저장할 때 사용
// - 배열의 선언과 초기화
// 		배열타입[] 배열이름 = new 배열타입[배열길이];
//		배열이름[인덱스] = 값;
//	or
//		배열타입[] 배열이름 = {값1, 값2, ...}
// - 배열의 인덱스는 0 ~ (배열 길이 -1)

public class ArrayMain01 {

	public static void main(String[] args) {
		System.out.println("배열(array)");
		int score1 = 100;
		int score2 = 90;
		int score3 = 80;
		int score4 = 70;
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);
		System.out.println(score4);
		
		System.out.println("==========");
		int[] scores = new int[4];
		scores[0] = 100;
		scores[1] = 90;
		scores[2] = 80;
		scores[3] = 70;
		for(int i = 0; i < 4; i++) {
			System.out.println(scores[i]);
		}
		

	}

}
