package edu.java.member03;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MemberMain03 implements Menu{
	public static Scanner sc = new Scanner(System.in);
	
	public static MemberDAO dao;
	
	public static void main(String[] args) {
		System.out.println("회원 정보 관리 version 0.3");
		dao = MemberDAOImple.getInstance();
		boolean run = true; // 반복문 종료용
		
		while(run) {
			showMainMenu();
			int choice = sc.nextInt(); // 값 선택 받음
			
			switch(choice) {
			case INSERT: // 등록
				insertMember();
				break;
			case SELECT_ALL: // 전체 검색
				selectAllMember();
				break;
			case SELECT_BY_INDEX: // 상세 검색
				selectMember();
				break;
			case UPDATE: // 수정
				updateMember();
				break;
			case DELETE:
				deleteMember();
				break;
			case QUIT: // 종료
				run = false;
				System.out.println("프로그램 종료되었습니다.");
				break;
			default:
				System.out.println("잘못된 번호 선택입니다.");
				break;
			}
		}

	} // end main()
	
	private static void showMainMenu() {
		System.out.println("---------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
		System.out.println("---------------------------------------------------------");
		System.out.println("선택>");		
	}
	
	private static void insertMember() {
		System.out.println("<<회원 등록 메뉴>>");
		System.out.println("아이디>");
		String id = sc.next();
		System.out.println("비밀번호>");
		String pw = sc.next();
		System.out.println("이름>");
		String name = sc.next();
		System.out.println("이메일>");
		String email = sc.next();
		System.out.println("취미>");
		String interest = sc.next();
		
		Date regDate = new Date();
		MemberVO vo = new MemberVO(id, pw, name, email, interest, regDate);
		
		
		int result = dao.insert(vo);
		
		int size = ((MemberDAOImple) dao).getListSize();
		if(result == 1) {
			System.out.println("회원 정보 개수 : " + size);
			System.out.println("회원 등록 완료!");
		}
		
	}
	
	private static void selectAllMember() {
		ArrayList<MemberVO> list = dao.select();
		int size = ((MemberDAOImple) dao).getListSize();
		for(int i = 0; i < size; i++) {
			System.out.println("-- 회원 정보 " + i + " --");
			System.out.println(list.get(i));
		}
	}
	
	private static void selectMember() {
		System.out.println("<<회원 검색>>");
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		int size = ((MemberDAOImple) dao).getListSize();
		
		if(index >= 0 && index < size) {
			MemberVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("해당 인덱스에 회원 정보가 없습니다.");
		}
	}
	
	private static void updateMember() {
		System.out.println("<<회원 수정>>");
		System.out.println("수정할 회원 정보 입력>");
		int index = sc.nextInt();
		
		int size = ((MemberDAOImple) dao).getListSize();
		
		if(index >= 0 && index < size) {
			System.out.println("비밀번호>");
			String pw = sc.next();
			System.out.println("이름>");
			String name = sc.next();
			System.out.println("이메일>");
			String email = sc.next();
			System.out.println("취미>");
			String interest = sc.next();
			
			MemberVO vo = new MemberVO("", pw, name, email, interest, null);
			int result = dao.update(index, vo);
			System.out.println("회원 정보 수정 완료");
			 
		} else {
			System.out.println("해당 인덱스에 회원 정보가 없습니다.");
		}
	}
	
	private static void deleteMember() {
		System.out.println("삭제할 인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((MemberDAOImple) dao).getListSize();
		if(index >= 0 && index < size) {
			int result = dao.delete(index);
			System.out.println("회원 정보 삭제 완료");
		} else {
			System.out.println("해당 인덱스에 회원 정보가 없습니다.");
		}
	}
	

} // end MemeberMain02








