package project_hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class RoomDAOImple implements RoomDAO, RoomQuery {
    @Override
    public ArrayList<RoomVO> loadRooms() {
        ArrayList<RoomVO> rooms = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ROOMS);
            while (resultSet.next()) {
                int roomId = resultSet.getInt("ROOM_ID");
                String roomType = resultSet.getString("ROOM_TYPE");
                double roomPrice = resultSet.getDouble("ROOM_PRICE");
                String roomAvailability = resultSet.getString("ROOM_AVAILABILITY");

                rooms.add(new RoomVO(roomId, roomType, roomPrice, roomAvailability));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
    @Override
    public void updateRoomAvailability(int roomId, String availability) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
        //                     Statement와 상속관계
        
        try {
           // Oracle JDBC 드라이버를 메모리에 로드
           DriverManager.registerDriver(new OracleDriver());
           System.out.println("드라이버 로드 성공");
           
           // DB와 Connection(연결)을 맺음
           conn = DriverManager.getConnection(URL, USER, PASSWORD);
           System.out.println("DB 연결 성공");
           
           // Connection 객체를 사용하여 PreparedStatement 객체를 생성
           stmt = conn.prepareStatement(UPDATE_ROOM);
            stmt.setString(1, availability);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ReviewVO> loadReviewsByRoomId(int roomId) {
    	 ArrayList<ReviewVO> reviews = new ArrayList<>();
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
        

         try {
             // Oracle JDBC 드라이버를 메모리에 로드
             DriverManager.registerDriver(new OracleDriver());
             System.out.println("드라이버 로드 성공");
             
             // DB와 Connection(연결)을 맺음
             conn = DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("DB 연결 성공");
             // SELECT 쿼리 작성
             String query = "SELECT * FROM REVIEWS WHERE ROOM_ID = ?"; // roomId에 해당하는 리뷰만 선택
             pstmt = conn.prepareStatement(query);
             pstmt.setInt(1, roomId);  // roomId 파라미터 설정

             // 쿼리 실행
             rs = pstmt.executeQuery();

             // 결과 처리
             while (rs.next()) {
                 int reviewId = rs.getInt("REVIEW_ID");
                 int reviewRating = rs.getInt("REVIEW_RATING");
                 String reviewDetail = rs.getString("REVIEW_DETAIL");
                 String customerId = rs.getString("CUSTOMER_ID");

                 // ReviewVO 객체 생성 후 리스트에 추가
                 reviews.add(new ReviewVO(reviewId, reviewRating, reviewDetail, customerId, roomId));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             // 리소스 정리
             try {
                 if (rs != null) rs.close();
                 if (pstmt != null) pstmt.close();
                 if (conn != null) conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

         return reviews;  // 리뷰 목록 반환
     }
    
}
