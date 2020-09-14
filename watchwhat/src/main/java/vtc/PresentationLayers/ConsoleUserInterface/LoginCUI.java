package vtc.PresentationLayers.ConsoleUserInterface;

import java.sql.SQLException;
import java.util.Scanner;

import vtc.BusinesLogicLayers.ProcessInput;
import vtc.BusinesLogicLayers.UserBLL;
import vtc.Utils.Constants;
import vtc.Utils.Process;
import vtc.Utils.TempData;

public class LoginCUI {
    static Scanner sc = new Scanner(System.in);

    public static void memberloginUI() throws SQLException {
        Process.resetWarning();
        LoginHeaderCUI();
        boolean is_continue = true;
        while (is_continue) {
            // check acc
            String userString = new ProcessInput().checkAcc(1);
            TempData.user_temp = userString;
            String passString = new ProcessInput().checkPass(1);
            if ((UserBLL.login_into(userString, passString))) {
                if (TempData.stt_temp >= 1) {
                    // Chay UI
                    LoginCUI.memberloginUI_success();
                    is_continue = false;
                } else {
                    System.out.print(Constants.acclockedString);
                    sc.nextLine();
                }

            } else {
                Process.AlignCenter(62, "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\", "////////////////////",
                        Constants.LoginFailed);
                Process.AlignCenterInput(100, Constants.Again);
                is_continue = new ProcessInput().YesNo_yTrue();
            }
        }
    }

    public static void memberloginUI_success() throws SQLException {
        boolean is_continue = true;
        Process.resetWarning();
        while (is_continue) {
            HeaderCUI.headerCUI();
            Process.AlignCenter(100, "|", "|", Constants.UImenu);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "|", "|", Constants.buttonprofile);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovies);
            Process.AlignCenter(100, "|", "|", Constants.buttonfavourite);
            if (TempData.stt_temp == 2) {
                Process.AlignCenter(100, "|", "|", Constants.buttonmanagemovies);
            }
            // Process.AlignCenter(100, "|", "|", Constants.buttonrequest);
            // Process.AlignCenter(100, "|", "|", Constants.buttonmngrequest);
            // Process.AlignCenter(100, "|", "|", Constants.buttonmngmember);
            Process.AlignCenter(100, "|", "|", Constants.buttonlogout);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", TempData.warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    ProfileCUI.profileCUI();
                    break;
                case "2":
                    MoviesCUI.movieCUI();
                    break;
                case "3":
                    FavouriteCUI.viewFavourite();
                    ;
                    break;
                case "4":
                    if (TempData.stt_temp == 2) {
                        ManageMoviesCUI.mngMovideMain();
                    } else {
                        TempData.warning = Constants.Wrongchoice;
                    }
                    break;
                case "0":
                    Process.AlignCenterInput(100, Constants.logoutString);
                    boolean a = new ProcessInput().YesNo_yFalse();
                    if (!a) {
                        TempData.name_temp = "Guest";
                        is_continue = a;
                    }
                    break;
                default:
                    TempData.warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    public static void LoginHeaderCUI() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UIlogin);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "!", "!", TempData.warning);
    }

    public static void Re_showAfterCheckAcc() {
        LoginHeaderCUI();
        System.out.println(Constants.username + TempData.user_temp);
    }
}
