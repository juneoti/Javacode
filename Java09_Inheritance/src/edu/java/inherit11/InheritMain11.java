package edu.java.inherit11;

// final : 최종적인, 변경할 수 없는
// - final + 메소드 : override 할 수 없는 메소드
// - final + 클래스 : 상속을 허용하지 않는 클래스

class SuperClass {
	public void test() {
		System.out.println("테스트");
	}
	
	public final void testFinal() {
		System.out.println("파이널 메소드");
	}
} // end SuperClass

class SubClass extends SuperClass {
	@Override
	public void test() {
	}
	
//	testFinal(); // final로 선언된 메소드는 override 불가능
} // end SubClass

public class InheritMain11 {

	public static void main(String[] args) {
		
	} // end main()

} // end InheritMain11
