package vtc.UI;

import static java.lang.System.out;
import java.sql.SQLException;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class LoginUI {
    static Scanner sc = new Scanner(System.in);
    // Use case login
    public static void memberloginUI() throws SQLException {
        HeaderUI.headerUI();
        out.println(Constants.UIlogin);
        out.println(Constants.Decorate2);
        while (true) {
            System.out.print(Constants.username);
            String userString = new Process().check_string_empty();
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
        while (is_continue) {
            HeaderUI.headerUI();
            HeaderUI.login_success();
            out.println(Constants.UImenu);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonprofile);
            out.println(Constants.buttonchangepass);
            out.println(Constants.buttonfavourite);
            if (Constants.lvl_temp == 1) {
                out.println(Constants.buttonsearchmovie);
                out.println(Constants.buttonrequest);
            }

            if (Constants.lvl_temp > 1) {
                out.println(Constants.buttonsearchmovie2);
                out.println(Constants.buttonmngrequest);
                out.println(Constants.buttonmngmember);
            }
            out.println(Constants.buttonlogout);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceInt);
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
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }
}
