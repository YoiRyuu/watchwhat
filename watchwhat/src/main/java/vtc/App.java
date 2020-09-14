package vtc;

import java.sql.Connection;

import vtc.PresentationLayers.ConsoleUserInterface.MainCUI;
import vtc.Utils.ConnectUtil;
import vtc.Utils.Constants;
import vtc.Utils.Process;

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
