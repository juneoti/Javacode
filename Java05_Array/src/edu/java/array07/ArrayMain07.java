package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		// 문자열(String)은 문자(char)의 배열이다
		
		String str = "내일은 쉬는날!";
		System.out.println(str.length());
		
		// 내 일 은  쉬 는 날 ! 출력
		System.out.println(str.charAt(0));
		
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i)+ " ");
			if(str.charAt(i) == '!') {
				break;
			}
		}
		System.out.println();
	
		// 문자열 배열 선언
		//"국" "어"
		//"영" "어"
		//"수" "학"
		
		String[] subjects = {"국어", "영어", "수학", "프로그래밍"};
		
		for (int i = 0; i < subjects.length; i++) {
			System.out.println("과목명 : " + subjects[i]);
			System.out.println("문자열 길이 : " + subjects[i].length());
		}
		int count = 0;
		for (int i = 0; i < subjects.length; i++) {
			for(int j = 0; j < subjects[i].length();j++) {
				if(subjects[i].charAt(j) == '어') {
					count++;
				}
		}
		System.out.println("글자 수 : " + count);
			
		for (String x : subjects) {
			if(x.equals("프로그래밍")) {
				System.out.println(x + ", 쉽다~!");
			}
		}
		}

		
		
	
	}

}
