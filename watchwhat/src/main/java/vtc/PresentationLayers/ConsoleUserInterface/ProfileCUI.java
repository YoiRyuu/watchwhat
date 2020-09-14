package vtc.PresentationLayers.ConsoleUserInterface;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import vtc.BusinesLogicLayers.ProcessInput;
import vtc.BusinesLogicLayers.UserBLL;
import vtc.Utils.Constants;
import vtc.Utils.Process;
import vtc.Utils.TempData;

public class ProfileCUI {
    static Scanner sc = new Scanner(System.in);
    static String oldpass, newpass, newpass2;

    public static void profileCUI() throws SQLException {
        boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            HeaderCUI.headerCUI();
            Process.AlignCenter(100, "|", "|", Constants.UIprofile);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "|", "|", Constants.buttonviewpro);
            Process.AlignCenter(100, "|", "|", Constants.buttonupdatepro);
            Process.AlignCenter(100, "|", "|", Constants.buttonchangepass);
            Process.AlignCenter(100, "|", "|", Constants.buttonback);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    view_profileCUI();
                    break;
                case "2":
                    update_profileCUI();
                    break;
                case "3":
                    changepasswordCUI();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    public static void view_profileCUI() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UIviewprofile);
        Process.DecorateLine2Column(100, "+", "+", "+");
        Process.AlignLeft(49, "|", "|", Constants.profileinfo1);
        Process.AlignLeft(49, "|", "|", TempData.id_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo2);
        Process.AlignLeft(49, "|", "|", TempData.name_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo3);
        Process.AlignLeft(49, "|", "|", TempData.user_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo4);
        Process.AlignLeft(49, "|", "|", Constants.profileinfo4_1);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo5);
        Process.AlignLeft(49, "|", "|", TempData.email_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo6);
        Process.AlignLeft(49, "|", "|", TempData.bd_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo6);
        if (TempData.stt_temp == 1) {
            Process.AlignLeft(47, "|", "|", Constants.profileinfo7_1);
        } else if (TempData.stt_temp == 2) {
            Process.AlignLeft(51, "|", "|", Constants.profileinfo7_2);
        }
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo8);
        Process.AlignLeft(49, "|", "|", TempData.since_temp);
        System.out.println();
        Process.DecorateLine2Column(100, "+", "+", "+");
        Process.AlignCenterInput(100, Constants.Continue);
        sc.nextLine();
    }

    public static void update_profileCUI() throws SQLException {
        ProfileHeaderCUI();
        System.out.print(Constants.newname);
        String name = sc.nextLine();
        TempData.newname = name;

        String email = new ProcessInput().checkEmail(1);
        TempData.newemail = email;

        Date birthdate = new ProcessInput().check_Date(1);
        TempData.newbd = birthdate;

        Re_showAfterBD();
        Process.AlignCenterInput(100, Constants.WantUpdate);
        int ys = new ProcessInput().Yes_No_int();
        if (ys == 0) {
            UserBLL.update_profile(name, email, birthdate);
            TempData.name_temp = name;
        }
        Process.AlignCenterInput(100, Constants.Continue);
        sc.nextLine();
        Process.resetWarning();
    }

    public static void ProfileHeaderCUI() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UIupdateprofile);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", TempData.warning);
    }

    public static void Re_showAfterName() {
        ProfileHeaderCUI();
        System.out.println(Constants.newname + TempData.newname);
    }

    public static void Re_showAfterEmail() {
        Re_showAfterName();
        System.out.println(Constants.newemail + TempData.newemail);
    }

    public static void Re_showAfterBD() {
        Re_showAfterEmail();
        System.out.println(Constants.newbirthdate + TempData.newbd);
    }

    public static void changepasswordCUI() throws SQLException {
        Process.resetWarning();
        boolean is_continue = true;
        while (is_continue) {
            ChangePassHeader();
            System.out.print(Constants.oldpassString);
            oldpass = new ProcessInput().check_pass_empty();
            if (UserBLL.checkoldpass(oldpass)) {
                for (int i = 0; i < oldpass.length(); i++) {
                    TempData.oldpass = TempData.oldpass + "*";
                }
                newpass = new ProcessInput().checkPass(2);
                System.out.print(Constants.repassString);
                newpass2 = new ProcessInput().check_pass_empty();
                if (newpass2.equals(newpass)) {
                    UserBLL.update_pass(newpass);
                    is_continue = false;
                } else {
                    TempData.warning = Constants.wrongnewpass;
                }
            } else {
                Process.AlignCenterInput(100, Constants.wrongoldpass);
                is_continue = new ProcessInput().YesNo_yTrue();
            }
        }
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenterInput(100, Constants.Continue);
        sc.nextLine();
    }

    public static void input_newpass() {
        ChangePassHeader();
        System.out.println(Constants.oldpassString + Constants.password + TempData.oldpass);
    }

    public static void ChangePassHeader() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UIchangepassword);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "!", "!", TempData.warning);
    }
}
