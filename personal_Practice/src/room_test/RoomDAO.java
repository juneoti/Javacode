package room_test;

import java.util.List;

public interface RoomDAO {
    void insertRoom(RoomVO room);
    RoomVO selectRoom(int roomId);
    List<RoomVO> selectAllRooms();
    void updateRoom(RoomVO room);
    void deleteRoom(int roomId);
    void updateAvailability(int roomId, boolean availability);
}
