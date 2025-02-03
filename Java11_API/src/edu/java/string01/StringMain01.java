package edu.java.string01;

// API(Application Programming Interface)
// - 프로그램 언어나 운영체제가 제공하는 기능을 사용할 수 있게 만든 인터페이스
public class StringMain01 {

	public static void main(String[] args) {
		
		String str1 = "안녕하세요";
		System.out.println(str1); // 문자열 리터럴
		
		String str2 = new String("안녕하세요"); // 문자열 인스턴스
		System.out.println(str2);
		
		if(str1 == str2) {
			System.out.println("같은 참조");
		}else {
			System.out.println("다른 참조");
		}
		
		// 비교연사자(==, !=)는 단순 주소값만 비교
		// -> 실제 문자열의 내용이 같더라도 '주소값이 다르다'라는 결과를 줄 수 있음
		// 따라서, 문자열의 내용을 비교할 때는 equals() 메소드를 사용
	
		if(str1.equals(str2)) {
			System.out.println("같은 내용");
		}else {
			System.out.println("다른 내용");
		}
	
	}

}
