package vtc.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
    public static Connection connection = null;
    public static String url = "jdbc:mysql://localhost:3306/wwdb";
    public static String user = "root";
    public static String password = "123456";

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
