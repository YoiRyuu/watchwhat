package group4.PresentationLayers.ConsoleUserInterface;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import group4.BusinesLogicLayers.ProcessInput;
import group4.BusinesLogicLayers.UserBLL;
import group4.Utils.Constants;
import group4.Utils.Process;
import group4.Utils.TempData;

public class RegisterCUI {
    static Scanner sc = new Scanner(System.in);

    public static void registerUI() throws SQLException {
        Process.resetWarning();
        RegisterHeaderCUI();

        TempData.warning = "Input Username";
        String userString = new ProcessInput().checkAcc(0); // Check incorrect & exist username
        TempData.user_temp = userString; // Save to temp

        TempData.warning = "Input Password";
        String passString = new ProcessInput().checkPass(0); // Check incorrect password
        TempData.pass_temp = passString; // Save to temp
        
        TempData.warning = "Input Full name";
        System.out.print(Constants.fullname);
        String nameString = sc.nextLine();
        TempData.name_temp2 = nameString; // Save to temp
        
        TempData.warning = "Input Email";
        String emailString = new ProcessInput().checkEmail(0); // Check incorrect & exist email
        TempData.email_temp = emailString; // Save to temp
        
        TempData.warning = "Input Your birthday";
        Date birthdate = new ProcessInput().check_Date(0); // Check incorrect Date
        TempData.bd_temp = birthdate;

        Re_showAfterCheckBirthdate();
        Process.AlignCenterInput(100, Constants.ConfirmRegister);
        int ys = new ProcessInput().Yes_No_int();
        if (ys == 0) {
            UserBLL.regiter_member(userString, passString, nameString, emailString, birthdate);
        }
        Process.AlignCenterInput(100, Constants.Continue);
        sc.nextLine();
        TempData.pass_masking = "";
    }

    public static void RegisterHeaderCUI() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UIregister);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "!", "!", TempData.warning);
    }

    public static void Re_showAfterCheckAcc() {
        RegisterHeaderCUI();
        System.out.println(Constants.username + TempData.user_temp);
    }

    public static void Re_showAfterCheckPass() {
        Re_showAfterCheckAcc();
        System.out.println(Constants.password + TempData.pass_masking);
    }

    public static void Re_showAfterName() {
        Re_showAfterCheckPass();
        System.out.println(Constants.fullname + TempData.name_temp2);
    }

    public static void Re_showAfterCheckEmail() {
        Re_showAfterName();
        System.out.println(Constants.email + TempData.email_temp);
    }

    public static void Re_showAfterCheckBirthdate() {
        Process.resetWarning();
        RegisterHeaderCUI();
        Process.AlignLeft(49, "|", "|", Constants.username);
        Process.AlignLeft(49, "|", "|", TempData.user_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.password);
        Process.AlignLeft(49, "|", "|", TempData.pass_masking);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.fullname);
        Process.AlignLeft(49, "|", "|", TempData.name_temp2);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.email);
        Process.AlignLeft(49, "|", "|", TempData.email_temp);
        System.out.println();
        Process.AlignLeft(49, "|", "|", Constants.birthdate);
        Process.AlignLeft(49, "|", "|", TempData.bd_temp);
        System.out.println();
        Process.DecorateLine(100, "+", "+");
    }
}
