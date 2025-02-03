package edu.java.access05;

// 클래스의 접근 제한 수식어 : public, (package)
// 1. public class : 어디서든지 인스턴스 생성이 가능한 클래스
// 2 .(package) class : 같은 패키지에 속한 클래스에서만 인스턴스 생성이 가능
// 주의사항 :
// - public class의 이름은 반드시 java 파일의 이름과 같아야 함!
// - 하나의 java 파일에 여러개의 클래스를 정의하는 것은 가능하지만,
//   파일 내에 public class는 오직 하나만 있어야 함

public class AccessMain05 {

	public static void main(String[] args) {
		TestPublic test1 = new TestPublic();
		System.out.println(test1);
		
		TestPackage test2 = new TestPackage();
		System.out.println(test2);
	}

}
