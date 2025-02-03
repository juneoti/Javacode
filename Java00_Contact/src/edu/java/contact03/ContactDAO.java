package edu.java.contact03;

import java.util.ArrayList;

public interface ContactDAO {

	// 연락처 정보 등록
	public abstract int insert(ContactVO vo);
	
	// 연락처 정보 전체 검색
	public abstract ArrayList<ContactVO> select();
	
	// 연락처 정보 인덱스(상세) 검색
	public abstract ContactVO select(int index);
	
	// 연락처 정보 인덱스(상세) 수정
	public abstract int update(int index, ContactVO vo);
	
	// 연락처 정보 삭제
	public abstract int delete(int index);
}
