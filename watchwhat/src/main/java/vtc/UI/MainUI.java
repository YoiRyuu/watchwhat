package vtc.UI;

import static java.lang.System.out;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import vtc.Utils.Constants;
import vtc.Utils.Process;

public class MainUI {
    static Scanner sc = new Scanner(System.in);

    public static void welcomeUI() throws SQLException, ParseException {
        boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            HeaderUI.headerUI();
            Process.AlignCenter(100, "|", "|", Constants.UIwelcome);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "|", "|", Constants.buttonregister);
            Process.AlignCenter(100, "|", "|", Constants.buttonlogin);
            Process.AlignCenter(100, "|", "|", Constants.buttonabout);
            Process.AlignCenter(100, "|", "|", Constants.buttonexit);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    RegisterUI.registerUI();
                    break;
                case "2":
                    LoginUI.memberloginUI();
                    break;
                case "3":
                    AboutmeUI.aboutme();
                    break;
                case "0":
                    System.out.print(Constants.exitString);
                    int ys = new Process().Yes_No_int();
                    if (ys == 0) {
                        out.println(Constants.ExitApp);
                        is_continue = false;
                    } else {
                        is_continue = true;
                    }
                    break;
                default:
                    warning = Constants.Wrongchoice;
                    break;
            }
        }
    }
}
