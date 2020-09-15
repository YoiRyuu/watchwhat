package group4.Utils;

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
    public static Connection getConnection(String url2, String user2, String password2) throws SQLException {
        connection = DriverManager.getConnection(url2, user2, password2);
        return connection;
    }

    public static void TestConnect(String url2, String user2, String password2) throws Exception {
        try (Connection connection = ConnectUtil.getConnection(url2, user2, password2)){
            
        } catch (Exception e) {
            throw new Exception("Test connect failed");
        }
        throw new Exception("Test connect OK");
    }
}
