package edu.java.oper02;

// 복합 대입 연산자
// - (변수) = (변수) + 1
// 오른쪽 변수의 값에 1을 더하고 왼쪽 변수에 저장 => 변수 += 1
// 코드의 길이를 단축시키기 위해 사용
public class OperatorMain02 {

	public static void main(String[] args) {
		System.out.println("복합 대입 연산자");
		//+=, -=, *=, /=, ...
		
		int age = 16;
		age = age + 1;
		System.out.println("age = " + age);
		
		age += 1;
		System.out.println("age = " + age);
		
		int x = 123;
		x -= 10; // x = x - 10;
		System.out.println("x = " + x);
		
	}

}
