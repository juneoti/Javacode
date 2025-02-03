package edu.java.inherit02;

public class BusinessPerson extends Person {
	// 멤버 변수
	private String company;

	public BusinessPerson() {
		super(); // 부모 클래스의 기본생성자 호출 -> 생략 가능
		// super() == Person()
		System.out.println("BusinessPerson() 생성자");
	}

	public BusinessPerson(String name) {
		super(name);
		System.out.println("BusinessPerson(name) 생성자");
		
	}
	
	// * 생성자
	// - 자식 클래스의 생성자를 호출하면, 부모 클래스의 생성자를 먼저 호출한다.
	// - 부모 클래스의 생성자를 명시적으로 호출할 때는 super(); 사용
	// - 부모 클래스의 생성자를 명시적으로 호출하지 않으면,
	//   부모 클래스의 "기본 생성자"가 자동으로 호출됨
	// - 부모 클래스의 매개변수가 있느 생성자는 자동으로 호출되지 않기 때문에,
	//   필요한 경우 반드시 명시적으로 호출해야 한다.
	// - 예시) super(name)

}
