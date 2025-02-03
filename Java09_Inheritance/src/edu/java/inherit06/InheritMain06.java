package edu.java.inherit06;

// 다형성(Polymorphism)
// 객체(인스턴스)를 여러 가지 타입으로 호출할 수 있는 것.
// - 생성된 인스턴스를 가리키는(참조하는) 참조 변수를 선언할 때
//	 생성된 인스턴스의 클래스 타입으로 변수를 선언할 수도 있고
//	 그 부모 타입으로 변수를 선언할 수도 있는 것
// - 다형성의 장점
//   1. 배열을 사용할 때 부모 타입으로만 선언해도 그 배열에는 부모/자식 타입 모두 저장 가능
//   2. 메소드를 정의할 때 메소드의 매개변수나 리턴타입으로 부모 클래스 타입만 사용해도 부모/자식 타입 모두 매개변수나 리턴값으로 사용할 수 있음.
public class InheritMain06 {

	public static void main(String[] args) {
		// Car 클래스의 인스턴스 생성
		Car car1 = new Car();
		
		//HybridCar 클래스의 인스턴스 생성
		HybridCar car2 = new HybridCar();
		
		Car car3 = new HybridCar(); // 다형성(polymorphism)
		
//		HybridCar car4 - new Car(); // 자식 클래스에 부모 클래스 객체 저장 불가 -> 에러
		
		// ChildClass 변수이름 = new ChildClass(); - 가능
		// ParentClass 변수이름 = new ChildClass(); - 가능
		// ChildClass 변수이름 = new ParentClass(); - 불가능
		
		Car[] cars = new Car[3];
		cars[0] = car1; // Car 객체
		cars[1] = car2; // HybridCar 객체
		cars[2] = car3; // HybridCar 객체
		
		for(Car c : cars) {
			c.display();
			System.out.println("-------------------");
		}

	}

}
