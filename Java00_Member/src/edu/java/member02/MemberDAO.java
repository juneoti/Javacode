package edu.java.member02;

public interface MemberDAO {

	public abstract int insert(MemberVO vo);
	
	// 연락처 정보 전체 검색
	public abstract MemberVO[] select();
	
	// 연락처 정보 인덱스(상세) 검색
	public abstract MemberVO select(int index);
	
	// 연락처 정보 인덱스(상세) 수정
	public abstract int update(int index, MemberVO vo);

	public abstract int delete(int index, MemberVO vo);
}
