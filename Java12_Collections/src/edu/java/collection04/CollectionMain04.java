package edu.java.collection04;

import java.util.*;

public class CollectionMain04 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<>();
		String name ;
		int math;
		int eng;
		
		// 1. 학생 정보(이름, 점수) 3개를 console에서 입력받아 list에 저장
		for(int i = 0; i < 3; i++) {
			System.out.println("이름 입력>");
			name = sc.next();
			System.out.println("수학 점수 입력>");
			math = sc.nextInt();
			System.out.println("영어 점수 입력>");
			eng = sc.nextInt();
			
			Score score = new Score(math, eng);
			Student student = new Student(name, score);
			
			list.add(student);
		}
		// 2. 전체 학생 정보 검색(출력)
		for(Student x : list) {
			System.out.println(x);
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("---학생[" + i + "] 정보 ---");
			Student student = list.get(i);
			System.out.println("이름 : " + student.getName());
			System.out.println("수학 : " + student.getScore().getMath());
			System.out.println("영어 : " + student.getScore().getEng());
		}
		
		System.out.println();
		
		// 3. 특정 학생 데이터 수정
		list.set(1, new Student("둘리",new Score(100, 50)));
		for(Student x : list) {
			System.out.println(x);
		}
		
		System.out.println();
		
		// - 1번 인덱스의 학생 정보를 변경
		// 예시) 이름 : 둘리
		//	    수학 : 100
		//		영어 : 50
		
		// - 0번 인덱스 학생의 영어 점수만 변경
		System.out.println("0번 학생 영어 점수 정보 수정");
		System.out.println("영어 점수 입력>");
		eng = sc.nextInt();
		list.get(0).getScore().setEng(eng);
		
		System.out.println();
		
		// 4. 변경된 전체 학생 정보 검색
		System.out.println("수정 후 학생 정보");
		for(Student x : list) {
			System.out.println(x);
		}
		
		System.out.println();
		
		// 5. 데이터 삭제 : 1번 인덱스 학생의 모든 정보 삭제
		System.out.println("1번 학생 정보 삭제");
		list.remove(1);
		
		for(Student x : list) {
			System.out.println(x);
		}
		sc.close();
	}

}
