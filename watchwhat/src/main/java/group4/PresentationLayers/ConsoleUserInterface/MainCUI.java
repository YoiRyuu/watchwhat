package group4.PresentationLayers.ConsoleUserInterface;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import group4.BusinesLogicLayers.ProcessInput;
import group4.Utils.Constants;
import group4.Utils.Process;
import group4.Utils.TempData;

public class MainCUI {
    static Scanner sc = new Scanner(System.in);

    public static void startCUI() throws SQLException, ParseException {
        boolean is_continue = true;
        Process.resetWarning();
        while (is_continue) {
            TempData.level_temp = Constants.level;
            HeaderCUI.headerCUI();
            Process.AlignCenter(100, "|", "|", Constants.UIwelcome);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "|", "|", Constants.buttonregister);
            Process.AlignCenter(100, "|", "|", Constants.buttonlogin);
            Process.AlignCenter(100, "|", "|", Constants.buttonabout);
            Process.AlignCenter(100, "|", "|", Constants.buttonexit);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", TempData.warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    RegisterCUI.registerUI();
                    break;
                case "2":
                    LoginCUI.memberloginUI();
                    break;
                case "3":
                    AboutmeCUI.aboutme();
                    break;
                case "0":
                    Process.AlignCenterInput(100, Constants.exitString);
                    is_continue = new ProcessInput().YesNo_yFalse();
                    break;
                default:
                    TempData.warning = Constants.Wrongchoice;
                    break;
            }
        }
    }
}
