package vtc.UI;

import static java.lang.System.out;
import java.sql.SQLException;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class LoginUI {
    static Scanner sc = new Scanner(System.in);

    public static void HeaderLoginUI() {
        HeaderUI.headerUI();
        Process.AlignCenter(100, "|", "|", Constants.UIlogin);
        Process.DecorateLine(100, "+", "+");
    }

    // Use case login
    public static void memberloginUI() throws SQLException {
        while (true) {
            HeaderLoginUI();
            // check acc
            String userString = new Process().checkAcc(1);
            System.out.print(Constants.password);
            String passString = new Process().check_string_empty();
            if (UserBL.login_into(userString, passString) == 1) {
                break;
            } else {
                continue;
            }
        }
    }

    public static void memberloginUI_success() throws SQLException {
        boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            HeaderUI.headerUI();
            HeaderUI.login_success();
            Process.AlignCenter(100, "|", "|", Constants.UImenu);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "|", "|", Constants.buttonprofile);
            Process.AlignCenter(100, "|", "|", Constants.buttonchangepass);
            Process.AlignCenter(100, "|", "|", Constants.buttonfavourite);
            if (Constants.lvl_temp == 1) {
                Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovie);
                Process.AlignCenter(100, "|", "|", Constants.buttonrequest);
            }

            if (Constants.lvl_temp > 1) {
                Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovie2);
                Process.AlignCenter(100, "|", "|", Constants.buttonmngrequest);
                Process.AlignCenter(100, "|", "|", Constants.buttonmngmember);
            }
            Process.AlignCenter(100, "|", "|", Constants.buttonlogout);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    ProfileUI.profileUI();
                    break;
                case "2":
                    ProfileUI.changepasswordUI();
                    break;
                case "3":
                    FavouriteUI.favourite_main();
                    break;
                case "4":
                    MovieUI.movieUI();
                    break;
                case "5":
                    if (Constants.lvl_temp == 1) {
                        RequestUI.requestUI();
                        ;
                    }
                    if (Constants.lvl_temp > 1) {
                        RequestUI.manageRequestUI();
                    }
                    break;
                case "6":
                    if (Constants.lvl_temp == 1) {
                        out.println(Constants.Wrongchoice);
                    }
                    if (Constants.lvl_temp > 1) {
                        ManageMemberUI.Manage_memberUI();
                    }
                    break;
                case "0":
                    Process.AlignCenterInput(100, Constants.logoutString);
                    int ys = new Process().Yes_No_int();
                    if (ys == 0) {
                        is_continue = false;
                    } else {
                        is_continue = true;
                    }
                    is_continue = false;
                    break;
                default:
                    warning = Constants.Wrongchoice;
                    break;
            }
        }
    }
}
