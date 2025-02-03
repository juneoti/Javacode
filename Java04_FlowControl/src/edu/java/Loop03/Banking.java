package edu.java.Loop03;

import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		System.out.println("JAVA 은행");
		
		Scanner sc = new Scanner(System.in);
		boolean run = true; // while문 종료를 위한 변수
		int balance = 0;// 예금 저장 변수
		
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------------------------");
			
			System.out.print("선택> ");
			int choice = sc.nextInt(); // 선택된 값을 저장할 변수
			/* 강사님 답안
			 * switch(choice) {
			 * case 1:
			 * 		System.out.println("예금액>");
			 * 		int money = sc.nextInt();
			 * 		balance += money;
			 * 		break;
			 * case 2:
			 * 		System.out.println("출금액>");
			 * 		int money = sc.nextInt();
			 * 		balance -= money;
			 * 		break;
			 * case 3:
			 * 		System.out.println("종료합니다.");
			 * 		run = false;
			 * 		break;
			 * case 4:
			 * 		break;
			 * default:
			 * 		System.out.println("올바른 메뉴를 선택하세요.");
			 * 		break;
			 *
			 * 
			*/
			if(choice == 1) {
				System.out.print("예금액> ");
				int deposit = sc.nextInt();
				
				if(deposit <= 0) {
					System.out.println("입금액은 0보다 크게 입력하세요");
					}
					else { 
						balance += deposit;
						System.out.println("입금이 완료되었습니다.");
					}
			}
			else if(choice == 2) {
				System.out.print("출금액> ");
				int withdraw = sc.nextInt();
				
				if(withdraw <= 0) {
					System.out.println("출금액은 0보다 크게 입력하세요");
					}
				else if(balance < withdraw){
					System.out.println("잔액이 부족합니다.");
					}
				else {
					balance -= withdraw;
					System.out.println("출금이 완료되었습니다.");
					}
				
			}
			else if(choice == 3) {
				System.out.println("잔고> ");
				System.out.println(balance);
			}else if(choice == 4) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}
		}
		sc.close();

	} // end main()

} //end Banking
