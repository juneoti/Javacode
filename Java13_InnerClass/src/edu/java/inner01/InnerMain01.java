package edu.java.inner01;

//변수 선언 : 
//1. 멤버 변수(필드) : 클래스에서 선언된 변수
//- 클래스 내부 어느 곳에서나 사용할 수 있는 변수
//- 수식어(public, private, static, ...)를 사용할 수 있음
//2. 지역 변수 : 메소드 안에서 선언하는 변수
//- 지역 변수가 선언된 곳에서 변수가 속한 블록({})이 끝나는 곳까지 사용할 수 있는 변수
//- 접근 수식어(public, private, static, ...)를 사용할 수 없음
//- final은 사용 가능

//내부 클래스(Inner Class) : 다른 클래스 내부에서 정의된 클래스
//1. 멤버 내부 클래스(member inner class)
//- 멤버 변수를 선언하는 위치에서 정의하는 내부 클래스
//- 외부 클래스의 인스턴스가 생성되어야만 객체 생성이 가능함
//2. static 내부 클래스(static inner class), 중첩 클래스(nested class)
//- 멤버 변수를 선언하는 위치에서 static으로 정의한 내부 클래스
//- 외부 클래스의 인스턴스를 생성하지 않아도 객체 생성이 가능함
//- 외부 클래스와 상관이 없는 클래스라고 생각해도 됨
//3. 지역 내부 클래스(local inner class) : 메소드 안에서 정의하는 클래스
//4. 익명 클래스(Anonymous class) : 이름이 없는 내부 클래스
//-> 람다 표현식 사용 가능

public class InnerMain01 {

	public static void main(String[] args) {
		// 외부 클래스 OuterClass의 인스턴스를 생성
		OuterClass out1 = new OuterClass(100);
		out1.display();
		
		// 내부 클래스의 인스턴스 생성 :
		// (외부 클래스 이름).(내부 클래스 이름) 변수이름 =
		// 		(외부 클래스의 참조변수).new (내부 클래스 생성자)();
		OuterClass.InnerClass inner1 = (out1).new InnerClass(200);
		inner1.printValues();
		System.out.println();
		
		// 내부 클래스의 인스턴스를 통한 외부 클래스 멤버 변수 변경
		inner1.setOuterValue(300);
		inner1.printValues();
		out1.display();
		System.out.println();
				
		// out1 인스턴스를 통한 두번째 InnerClass 인스턴스 생성
		OuterClass.InnerClass inner2 = out1.new InnerClass(500);
		inner2.printValues();
	}

}
