package edu.java.inherit08;

public class EmployeeUtil {
	
	// Employee e 매개변수에 들어가는 인스턴스는
	// Employee 객체일 수 있고, Manager 객체일 수도 있음
	// 따라서, 두 가지 타입의 인스턴스를 처리하기 위해
	// 조건문과 instanceof를 이용하여 코드를 작성해야 한다.

	public static void printEmpinfo(Employee e) {
		if(e instanceof Manager) {
			Manager m = (Manager) e; // 강제 형 변환(casting)
			System.out.println("이름 : " + m.getName());
			System.out.println("직책 : " + m.getType());
		} else if(e instanceof Employee) {
			System.out.println("이름 : " + e.getName());
		} else {
			System.out.println("직원이 아닙니다.");
		}
	}

}
