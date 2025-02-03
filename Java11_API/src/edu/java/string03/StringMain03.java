package edu.java.string03;

public class StringMain03 {

	public static void main(String[] args) {
		// length() : 문자열의 길이를 리턴
		String str1 = "abc";
		String str2 = "Hello";
		System.out.println(str1.length());
		System.out.println(str2.length());
		
		System.out.println("------------");
		// equals() : 문자열의 내용을 비교
		System.out.println(str1.equals(str2));
		
		System.out.println("------------");
		// equalsIgnoreCase() : 대소문자 구분없이 비교
		String str3 = "hello";
		String str4 = "Hello";
		System.out.println(str3.equals(str4));
		System.out.println(str3.equalsIgnoreCase(str4));
		
		System.out.println("------------");
		// charAt() : 문자열 중ㅇ서 해당 인덱스의 문자 하나를 리턴
		System.out.println(str3.charAt(1));
		
		System.out.println();
		// indexOf() : 해당 문자 또는 문자열이 처음으로 등장하는 인덱스를 리턴
		//				해당 문자 또는 문자열이 없으면 -1을 리턴
		// lastIndexOf() : 문자 또는 문자열이 가장 마지막으로 등장하는 인덱스를 리턴
		String str5 = "Hello, worlds!";
		System.out.println(str5.indexOf("l"));
		System.out.println(str5.indexOf("world"));
		System.out.println(str5.lastIndexOf("l"));
		
		System.out.println();
		// startsWith() : 해당 문자열로 시작하는지 아닌지 확인
		String str6 = "https://www.google.com";

		System.out.println(str6.startsWith("https://"));
	
		System.out.println();
		// contains() : 해당 문자열이 포함되는지 아닌지
		System.out.println(str6.contains("google"));
	
		System.out.println();
		// split() : 문자열을 특정 기준(구분자)으로 나눠서 배열로 리턴
		String str7 = "2024.10.16";
		String[] result = str7.split("\\.");
		// 특수기호(.$()[{^?*+\\) 사용시 기호 앞에 "\\"를 붙여서 사용
		for(String x : result) {
			System.out.println(x);
		}
		
		String str8 = "C:\\Program Files\\test folder";
		// 위 문자열을 연속된 문자열의 형태로 분할(공백 없이)
		// 예시) "C", "Program", "File", "test", "folder
		result = str8.split((":| |\\\\"));
		for(String x : result) {
			System.out.println(x);
		}
		
		String str9 = "2024-10-16 11:01:30";
		// 퀴즈) 위 문자열을 "2024", "10", "16", "11", "01", "30"로 나누도록 코드 작성
		// 1~6월이면 "상반기", 7~12월이면 "하반기"가 출력되도록 작성
		result = str9.split("-| |:");
		int month = Integer.parseInt(result[1]);
		System.out.println("월 : " + month);
		if(month >= 1 && month <= 6){
			System.out.println("상반기");
		}else {
			System.out.println("하반기");
		}
		
		System.out.println();
		// compareTo() : 문자열을 비교하여 서로 다른 문자의 개수 리턴
		// 두 문자열 사전 순으로 비교
		// - 0이면 같음
		// - 양수면 호출한 문자열이 비교되는 문자열보다 사전 순으로 뒤에 있음
		// - 음수면 호출한 문자열이 비교되는 문자열보다 사전 순으로 앞에 있음
		// compareToIgnoreCase() : 문자열을 대소문자 구분없이 비교하여 서로 다른 문자의 개수 리턴
		String str10 = "abc";
		String str11 = "bbc";
		System.out.println(str10.compareTo("abc"));
		System.out.println(str10.compareTo("ab"));
		System.out.println(str10.compareTo("a"));
		System.out.println(str10.compareTo("b"));
		System.out.println(str10.compareTo(str11));
		
		System.out.println();
		// toUpperCase() : 문자열을 대문자로 변경
		// toLowerCase() : 문자열을 소문자로 변경
		String str12 = "Hello, Java!";
		System.out.println(str12.toUpperCase());
		System.out.println(str12.toLowerCase());
		
		System.out.println();
		//substring(begin, end) : begin부터 end까지 문자열을 리턴
		// begin 인덱스는 포함, end 인덱스는 포함되지 않음
		System.out.println(str12.substring(0, 5)); // 0 <= index < 5
		int begin = str12.indexOf("J");
		int end = str12.length();
		System.out.println(str12.subSequence(begin, end));
	
		System.out.println();
		// concat() : 문자열을 이어주는 메소드
		System.out.println(str12.concat(" World!"));
		System.out.println(str12 + " World!");
		
		System.out.println();
		// replace(A, B) : A 문자열을 B로 변경
		String str13 =str12.replace("Java", "C++");
		System.out.println(str13);
		
	}	
	
}
