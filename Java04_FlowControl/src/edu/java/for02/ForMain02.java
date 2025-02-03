package edu.java.for02;

public class ForMain02 {

	public static void main(String[] args) {
		// println() : 마지막 문자열에 줄바꿈(\n)이 포함된 출력 함수 
		// print() : 문자열을 한 줄로 나열하여 출력하는 함수
		
		// 0 2 4 6 8 10
		for(int x = 0; x <= 10; x+=2) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		for(int x = 0; x <= 5; x++) {
			System.out.print((x * 2 + " "));
		}
		System.out.println();
		
		for(int x = 0; x <= 10; x++) {
			if(x % 2 == 0) {
				System.out.print(x + " ");
			}
		}
	}

}
