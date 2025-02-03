
package edu.java.inner05;

class OuterClass {
	private int value;
	
	public OuterClass(int value) {
		this.value = value;
	}
	
	public void test() {
		int x = 123; // 지역 변수(local variable)
		
		// 지역 변수를 선언하는 위치에서 정의하는 클래스 : 지역 클래스
		class LocalClass{
			private int value2; // 지역 클래스의 멤버 변수
		
		
		// 지역 클래스의 생성자
			public LocalClass(int value2) {
				this.value2 = value2;
			}
			
			// 지역 클래스의 메소드
			public void display() {
				System.out.println("value = " + value);
				System.out.println("x = " + x);
				System.out.println("value 2 = " + value);
			} // end display()
			
		} // end LocalClass
		
		// 지역 클래스의 인스턴스 생성 - 메소드 안에서만 가능
		LocalClass local = new LocalClass(1234);
		local.display();
	}
}
public class InnerMain05 {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass(200);
		outer.test();

	}

}
