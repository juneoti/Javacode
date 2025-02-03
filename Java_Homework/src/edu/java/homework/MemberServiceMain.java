package edu.java.homework;

import java.util.Scanner;

public class MemberServiceMain {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String pw = sc.next();
		sc.close();
		
		boolean result = memberService.login(id, pw);
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("test");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}

}
