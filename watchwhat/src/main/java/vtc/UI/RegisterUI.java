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
        HeaderUI.headerUI();
        out.println(Constants.UIregister);
        out.println(Constants.Decorate2);
        String userString, passString, nameString, emailString;
        /* Check username exist */
        userString = new Process().checkAcc();

        System.out.print(Constants.password);
        passString = new Process().check_string_empty();

        System.out.print(Constants.fullname);
        nameString = sc.nextLine();

        System.out.print(Constants.email);
        emailString = new Process().check_string_empty();

        Date birthdate = new Process().check_Date(Constants.birthdate);
        UserBL.regiter_member(userString, passString, nameString, emailString, birthdate);
        out.print(Constants.Continue);
        sc.nextLine();
    }
}
