package project_hotel;

public class ReviewVO {
    private int reviewId; 
    private int reviewRating;
    private String reviewDetail;
    private String customerId;
    private int roomId;
    
	public ReviewVO() {
	}
	
	public ReviewVO(int reviewId, int reviewRating, String reviewDetail, String customerId, int roomId) {
		super();
		this.reviewId = reviewId;
		this.reviewRating = reviewRating;
		this.reviewDetail = reviewDetail;
		this.customerId = customerId;
		this.roomId = roomId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	public String getReviewDetail() {
		return reviewDetail;
	}
	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
    
}
