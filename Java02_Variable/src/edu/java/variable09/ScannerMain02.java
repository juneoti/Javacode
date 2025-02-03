package edu.java.variable09;

import java.util.Scanner;

public class ScannerMain02 {

	public static void main(String[] args) {
		System.out.println("문자 하나 입력");
		
		Scanner sc = new Scanner(System.in);
		
		char ch1 = sc.next().charAt(0); // 문자 하나 입력 후 저장
		System.out.println("ch1 = " + ch1);
		
		char ch2 = sc.next().charAt(0);
		
		System.out.println("ch2 = " + ch2);
		System.out.println(ch1 + " " + ch2);
		System.out.println(ch1 + ch2);
		
		Float a = sc.nextFloat();
		System.out.println(String.format("%.2f",a));
		
		sc.close();
	}

}
