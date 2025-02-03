package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02 {
	
	private static Scanner sc;
	private static ContactDAO dao; 
	
	public static void main(String[] args) {
		// 시작 (프로그램의 이름)
		System.out.println("연락처 프로그램 version 0.2");
		sc = new Scanner(System.in);
		dao = ContactDAOImple.getInstance();
		boolean run = true;
		
		// While 반복문을 통한 메뉴 구성 (displayMainMenu 메소드를 불러와서 메인화면 구성)
		// select 입력값을 통해 스위치문을 사용하여 위의 메소드들을 불러오기 (0: 종료, 1: 등록, 2: 전체검색, 3: 상세검색, 4: 수정)
		// break를 사용해 불러온 메소드 사용 후 메인 메소드로 복귀(탈출)
		// default를 통해 select 값이 지정된 케이스(0~4)중에 없는 값일 경우 경고문 출력 및 메인 메소드로 복귀
		
		while (run) {
			displayMainMenu();
			int select = sc.nextInt();
			
			switch(select) {
			case Menu.QUIT:
				sc.close();
				System.out.println("프로그램을 종료합니다.");
				run = false;
			  	break;
			case Menu.INSERT:
				insertContact();
			  	break;
			case Menu.SELECT_ALL:
				selectContact();
			  	break;
			case Menu.SELECT_INDEX:
				selectIndexContact();
			  	break;
			case Menu.UPDATE:
				updateContact();
			  	break;
			case Menu.DELETE:
				deleteContact();
			  	break;
			  	
			default:
				System.out.println("메뉴에 있는 숫자를 선택해주세요.");
			
			}

		}

	}

	private static void displayMainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
		System.out.println("---------------------------------------------------------");
		System.out.println("선택>");
	}

	private static void insertContact() {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		// 이름 입력
		System.out.println("이름 입력>");
		String name = sc.next();
		// 전화번호 입력
		System.out.println("전화번호 입력>");
		String phone = sc.next();
		// 이메일 입력
		System.out.println("이메일 입력>");
		String email = sc.next();
		ContactVO vo = new ContactVO(name, phone, email);
		int result = dao.insert(vo);
		if(result == 1) {
			System.out.println("연락처 정보 등록 완료");
		}	
	}

	private static void selectContact() {
		ContactVO[] list = dao.select();
		for (int i = 0; i < ((ContactDAOImple) dao).getCount(); i++) {
			System.out.println("연락처 정보 [" + i + "]");
			System.out.println(list[i]);
			}
		}

	private static void selectIndexContact() {
		System.out.println("연락처 인덱스 입력 ");
		int index = sc.nextInt();
		/*
		if (index >= 0) {
			ContactVO vo = dao.select(index);
			if (vo == null) {
				System.out.println("연락처 정보가 없습니다");
			}else {
			System.out.println(vo);
		}
		*/
		if (index >= 0 && index < ((ContactDAOImple) dao).getCount()) {
			ContactVO vo = dao.select(index);
			System.out.println(vo);
		}else {
			System.out.println("연락처 정보가 없습니다");		
		}
		
	}

	private static void updateContact() {
		System.out.println("연락처 정보 수정");
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();
		if (index >= 0 && index < ((ContactDAOImple) dao).getCount()) {
		sc.nextLine();
		System.out.println("전화번호 입력>");
		String phone = sc.nextLine();
		System.out.println("이메일 입력>");
		String email = sc.nextLine();
		
		/*
		ContactVO vo = dao.select(index);
		
		if (vo == null){
			System.out.println("연락처 정보가 없습니다");
		}
		else {
		System.out.println("전화번호 입력>");
		String phone = sc.nextLine();
		System.out.println("이메일 입력>");
		String email = sc.nextLine();
		
		vo = new ContactVO("", phone, email);
		*/
		ContactVO vo = dao.select(index);
		vo = new ContactVO("", phone, email);
		int result = dao.update(index, vo);
		if(result == 1) {
			System.out.println("연락처 정보 수정 완료");
			}
		}else {
			System.out.println("연락처 정보가 없습니다");
		}
		}
	
	// 삭제 메소드
	private static void deleteContact() {
		boolean delete = true;
		// while 반복문을 활용해 삭제 기능 구성
		while(delete) {
		// 등록된 연락처가 없을때 출력 및 반복문 탈출	
		if(((ContactDAOImple) dao).getCount() == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			delete = false;
		}
		// 등록된 연락처가 있을경우 삭제하고 싶은 연락처의 인덱스를 입력하면 경고문 출력
		else {
		System.out.println("---------------");
		System.out.println("삭제할 인덱스 입력>");
		int index = sc.nextInt();
		ContactVO vo = dao.select(index);
			if(index < ((ContactDAOImple) dao).getCount()) {
				System.out.println(vo);
				System.out.println("해당 연락처의 삭제를 원한다면 yes를, 취소하려면 no를 입력하세요.");
				String yesNo = sc.next();
				// 삭제 희망(yes) 입력시 삭제, 취소(no) 입력시 반복문 탈출
				if(yesNo.equals("yes")) {
					System.out.println("삭제가 완료되었습니다.");
					for (int i = index; i < ((ContactDAOImple) dao).getCount(); i++) {
						dao.delete(index, vo);
					}
					delete = false;
				}
				else if(yesNo.equals("no")){
					System.out.println("삭제를 취소합니다.");
					delete = false;
				}
			}
			// 입력한 인덱스값이 등록된 연락처의 인덱스 값을 넘을 경우 출력
			else {
				System.out.println("마지막 인덱스 숫자보다 작은 숫자를 입력해주세요.");
			}
		}
		}
	}
	
}
