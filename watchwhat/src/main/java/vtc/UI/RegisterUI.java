package vtc.UI;

import static java.lang.System.out;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class RegisterUI {
    static Scanner sc = new Scanner(System.in);

    public static void registerUI() throws SQLException, ParseException {
        Re_showAfterCheckAcc();
        String userString, passString, nameString, emailString;
        /* Check username exist */
        userString = new Process().checkAcc(0);
        Constants.user_temp = userString;
        System.out.print(Constants.password);
        passString = new Process().check_string_empty();
        Constants.pass_temp = passString;
        System.out.print(Constants.fullname);
        nameString = sc.nextLine();
        Constants.name_temp = nameString;
        // check email exist
        emailString = new Process().checkEmail();
        Constants.email_temp = emailString;
        Re_showAfterCheckEmail_Done();
        Date birthdate = new Process().check_Date(Constants.birthdate);
        UserBL.regiter_member(userString, passString, nameString, emailString, birthdate);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void Re_showAfterCheckAcc() {
        HeaderUI.headerUI();
        Process.AlignCenter(100, "|", "|", Constants.UIregister);
        Process.DecorateLine(100, "+", "+");
    }

    public static void Re_showAfterCheckEmail(String warning) {
        Re_showAfterCheckAcc();
        Process.AlignCenter(100, "!", "!", Constants.wrongemailformat);
        Process.AlignCenter(100, "!", "!", warning);
        System.out.println(Constants.username + Constants.user_temp);
        System.out.println(Constants.password + Constants.pass_temp);
        System.out.println(Constants.fullname + Constants.name_temp);
    }
    public static void Re_showAfterCheckEmail_format() {
        Re_showAfterCheckAcc();
        Process.AlignCenter(100, "!", "!", Constants.wrongemailformat);
        Process.AlignCenter(100, "!", "!", Constants.emailformat1);
        Process.AlignCenter(100, "!", "!", Constants.emailformat2);
        System.out.println(Constants.username + Constants.user_temp);
        System.out.println(Constants.password + Constants.pass_temp);
        System.out.println(Constants.fullname + Constants.name_temp);
    }

    public static void Re_showAfterCheckEmail_Done() {
        Re_showAfterCheckAcc();
        System.out.println(Constants.username + Constants.user_temp);
        System.out.println(Constants.password + Constants.pass_temp);
        System.out.println(Constants.fullname + Constants.name_temp);
        System.out.println(Constants.email + Constants.email_temp);
    }
}
