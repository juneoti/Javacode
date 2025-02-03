package reserve_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ReservationProgram {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // DB URL
    private static final String USER = "scott"; // DB 사용자 이름
    private static final String PASSWORD = "tiger"; // DB 비밀번호

    public void addReservation(int roomId, String customerId) {
        String getReserveIdSql = "SELECT RESERVE_ID_SEQ.NEXTVAL FROM DUAL"; // 시퀀스에서 다음 ID 가져오기
        String insertSql = "INSERT INTO RESERVATIONS (RESERVE_ID, CHECK_IN_DATE, CHECK_OUT_DATE, ROOM_ID, CUSTOMER_ID) VALUES (?, ?, ?, ?, ?)";

        // 예약 날짜를 설정 (예시로 현재 날짜와 2일 후 날짜 사용)
        Date checkInDate = Date.valueOf(java.time.LocalDate.now());
        Date checkOutDate = Date.valueOf(java.time.LocalDate.now().plusDays(2));

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement idStatement = connection.prepareStatement(getReserveIdSql);
             ResultSet rs = idStatement.executeQuery()) {

            int reserveId = 0;
            if (rs.next()) {
                reserveId = rs.getInt(1); // 시퀀스에서 다음 값을 가져옴
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                preparedStatement.setInt(1, reserveId);
                preparedStatement.setDate(2, checkInDate);
                preparedStatement.setDate(3, checkOutDate);
                preparedStatement.setInt(4, roomId);
                preparedStatement.setString(5, customerId);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("예약이 성공적으로 추가되었습니다. 예약 ID: " + reserveId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
