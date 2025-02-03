package project_hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class ReviewDAOImple implements ReviewDAO, ReviewQuery {
	   // 싱글톤 디자인 패턴 적용 시작
	   
	   // 1. private static 자기 자신 타입의 변수 선언
	   private static ReviewDAOImple instance = null;
	   
	   // 2. private 생성자
	   private ReviewDAOImple() {
	   }
	   
	   // 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	   public static ReviewDAOImple getInstance() {
	      if(instance == null) {
	         instance = new ReviewDAOImple();
	      }
	      return instance;
	   }
	   

	   public void addReview(ReviewVO revo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
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
	         pstmt = conn.prepareStatement(ADD_REVIEW);
	         
	         
	         pstmt.setInt(1, revo.getReviewRating());
	         pstmt.setString(2, revo.getReviewDetail());
	         pstmt.setString(3, revo.getCustomerId());
	         pstmt.setInt(4, revo.getRoomId());
	         pstmt.executeUpdate();

	         System.out.println("리뷰가 등록되었습니다.");
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            pstmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	   }
	      @Override
	      public void deleteReview(String customerId) {
				Connection conn = null;
				PreparedStatement pstmt = null;
		      // PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		      //                     Statement와 상속관계
		      
		      try {
		         // Oracle JDBC 드라이버를 메모리에 로드
		         DriverManager.registerDriver(new OracleDriver());
		         System.out.println("드라이버 로드 성공");
		         
		         // DB와 Connection(연결)을 맺음
		         conn = DriverManager.getConnection(URL, USER, PASSWORD);
		         System.out.println("DB 연결 성공");
	    	  // 데이터베이스에서 customerId에 해당하는 리뷰를 삭제하는 로직 추가
	          String delete = "DELETE FROM REVIEWS WHERE customer_id = ?";
	          conn = DriverManager.getConnection(URL, USER, PASSWORD);
	          pstmt = conn.prepareStatement(delete); {
	              
	              pstmt.setString(1, customerId);
	              pstmt.executeUpdate();

	          }
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	   }


}