package project_hotel;

public interface RoomQuery {
    String URL = "jdbc:oracle:thin:@192.168.0.139:1521:xe"; 
    String USER = "scott";
    String PASSWORD = "tiger"; 
    String SELECT_ROOMS = "SELECT ROOM_ID, ROOM_TYPE, ROOM_PRICE, ROOM_AVAILABILITY FROM ROOMS"; // SQL 쿼리
    String UPDATE_ROOM = "UPDATE ROOMS SET ROOM_AVAILABILITY = ? WHERE ROOM_ID = ?";
    
}


		   
	
