package edu.java.exception08;

import java.util.Scanner;

public class ExceptionMain08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 메뉴로 숫자를 입력하면 종료하고,
		// 숫자가 아니면 "숫자가 아닙니다."를 출력하고
		// 메뉴 선택을 다시 하도록 구현
		// * try-catch문을 이용
		while(true) {
			try {
				System.out.println("메뉴 선택");
				int choice = Integer.parseInt(sc.next());
				System.out.println("choice : " + choice);
				break;
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다.");
				System.out.println(e.toString());
			}
		}
		
		sc.close();
		
	} // end main()

} // end ExceptionMain08
