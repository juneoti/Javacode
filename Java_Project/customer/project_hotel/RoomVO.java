package project_hotel;

public class RoomVO {
    private int roomId; 
    private String roomType;
    private double roomPrice;
    private String roomAvailability;

    public RoomVO(int roomId, String roomType, double roomPrice, String roomAvailability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomAvailability = roomAvailability;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

	public void setRoomAvailability(String roomAvailability) {
		this.roomAvailability = roomAvailability;
	}


}

