package edu.java.inherit02;

public class InheritMain02 {

	public static void main(String[] args) {
		// Person 클래스의 인스턴스 생성
		Person p1 = new Person();
		// 인스턴스를 생성하면, 생성자가 호출된다.
		
		Person p2 = new Person("솔데스크");
		
		System.out.println("===========");
		BusinessPerson p3 = new BusinessPerson();
		
		System.out.println("===========");
		BusinessPerson p4 = new BusinessPerson("구글");

	}

}
