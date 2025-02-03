package project_hotel;

public interface ReviewDAO {
	
	// 리뷰 등록
	public void addReview(ReviewVO reviewVO);
	
	// customerId값이 사라질 경우 리뷰도 삭제
	public void deleteReview(String customerId);
}
