package edu.java.while01;

// while 문
// - for문과 같은 반복문
// - 선언 형태
//		while(조건) {
//			(본문)
//		}
public class WhileMain01 {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		// 1 ~ 10 까지 출력
		int x = 1;
		while(x <= 10) {
			System.out.println(x + " ");
			x++;
		}
		System.out.println();
		
		//while문을 사용하여 10, 9, 8, ... 2, 1 출력
		x = 10;
		while (x >= 1) {
			System.out.println(x + " ");
			x--;
		}

	}

}
