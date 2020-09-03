package vtc;

import java.sql.Connection;

import vtc.DAL.DbUtil;
import vtc.Persistance.Aboutme;
import vtc.UI.MainUI;
public class App {
    public static void main(String[] args) throws Exception {
        // Connect to Server
        try (Connection connection = DbUtil.getConnection()) {
            System.out.println("Connected to MySql Server.");            
            // welcome UI
            Aboutme.autogetAbout();
            MainUI.welcomeUI();
        } catch (Exception e) {
            System.out.println("Connection Error!");
            e.printStackTrace();
            //TestConnect2
            // throw new Exception("Test connect failed");
        }
        //TestConnect1
        // throw new Exception("Test connect OK");
    }
}