package room_test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImple implements RoomDAO, RoomQuery {

    @Override
    public void insertRoom(RoomVO room) {
        String query = "INSERT INTO ROOMS (ROOM_ID, ROOM_TYPE, ROOM_PRICE, ROOM_AVAILABILITY) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, room.getRoomId());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getRoomPrice());
            pstmt.setBoolean(4, room.isRoomAvailability());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RoomVO selectRoom(int roomId) {
        String query = "SELECT * FROM ROOMS WHERE ROOM_ID = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new RoomVO(rs.getInt("ROOM_ID"), rs.getString("ROOM_TYPE"),
                                  rs.getDouble("ROOM_PRICE"), rs.getBoolean("ROOM_AVAILABILITY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RoomVO> selectAllRooms() {
        List<RoomVO> rooms = new ArrayList<>();
        String query = "SELECT * FROM ROOMS";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new RoomVO(rs.getInt("ROOM_ID"), rs.getString("ROOM_TYPE"),
                                     rs.getDouble("ROOM_PRICE"), rs.getBoolean("ROOM_AVAILABILITY")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public void updateRoom(RoomVO room) {
        String query = "UPDATE ROOMS SET ROOM_TYPE = ?, ROOM_PRICE = ?, ROOM_AVAILABILITY = ? WHERE ROOM_ID = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, room.getRoomType());
            pstmt.setDouble(2, room.getRoomPrice());
            pstmt.setBoolean(3, room.isRoomAvailability());
            pstmt.setInt(4, room.getRoomId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        String query = "DELETE FROM ROOMS WHERE ROOM_ID = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, roomId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAvailability(int roomId, boolean availability) {
        String query = "UPDATE ROOMS SET ROOM_AVAILABILITY = ? WHERE ROOM_ID = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, availability);
            pstmt.setInt(2, roomId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
