package project_hotel;

import java.util.ArrayList;
import java.util.List;

public interface ReserveDAO {
  
	// 예약 등록
	public void reserve(ReserveVO reserveVO);
    
	// 모든 예약 데이터를 배열로
    public abstract ArrayList<ReserveVO> select();
    
    // 예약 customerId로 검색 (전체)
    List<ReserveVO> selectAllByCustomerId(String customerId); 
    
    // 예약 customerId로 검색 (상세)
	public abstract ReserveVO select(String customerId);
	
	// 예약 삭제 (reserveId 베이스)
	public int cancel(int reserveId);
	
	// 예약 삭제 (customerId 베이스)
	public int delete(String customerId);

}