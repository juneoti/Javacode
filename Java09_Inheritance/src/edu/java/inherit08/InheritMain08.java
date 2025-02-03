package edu.java.inherit08;

public class InheritMain08 {

	public static void main(String[] args) {
		// Employee 클래스 타입의 배열 선언
		Employee[] emps = {
				new Employee("홍길동"), 
				new Manager("고길동")
		};
		
		for(Employee e : emps) {
			EmployeeUtil.printEmpinfo(e);
			System.out.println("------------");
		}
		
	} // end main()

} // end InheritMain08




