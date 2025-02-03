package edu.java.access01;

public class Test01 {
	// 멤버 변수
	private int n1; // 클래스 내부에서 사용
	int n2; // (package) 내부에서 사용
	protected int n3; // 같은 패키지 혹은 상속받은 클래스들에서 사용
	public int n4; // 어디서든지 사용
	
	// 메소드
	public void printField() {
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);
	}
}
