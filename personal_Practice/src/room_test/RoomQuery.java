package room_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface RoomQuery {
    default Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "scott";
        String password = "tiger";
        return DriverManager.getConnection(url, user, password);
    }
}
