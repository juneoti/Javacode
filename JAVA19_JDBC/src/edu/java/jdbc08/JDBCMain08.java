package edu.java.jdbc08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.OracleDriver;

public class JDBCMain08 {
   // 1. DB에 사용할 상수들
   public static final String URL = 
         "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
   public static final String USER = "scott";
   public static final String PASSWORD = "tiger";
   
   public static final String TABLE_NAME = "EX_CONTACT";
   public static final String COL_CONTACT_ID = "CONTACT_ID";
   public static final String COL_NAME = "NAME";
   public static final String COL_PHONE = "PHONE";
   public static final String COL_EMAIL = "EMAIL";
   public static final String SQL_SELECT = 
         "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_CONTACT_ID;
   
   
   public static void main(String[] args) {
      System.out.println("JDBC 8 - select all");
      
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
         // SELECT * FROM EX_CONTACT ORDER BY CONTACT_ID;
         
         // 5. Connection 객체를 사용하여 Statement 객체를 생성
         pstmt = conn.prepareStatement(SQL_SELECT);
         
                  
         // 6. SQL 문장 실행(DB 서버로 SQL 전송)
         rs = pstmt.executeQuery();
   
         // 7. DB 서버가 보낸 결과 확인/처리
         // ResultSet.next() : 
         // ResultSet에서 다음 행(row, record)이 있으면
         // true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경
         
         // ArrayList<ContactVO>
         ArrayList<ContactVO> list = new ArrayList<>();
         while(rs.next()) { // 레코드가 존재할 때까지
            int contactId = rs.getInt(1); // CONTACT_ID 컬럼
            String name = rs.getString(2); // NAME 컬럼
            String phone = rs.getString(3); // PHONE 컬럼
            String email = rs.getString(4);   // EMAIL 컬럼
            
            ContactVO vo = new ContactVO(contactId, name, phone, email);
            list.add(vo);
         }
         
         for(ContactVO vo : list) {
            System.out.println(vo);
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

   } // end main()
}
