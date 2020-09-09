package vtc.UI;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class ProfileUI {
    static Scanner sc = new Scanner(System.in);
    static String oldpass = null;

    // Use case profile
    public static void profileUI() throws SQLException {
        boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            HeaderUI.headerUI();
            HeaderUI.login_success();
            Process.AlignCenter(100, "|", "|", Constants.UIprofile);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "|", "|", Constants.buttonviewpro);
            Process.AlignCenter(100, "|", "|", Constants.buttonupdatepro);
            Process.AlignCenter(100, "|", "|", Constants.buttonback);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    view_profileUI();
                    break;
                case "2":
                    update_profileUI();
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

    public static void view_profileUI() {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        Process.AlignCenter(100, "|", "|", Constants.UIviewprofile);
        Process.DecorateLine2Column(100, "+", "+", "+");
        Process.AlignLeft(49, "|", "|", Constants.profileinfo1);
        Process.AlignLeft(49, "|", "|", Constants.id_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo2);
        Process.AlignLeft(49, "|", "|", Constants.name_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo3);
        Process.AlignLeft(49, "|", "|", Constants.user_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo4);
        Process.AlignLeft(49, "|", "|", Constants.profileinfo4_1);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo5);
        Process.AlignLeft(49, "|", "|", Constants.email_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo6);
        Process.AlignLeft(49, "|", "|", Constants.bd_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo6);
        if (Constants.lvl_temp == 1) {
            Process.AlignLeft(47, "|", "|", Constants.profileinfo7_1);
        } else {
            Process.AlignLeft(51, "|", "|", Constants.profileinfo7_2);
        }
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.profileinfo8);
        Process.AlignLeft(49, "|", "|", Constants.since_temp);
        System.out.println();
        Process.DecorateLine2Column(100, "+", "+", "+");
        Process.AlignCenter(100, "|", "|", Constants.Continue);
        sc.nextLine();
    }

    public static void update_profileUI() throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        Process.AlignCenter(100, "|", "|", Constants.UIupdateprofile);
        Process.DecorateLine(100, "+", "+");
        // Process.AlignCenter(100, "|", "|", Constants.newname);
        System.out.print(Constants.newname);
        String name = new Process().check_string_empty();
        System.out.print(Constants.newemail);
        String email = new Process().checkEmail();
        Date birthdate = new Process().check_Date(Constants.newbirthdate);
        UserBL.update_profile(name, email, birthdate);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void changepasswordUI() throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        Process.AlignCenter(100, "|", "|", Constants.UIchangepassword);
        Process.DecorateLine(100, "+", "+");
        while (true) {
            System.out.print(Constants.oldpassString);
            oldpass = new Process().check_string_empty();
            if (UserBL.change_pass(oldpass) == 1) {
                break;
            } else {
                continue;
            }
        }
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenterInput(100, Constants.Continue);
        sc.nextLine();
    }

    public static void input_newpass() {
        while (true) {
            System.out.print(Constants.newpassString);
            String newpass = new Process().check_string_empty();
            System.out.print(Constants.repassString);
            String newpass2 = new Process().check_string_empty();
            if (newpass.equals(newpass2)) {
                Constants.pass_temp = newpass;
                break;
            } else {
                HeaderUI.headerUI();
                HeaderUI.login_success();
                Process.AlignCenter(100, "|", "|", Constants.UIchangepassword);
                Process.DecorateLine(100, "+", "+");
                Process.AlignCenter(100, " ", " ", Constants.wrongnewpass);
                System.out.println(Constants.oldpassString + oldpass);
            }
        }
    }
}
