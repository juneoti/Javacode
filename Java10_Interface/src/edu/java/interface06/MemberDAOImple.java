package edu.java.interface06;

// DAO(Data Access Object) :
// - 데이터의 전송을 담당하는 역할

public class MemberDAOImple implements MemberDAO {
	
	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static MemberDAOImple instance = null;
	
	// 2. private 생성자
	private MemberDAOImple() {}
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	private final int MAX = 100; // 최대 회원수
	private MemberVO[] list = new MemberVO[MAX]; // 회원 정보를 저장할 배열
	private int count; // 배열에 저장될 데이터 개수
	@Override
	public int insert(MemberVO vo) {
		list[count] = vo;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public MemberVO[] select() {
		return list;
	}

	@Override
	public MemberVO select(int index) {
		return list[index];
	}

	@Override
	public int update(int index, MemberVO vo) {
		// 비밀번호, 이메일만 변경
		list[index].setPw(vo.getPw());
		list[index].setEmail(vo.getEmail());
		return 0;
	}

}
