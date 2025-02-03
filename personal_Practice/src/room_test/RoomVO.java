package room_test;

public class RoomVO {
    private int roomId;
    private String roomType;
    private double roomPrice;
    private boolean roomAvailability;

    public RoomVO(int roomId, String roomType, double roomPrice, boolean roomAvailability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomAvailability = roomAvailability;
    }

    // Getter and Setter methods
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(boolean roomAvailability) {
        this.roomAvailability = roomAvailability;
    }
}

