package project_hotel;

public interface ReserveQuery {
	   public static final String URL = 
		         "jdbc:oracle:thin:@192.168.0.139:1521:xe";
		   public static final String USER = "scott";
		   public static final String PASSWORD = "tiger";
		   public static final String TABLE_NAME = "RESERVATIONS";
		   public static final String RESERVE_ID = "RESERVE_ID";
		   public static final String CHECK_IN = "CHECK_IN_DATE";
		   public static final String CHECK_OUT = "CHECK_OUT_DATE";
		   public static final String ROOM_ID = "ROOM_ID";
		   public static final String CUSTOMER_ID = "CUSTOMER_ID";
		   public static final String TOTAL_PRICE = "TOTAL_PRICE";
		   public static final String SQL_UPDATE_AVAILABILITY = "UPDATE ROOMS SET ROOM_AVAILABILITY = '가능' WHERE ROOM_ID = ?";
		   public static final String SQL_SELECT_BY_ROOM = "SELECT ROOM_ID FROM RESERVATIONS WHERE CUSTOMER_ID = ?";
		   
		   public static final String SQL_RESERVE = "INSERT INTO " + TABLE_NAME 
                   + " VALUES (CONTACT_SEQ.nextval, ?, ?, ?, ?, ?)";
		  
		   public static final String SQL_SELECT = 
			         "SELECT * FROM " + TABLE_NAME;
		
		   public static final String SQL_CHECKID = 
				   "SELECT COUNT(" + RESERVE_ID + ") FROM "+ TABLE_NAME +
				   " WHERE " + RESERVE_ID + " = ?";
		   
		   public static final String SQL_SELECT_BY_CUSTOMER = 
			         "SELECT * FROM " + TABLE_NAME +
			         " WHERE " + CUSTOMER_ID + "= ?";
			   
		   public static final String SQL_CANCEL = 
				   "DELETE FROM " + TABLE_NAME + " WHERE " + RESERVE_ID + " = ?";
		   
		   public static final String SQL_DELETE = 
		         "DELETE FROM " + TABLE_NAME + " WHERE " + CUSTOMER_ID + " = ?";
}