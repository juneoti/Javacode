package edu.java.inner06;
class Person{
	// 멤버 변수
	private String name;
	
	// 생성자
	public Person(String name) {
		this.name = name;
	}
	
	// 메소드
	// 리턴 타입 : PersonInterface
	public PersonInterface setAge(int age) {
		// 지역 클래스 정의
		class PersonWithAge implements PersonInterface{
			// 지역 클래스 멤버 변수
			private int age;
			
			// 지역 클래스 생성자
			public PersonWithAge(int age) {
				this.age = age;
			}

			// 메소드 구현
			@Override
			public void showInfo() {
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
			}

			@Override
			public void hello() {
				System.out.println("안녕");
			}
		}
		// 지역 클래스 객체를 모두 저장
		PersonWithAge instance = new PersonWithAge(age);
		
		// 지역 클래스 내용을 리턴
		return instance;
	}
}

interface PersonInterface{
	public abstract void showInfo();
	
	public abstract void hello();
	
}
public class InnerMain06 {

	public static void main(String[] args) {
		Person p = new Person("Jarvis");
		PersonInterface instance = p.setAge(20);
		instance.showInfo();
		instance.hello();

	}

}
