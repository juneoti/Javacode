package edu.java.if07;
import java.util.Scanner;
public class IfMain07 {

	public static void main(String[] args) {
		System.out.println("입력된 세 개의 정수 중 최대값 구하기");
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a>=b) {
			if(a>=c) {
				System.out.println("최대값은 = " + a);
			}
			else if(a<=c) {
				System.out.println("최대값은 = " + c);
			}
		}
		else if(b>=a) {
			if(b>=c) {
				System.out.println("최대값은 = " + b);
			}
			else if(b<=c) {
				System.out.println("최대값은 = " + c);
			}
		}
		sc.close();
	} //end main()

} //end IfMain07
