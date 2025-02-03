package project_hotel;

import java.util.ArrayList;

public interface RoomDAO {
	
	// 룸 테이블 데이터를 배열로 저장
	public abstract ArrayList<RoomVO> loadRooms();
	
	// 룸 컨디션 업데이트(예약됨 <> 가능)
	public void updateRoomAvailability(int roomId, String availability);
	
	// 룸 정보에 리뷰도 불러올 수 있게 리뷰 테이블 데이터를 배열로 저장
	public ArrayList<ReviewVO> loadReviewsByRoomId(int roomId);
	}
