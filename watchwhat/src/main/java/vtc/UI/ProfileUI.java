package vtc.UI;
import static java.lang.System.out;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class ProfileUI {
    static Scanner sc = new Scanner(System.in);
    // Use case profile
    public static void profileUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            HeaderUI.headerUI();
            HeaderUI.login_success();
            out.println(Constants.UIprofile);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonviewpro);
            out.println(Constants.buttonupdatepro);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceInt);
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
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void view_profileUI() {
        Process.clrscr();
        System.out.println(Constants.UIviewprofile);
        System.out.println(Constants.Decorate3);
        System.out.printf(Constants.profileinfo1 + "%-42s |\n", Constants.id_temp);
        System.out.printf(Constants.profileinfo2 + "%-42s |\n", Constants.name_temp);
        System.out.printf(Constants.profileinfo3 + "%-42s |\n", Constants.user_temp);
        System.out.println(Constants.profileinfo4);
        System.out.printf(Constants.profileinfo5 + "%-42s |\n", Constants.email_temp);
        System.out.printf(Constants.profileinfo6 + "%-42s |\n", Constants.bd_temp);
        System.out.print(Constants.profileinfo7);
        if (Constants.lvl_temp == 1) {
            System.out.println(Constants.profileinfo7_1);
        } else {
            System.out.println(Constants.profileinfo7_2);
        }
        System.out.printf(Constants.profileinfo8 + "%-42s |\n", Constants.since_temp);
        System.out.println(Constants.Decorate3);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void update_profileUI() throws SQLException {
        Process.clrscr();
        System.out.println(Constants.UIupdateprofile);
        System.out.println(Constants.Decorate2);
        System.out.print(Constants.newname);
        String name = new Process().check_string_empty();
        System.out.print(Constants.newemail);
        String email = new Process().check_string_empty();
        Date birthdate = new Process().check_Date(Constants.newbirthdate);
        UserBL.update_profile(name, email, birthdate);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void changepasswordUI() throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        System.out.println(Constants.UIchangepassword);
        System.out.println(Constants.Decorate2);
        while (true) {
            System.out.print(Constants.oldpassString);
            String oldpass = new Process().check_string_empty();
            if (UserBL.change_pass(oldpass) == 1) {
                break;
            } else {
                continue;
            }
        }
        out.println(Constants.Decorate2);
        out.print(Constants.Continue);
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
                System.out.println(Constants.wrongnewpass);
            }
        }
    }
}
