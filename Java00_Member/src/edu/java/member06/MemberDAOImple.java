package edu.java.member06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, OracleQuery{
   // 싱글톤 디자인 패턴 적용
   
   // 1. private static 자기 자신 타입의 멤버 변수
   private static MemberDAOImple instance = null;
   
   // 2. private 생성자
   private MemberDAOImple() {
      
   }
   
   // 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
   public static MemberDAOImple getInstance() {
      if(instance == null) {
         instance = new MemberDAOImple();
      }
      return instance;
   }
   
   @Override
   public int insert(MemberVO vo) {
      int result = 0;
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      // PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
      //                  Statement와 상속관계
      
      try {
         // 2. Oracle JDBC 드라이버를 메모리에 로드
         DriverManager.registerDriver(new OracleDriver());
         System.out.println("드라이버 로드 성공");
         
         // 3. DB와 Connection(연결)을 맺음
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("DB 연결 성공");
         
         // 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
         pstmt = conn.prepareStatement(SQL_INSERT);
         
         
         // 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
         pstmt.setString(1, vo.getId());
         pstmt.setString(2, vo.getPw());
         pstmt.setString(3, vo.getName());
         pstmt.setString(4, vo.getEmail());
         pstmt.setString(5, vo.getInterest());
         // SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
         // 예시) ?가 첫 번째이면 parameterIndex = 1
         
         // setInt() : DB의 Number 타입
         // setString() : DB의 varchar, varchar2 타입
         // setFloat() : DB의 Float 타입
         // setDate() : DB의 Date 타입
         
         // 6. SQL 문장 실행(DB 서버로 SQL 전송)
         result = pstmt.executeUpdate();
         
         // 7. DB 서버가 보낸 결과 확인/처리
         System.out.println(result + "행이 삽입됐습니다.");
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            pstmt.close();
            conn.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      return result;
   }

   @Override
   public ArrayList<MemberVO> select() {
      ArrayList<MemberVO> list = new ArrayList<>();
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         // 2. Oracle JDBC 드라이버를 메모리에 로드
         DriverManager.registerDriver(new OracleDriver());
         System.out.println("드라이버 로드 성공");
         
         // 3. DB와 Connection(연결)을 맺음
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("DB 연결 성공");

         // 4. SQL 문장 작성

         
         // 5. Connection 객체를 사용하여 Statement 객체를 생성
         pstmt = conn.prepareStatement(SQL_SELECT);
         
                  
         // 6. SQL 문장 실행(DB 서버로 SQL 전송)
         rs = pstmt.executeQuery();
   
         // 7. DB 서버가 보낸 결과 확인/처리
         // ResultSet.next() : 
         // ResultSet에서 다음 행(row, record)이 있으면
         // true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경
         
         while(rs.next()) { // 레코드가 존재할 때까지
            String id = rs.getString(COL_ID);
            String pw = rs.getString(COL_PW);
            String name = rs.getString(COL_NAME);
            String email = rs.getString(COL_EMAIL);
            String interest = rs.getString(COL_INTEREST);
            Date regDate = rs.getTimestamp(COL_REG_DATE);
            
            MemberVO vo = new MemberVO(id, pw, name, email, interest, regDate);
            list.add(vo);
         }


      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            pstmt.close();
            conn.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      return list;
   }

   @Override
   public MemberVO select(String id) {
      MemberVO vo = null;
      return vo;
   }

   @Override
   public int update(String id, MemberVO vo) {
      int result = 0;
      
      return result;
   }
   
   @Override
   public int delete(String id) {
      int result = 0;

      return result;
   }

}





