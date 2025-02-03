package project_hotel;

import java.util.ArrayList;

public interface CustomerDAO {

	// 손님 정보 등록
	public abstract int insert(CustomerVO vo);
	
	// 손님 정보 전체 검색을 위해 배열로 저장
	public abstract ArrayList<CustomerVO> select();
	
	// 손님 정보 인덱스(상세) 검색
	public abstract CustomerVO select(String customerId);
	
	// 손님 정보 인덱스(상세) 수정
	public abstract int update(String customerId, CustomerVO vo);
	
	// 손님 정보 삭제
	public abstract int delete(String customerId);
	
	// 손님 아이디 중복 체크
	public abstract boolean checkId(String customerId);
}