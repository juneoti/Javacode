package edu.java.contact02;

public interface ContactDAO {

	// 연락처 정보 등록
	public abstract int insert(ContactVO vo);
	
	// 연락처 정보 전체 검색
	public abstract ContactVO[] select();
	
	// 연락처 정보 인덱스(상세) 검색
	public abstract ContactVO select(int index);
	
	// 연락처 정보 인덱스(상세) 수정
	public abstract int update(int index, ContactVO vo);

	public abstract int delete(int index, ContactVO vo);
}
