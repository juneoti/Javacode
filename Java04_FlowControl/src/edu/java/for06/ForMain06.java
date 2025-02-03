package edu.java.for06;

public class ForMain06 {

	public static void main(String[] args) {
		System.out.println("중첩 반복문");
		
		for(int y = 2; y <= 9; y++) {
			System.out.println(y + "단");
		for(int x = 1; x <=9; x++) {
			System.out.println(y + " x " + x + " = " + (y * x));
		}
		}
	}

}
