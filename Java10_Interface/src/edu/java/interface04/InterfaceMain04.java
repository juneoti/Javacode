package edu.java.interface04;

import java.util.Scanner;

public class InterfaceMain04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1. 입력 | 2. 검색 | 3. 종료");
			System.out.println("-------------------------");
			int choice = sc.nextInt();
			switch (choice) {
			case Menu.INSERT:
				System.out.println(Menu.STR_INSERT);
				break;
			case Menu.SELECT:
				System.out.println(Menu.STR_SELECT);
				break;
			case Menu.QUIT:
				System.out.println(Menu.STR_QUIT);
				run = false;
				break;
			default:
				break;
			}
			sc.close();
		}
		
	} // end main()

} // end InterfaceMain04
