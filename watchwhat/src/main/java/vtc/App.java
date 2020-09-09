package vtc;

import java.sql.Connection;

import vtc.DAL.DbUtil;
import vtc.Persistance.Aboutme;
import vtc.UI.MainUI;
import vtc.Utils.Process;

public class App {
    public static void main(String[] args) throws Exception {
        // Connect to Server
        try (Connection connection = DbUtil.getConnection()) {
            for (int i = 3; i > 0; i--) {
                Process.clrscr();
                System.out.print("Connected to MySql Server. Please wait in " + i + "s");
                Thread.sleep(1000);
            }
            // welcome UI
            Aboutme.autogetAbout();
            MainUI.welcomeUI();
        } catch (Exception e) {
            System.out.println("Connection Error!");
            e.printStackTrace();
            /* TestConnect2 */
            // throw new Exception("Test connect failed");
        }
        /* TestConnect1 */
        // throw new Exception("Test connect OK");
    }
}