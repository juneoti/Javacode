package edu.java.inner07;

interface Hello{
	public abstract void hello();
}

class Person implements Hello{
	@Override
	public void hello() {
		System.out.println("Hi");
	}
}

class Dog implements Hello{
	@Override
	public void hello() {
		System.out.println("Bow Wow");
	}
}

public class InnerMain07 {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.hello();
		
		Hello p2 = new Person();
		p2.hello();
		
		Hello dog = new Dog();
		dog.hello();
		
		// 익명 클래스
		Hello cat = new Hello() {
			@Override
			public void hello() {
				System.out.println("Meow");
			}
		};
		cat.hello();
		
		// new Hello(){본체}
		// 본체 : Hello interface를 구현하는 클래스의 내용(객체)
		Hello father = new Hello() {
			
			@Override
			public void hello() {
				System.out.println("I'm your father");
			}
		};
		father.hello();

	}

}
