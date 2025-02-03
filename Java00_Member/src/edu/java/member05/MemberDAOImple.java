package edu.java.member05;

import java.util.ArrayList;

public class MemberDAOImple implements MemberDAO{
	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 멤버 변수
	private static MemberDAOImple instance = null;
	
	// 2. private 생성자
	private MemberDAOImple() {
		
	}
	
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	private ArrayList<MemberVO> list = new ArrayList<>(); // 연락처 정보를 저장할 배열
	
	public int getListSize() {
		return list.size();
	}

	@Override
	public int insert(MemberVO vo) {
		list.add(vo);

		return 1;
	}

	@Override
	public ArrayList<MemberVO> select() {
		return list;
	}

	@Override
	public MemberVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, MemberVO vo) {
		list.get(index).setPw(vo.getPw());
		list.get(index).setName(vo.getName());
		list.get(index).setEmail(vo.getEmail());
		list.get(index).setInterest(vo.getInterest());
		return 1;
	}
	
	@Override
	public int delete(int index) {
		list.remove(index);

		return 1;
	}

}





