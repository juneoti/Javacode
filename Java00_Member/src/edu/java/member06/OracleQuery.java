package edu.java.member06;

public interface OracleQuery {
   public static final String URL = 
         "jdbc:oracle:thin:@192.168.0.131:1521:xe";
   public static final String USER = "scott";
   public static final String PASSWORD = "tiger";
   
   public static final String TABLE_NAME = "T_MEMBER";
   public static final String COL_ID = "ID";
   public static final String COL_PW = "PW";
   public static final String COL_NAME = "NAME";
   public static final String COL_EMAIL = "EMAIL";
   public static final String COL_INTEREST = "INTEREST";
   public static final String COL_REG_DATE = "REG_DATE";
   
   // 데이터 추가
//   INSERT INTO T_MEMBER
//   (ID, PW, NAME, EMAIL, INTEREST) 
//   VALUES (?, ?, ?, ?, ?);
   public static final String SQL_INSERT = 
         "INSERT INTO " + TABLE_NAME +
         " (" + COL_ID + ", " + COL_PW + ", " + COL_NAME + ", "
         + COL_EMAIL + ", " + COL_INTEREST + ")"
         + " VALUES (?, ?, ?, ?, ?)";
   
   // 데이터 전체 검색
   // SELECT * FROM T_MEMBER;
   public static final String SQL_SELECT = 
         "SELECT * FROM " + TABLE_NAME;
   
   // 데이터 아이디 검색
   // SELECT * FROM T_MEMBER
   // WHERE ID = ?;
   public static final String SQL_SELECT_BY_ID = 
         "SELECT * FROM " + TABLE_NAME +
         " WHERE " + COL_ID + "= ?";
   
   // 데이터 수정
//   UPDATE T_MEMBER
//   SET PW = ?,
//   NAME = ?,
//   EMAIL = ?,
//   INTEREST = ?
//   WHERE ID = ?;
   public static final String SQL_UPDATE = 
         "UPDATE " + TABLE_NAME + 
         " SET " + COL_PW + " = ?, " +
               COL_NAME + " = ?, " +
               COL_EMAIL + " = ?, " +
               COL_INTEREST + " = ? " +
               "WHERE " + COL_ID + " = ?";
   
   // 데이터 삭제
   // DELETE T_MEMBER WHERE ID = ?
   public static final String SQL_DELETE = 
         "DELETE " + TABLE_NAME + " WHERE " + COL_ID + " = ?";
   
}

