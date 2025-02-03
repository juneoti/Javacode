package edu.java.exception01;

// 컴파일 에러 : 소스코드 빌드 시 발생하는 에러
// -> 실행 파일이 만들어지지 않기 때문에 실행할 수 없음
// 예외(Exception) : 
// -> 소스코드를 빌드할 때는 에러가 없지만,
//	  프로그램을 수행할 때 발생하는 오류
// 논리적 오류 :
// -> 컴파일 에러도 없고, 실행할 때 예외도 발생하지 않지만
//	  논리적인 문제 때문에 원하는 실행 결과가 나오지 않는 경우
public class ExceptionMain01 {

	public static void main(String[] args) {
//		int 123; // 컴파일 에러
		
//		int n = 123 / 0; // 예외
		
		int result = findMax(20, 1);
		System.out.println(result); // 논리적 오류
		
	} // end main()
	
	public static int findMax(int x, int y) {
		if(x < y) {
			return x;
		} else {
			return y;
		}
	}

} // end ExceptionMain01









