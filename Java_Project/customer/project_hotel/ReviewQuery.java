package project_hotel;

public interface ReviewQuery {
	   public static final String URL = 
		         "jdbc:oracle:thin:@192.168.0.139:1521:xe";
		   public static final String USER = "scott";
		   public static final String PASSWORD = "tiger";
		   public static final String TABLE_NAME = "REVIEWS";
		   public static final String ADD_REVIEW = "INSERT INTO " + TABLE_NAME + " VALUES (CONTACT_SEQ.nextval, ?, ?, ?, ?)";
}
