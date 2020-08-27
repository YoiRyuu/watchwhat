package vtc;

import java.sql.Connection;

import vtc.Utils.Aboutme;
import vtc.Utils.UILayer;
import vtc.DAL.DbUtil;
public class App {
    public static void main(String[] args) throws Exception {
        // Connect to Server
        try (Connection connection = DbUtil.getConnection()) {
            System.out.println("Connected to MySql Server.");
            // welcome UI
            Aboutme.autogetAbout();
            UILayer.welcome();
            //test git
        } catch (Exception e) {
            System.out.println("Connection Error!");
            e.printStackTrace();
        }
    }
}