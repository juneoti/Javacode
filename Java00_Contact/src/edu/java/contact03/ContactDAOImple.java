package edu.java.contact03;

import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO{
	
	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 생성자
	private ContactDAOImple() {}
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if(instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}
	// ArrayList Collection 코드
	public ArrayList<ContactVO> list = new ArrayList<>();
	
	public int getSize() {
		return list.size();
	}
	
	@Override
	public int insert(ContactVO vo) {
		list.add(vo);
		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		return 1;
	}
	public int delete(int index) {
		list.remove(index);
		return 1;
	}
	
	/* list 배열 코드
	private final int MAX = 100; // 최대 연락처수
	private ContactVO[] list = new ContactVO[MAX]; // 연락처 정보를 저장할 배열
	private int count; // 배열에 저장될 데이터 개수

	@Override
	public int insert(ContactVO vo) {
		list[count] = vo;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	public int getCount() {
		return count;
	}
	
	@Override
	public ContactVO[] select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list[index];
	}

	@Override
	public int update(int index, ContactVO vo) {
		// 전화번호, 이메일만 변경
		list[index].setPhone(vo.getPhone());
		list[index].setEmail(vo.getEmail());
		return 1;
	}
	
	@Override
	public int delete(int index, ContactVO vo) {
		list[index] = list[index+1];
		count--;
		return 1;
	}
	*/
}
