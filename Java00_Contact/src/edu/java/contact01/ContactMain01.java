package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	public static final int MENU_QUIT = 0; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SEARCH_ALL = 2; // 전체 검색
	public static final int MENU_SEARCH_DETAIL = 3; // 상세 검색
	public static final int MENU_EDIT = 4; // 수정
	public static final int MENU_DELETE = 5; // 삭제
	
	public static final int MAX = 100; // 연락처 최대 저장 개수
	
	// 연락처 저장 배열 (배열의 크기는 100)
	private static Contact[] contactList = new Contact[100];
	private static int count = 0;
	
	public static Scanner sc = new Scanner(System.in);
	
	//메인 메뉴 화면
	public static void displayMainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
		System.out.println("-------------------------------------------------------");
		System.out.println("선택>");
	}
	
	//등록 메소드
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
		// 배열에 입력된 이름, 전화번호, 이메일을 저장
		Contact list = new Contact(name, phone, email);
		contactList[count] = list;
		count++;
		// 등록된 연락처 개수 및 결과 출력
		System.out.println("등록된 연락처 개수 : " + count);
		System.out.println("연락처 등록 완료!");
		
		// 등록된 연락처가 배열의 최대치인 100을 넘어갈경우 출력
		if(count >= contactList.length) {
			System.out.println("더 이상 연락처를 저장할 수 없습니다.");
			return;
		}
	}
	
	// 전체 검색 메소드
	private static void searchContact() {
		// 등록된 연락처가 없을때 출력
		if(count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			System.out.println("연락처를 등록해주세요.");
		}
		// 등록된 연락처가 있을경우 등록된 모든 연락처를 출력
		else {
			System.out.println("연락처 개수 : " + count);
			for(int i = 0; i < count; i++) {
				System.out.println("--- 연락처" + i + " ---");
				System.out.println(contactList[i].toString());
			}
		}
	}

	// 상세 검색 메소드
	private static void detailContact() {
		// 등록된 연락처가 없을때 출력
		if(count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			System.out.println("연락처를 등록해주세요.");
		}
		// 등록된 연락처가 있을경우 검색하고 싶은 연락처의 인덱스를 입력하면 그 연락처를 출력
		else {
			System.out.println("---------------");
			System.out.println("검색할 인덱스 입력>");
			int index = sc.nextInt();
			if(index < count) {
				System.out.println(contactList[index].toString());
			}
			// 입력한 인덱스값이 등록된 연락처의 인덱스 값을 넘을 경우 출력
			else {
				System.out.println("마지막 인덱스 숫자보다 작은 숫자를 입력해주세요.");
			}
		}
	}
	
	
	// 수정 메소드
	private static void editContact() {
		// 등록된 연락처가 없을때 출력
		if(count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			System.out.println("연락처를 등록해주세요.");
		}
		// 등록된 연락처가 있을경우 수정하고 싶은 연락처의 인덱스를 입력하면 그 연락처를 출력 및 수정
		else {
			System.out.println("---------------");
			System.out.println("수정할 인덱스 입력>");
			int index = sc.nextInt();
			for(int i = index; i < contactList.length;) {
			if(index < count) {
				System.out.println(contactList[index].toString());
				System.out.println("이름 입력>");
				String name = sc.next();
				contactList[i].setName(name);
				System.out.println("전화번호 입력>");
				String phone = sc.next();
				contactList[i].setPhone(phone);
				System.out.println("이메일 입력>");
				String email = sc.next();
				contactList[i].setEmail(email);
				break;
				}
			// 입력한 인덱스값이 등록된 연락처의 인덱스 값을 넘을 경우 출력
			else {
				System.out.println("마지막 인덱스 숫자보다 작은 숫자를 입력해주세요.");
				break;
			}
			}	
		}
	}
	
	// 삭제 메소드
	private static void deleteContact() {
		boolean delete = true;
		// while 반복문을 활용해 삭제 기능 구성
		while(delete) {
		// 등록된 연락처가 없을때 출력 및 반복문 탈출	
		if(count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			delete = false;
		}
		// 등록된 연락처가 있을경우 삭제하고 싶은 연락처의 인덱스를 입력하면 경고문 출력
		else {
		System.out.println("---------------");
		System.out.println("삭제할 인덱스 입력>");
		int index = sc.nextInt();
			if(index < count) {
				System.out.println(contactList[index].toString());
				System.out.println("해당 연락처의 삭제를 원한다면 yes를, 취소하려면 no를 입력하세요.");
				String yesNo = sc.next();
				// 삭제 희망(yes) 입력시 삭제, 취소(no) 입력시 반복문 탈출
				if(yesNo.equals("yes")) {
					System.out.println("삭제가 완료되었습니다.");
					for (int i = index; i < count; i++) {
						contactList[i] = contactList[i+1];
					}
					count--;
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
	// 메인 메소드 (위의 메소드들을 불러올 수 있게 프로그램을 구성하는 메소드)
	public static void main(String[] args) {
		// 시작 (프로그램의 이름)
		System.out.println("연락처 프로그램 version 0.1");
		boolean run = true;
		
		// While 반복문을 통한 메뉴 구성 (displayMainMenu 메소드를 불러와서 메인화면 구성)
		// select 입력값을 통해 스위치문을 사용하여 위의 메소드들을 불러오기 (0: 종료, 1: 등록, 2: 전체검색, 3: 상세검색, 4: 수정)
		// break를 사용해 불러온 메소드 사용 후 메인 메소드로 복귀(탈출)
		// default를 통해 select 값이 지정된 케이스(0~4)중에 없는 값일 경우 경고문 출력 및 메인 메소드로 복귀
		
		while (run) {
			displayMainMenu();
			int select = sc.nextInt();
			
			switch(select) {
			case MENU_QUIT:
				sc.close();
				System.out.println("프로그램을 종료합니다.");
				run = false;
			  	break;
			case MENU_INSERT:
				insertContact();
			  	break;
			case MENU_SEARCH_ALL:
				searchContact();
			  	break;
			case MENU_SEARCH_DETAIL:
				detailContact();
			  	break;
			case MENU_EDIT:
				editContact();
			  	break;
			  	
			case MENU_DELETE:
				deleteContact();
			  	break;
			default:
				System.out.println("0에서 4 사이의 숫자를 선택해주세요.");
			
			}

		}
	}

}
