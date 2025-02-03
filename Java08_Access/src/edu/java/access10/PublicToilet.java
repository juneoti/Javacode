package edu.java.access10;

// 싱글톤 디자인 패턴(singleton design pattern)
// - 클래스의 인스턴스를 오직 하나만 생성할 수 있도록 작성하는 설계 기법
// 1. 클래스는 자신 타입의 private static 변수를 선언
// 2. 생성자는 private으로 선언
// 3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
// 처음 생성한 인스턴스는 변경이 불가능(주소값이 같음)


public class PublicToilet {
	private String location;
	
	// 1. 클래스는 자신 타입의 private static 변수를 선언
	private static PublicToilet instance = null;
	
	// 2. 생성자는 private으로 선언
	private PublicToilet() {}
	
	// 3. public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계
	public static PublicToilet getInstance() {
		if(instance == null) {
			instance = new PublicToilet();
		}
		return instance;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}
