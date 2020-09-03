package vtc.UI;

import static java.lang.System.out;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import vtc.Utils.Constants;

public class MainUI {
    static Scanner sc = new Scanner(System.in);

    public static void welcomeUI() throws SQLException, ParseException {
        boolean is_continue = true;
        while (is_continue) {
            HeaderUI.headerUI();
            out.println(Constants.UIwelcome);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonregister);
            out.println(Constants.buttonlogin);
            out.println(Constants.buttonabout);
            out.println(Constants.buttonexit);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceInt);
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
                    out.println(Constants.ExitApp);
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }
}
