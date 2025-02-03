package edu.java.while02;

import java.util.Scanner;

public class WhileMain02 {

	public static void main(String[] args) {
		System.out.println("while문 구구단 연습");
		
		int d = 2;
		while (d <= 9) {
			System.out.println(d + "단");
			int i = 1;
			while(i <= 9) {
				System.out.println(d + " x " + i + " = " + d * i);
				i++;
			}
			d++;
		}
	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i >= j) {
				System.out.print("*");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}


