package group4;

import java.sql.Connection;

import group4.PresentationLayers.ConsoleUserInterface.MainCUI;
import group4.Utils.ConnectUtil;
import group4.Utils.Constants;
import group4.Utils.Process;

public class App {
    public static void main(String[] args) throws Exception {
        try (Connection connection = ConnectUtil.getConnection()) {
            System.out.println(Constants.ConnectionOK);
            // // run main UI
            MainCUI.startCUI();
            Process.AlignCenter(60, "~*~*~*~*~*~*~*~*~*~*", "*~*~*~*~*~*~*~*~*~*~", Constants.ExitApp);
        } catch (Exception e) {
            System.out.println(Constants.ConnectionFailed);
        }
    }
}
