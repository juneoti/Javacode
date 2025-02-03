package edu.java.class03;

public class ClassMain03 {

	public static void main(String[] args) {
		// Score 클래스의 인스턴스 생성 : 변수명 scores1
		Scores scores1 = new Scores(50, 60, 70);
		
		// scores1의 모든 점수 출력
		scores1.printScores();
		System.out.println("평균 : " + scores1.calcAverage());
		
		Student stu1 = new Student(1, "진혁", scores1);
		stu1.printStudentInfo();
		
		// 진혁님의 평균만 출력
		System.out.println(stu1.scores.calcAverage());
		
		System.out.println("==============");
		
		Student stu2 = new Student(2, "둘리", new Scores(40, 50, 60));
		
		// 둘리의 총점
		System.out.println("총점 : " + stu2.scores.calcTotal());
	}

}
