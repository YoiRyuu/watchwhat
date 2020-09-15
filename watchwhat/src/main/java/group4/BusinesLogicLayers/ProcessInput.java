package group4.BusinesLogicLayers;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import group4.PresentationLayers.ConsoleUserInterface.LoginCUI;
import group4.PresentationLayers.ConsoleUserInterface.ProfileCUI;
import group4.PresentationLayers.ConsoleUserInterface.RegisterCUI;
import group4.Utils.Constants;
import group4.Utils.TempData;
import group4.Utils.MaskingPassword.PasswordField;

public class ProcessInput {
    static Scanner sc = new Scanner(System.in);

    public String check_string_empty() {
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println(Constants.checkEmpty);
                continue;
            }
            return input;
        }
    }

    public int check_number_empty() {
        int input = 0;
        boolean a = true;
        while (a) {
            try {
                input = sc.nextInt();
                if (input < 1) {
                    System.out.print(Constants.checkNumber1);
                } else {
                    a = false;
                }
                sc.nextLine();
            } catch (Exception e) {
                System.out.print(Constants.checkEmpty);
                sc.nextLine();
            }
        }
        return input;
    }

    public String check_pass_empty() {
        while (true) {
            String input = PasswordField.readPassword(Constants.password);
            if (input.isEmpty()) {
                System.out.println(Constants.checkEmpty);
                continue;
            }
            return input;
        }
    }

    public boolean YesNo_yTrue() {
        String key = null;
        key = sc.nextLine();
        switch (key) {
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
                return false;
            default:
                System.out.print(Constants.OnlyYesNo);
                return YesNo_yTrue();
        }
    }

    public boolean YesNo_yFalse() {
        String key = null;
        key = sc.nextLine();
        switch (key) {
            case "Y":
            case "y":
                return false;
            case "N":
            case "n":
                return true;
            default:
                System.out.print(Constants.OnlyYesNo);
                return YesNo_yFalse();
        }
    }

    public int Yes_No_int() {
        String key = new ProcessInput().check_string_empty();
        switch (key) {
            case "y":
            case "Y":
                return 0;
            case "n":
            case "N":
                return 1;
            default:
                System.out.print(Constants.OnlyYesNo);
                return Yes_No_int();
        }
    }

    /* Username */
    public String checkAcc(int x) throws SQLException {
        boolean is_Continue = true, checkuser = true;
        String userString = null;
        while (is_Continue) {
            if (x == 0) {
                RegisterCUI.RegisterHeaderCUI();
            } else {
                LoginCUI.LoginHeaderCUI();
            }
            System.out.print(Constants.username);
            userString = new ProcessInput().check_string_empty().trim();
            checkuser = check_Incorrect_Username(userString);
            if (checkuser == true) {
                is_Continue = UserBLL.Authentication_Acc(userString, x);
            }
        }
        return userString;
    }

    public boolean check_Incorrect_Username(String userString) {
        if (userString.length() > 32 || userString.length() < 6) {
            TempData.warning = Constants.over32String;
            return false;
        } else if (userString.indexOf(" ") > 0) {
            TempData.warning = Constants.haveSpaceString;
            return false;
        } else if (userString.charAt(0) >= '0' && userString.charAt(0) <= '9') {
            TempData.warning = Constants.numberindex0;
            return false;
        } else {
            return true;
        }
    }

    /* Password */
    public String checkPass(int x) {
        boolean is_Continue = true;
        String pass = null;
        while (is_Continue) {
            if (x == 0) {
                RegisterCUI.Re_showAfterCheckAcc();
            } else if (x == 1) {
                LoginCUI.Re_showAfterCheckAcc();
            } else if (x == 2) {
                ProfileCUI.input_newpass();
                System.out.print(Constants.newpassString);
            }
            pass = new ProcessInput().check_pass_empty().trim();
            is_Continue = check_Incorrect_Pass(pass);
        }
        for (int i = 0; i < pass.length(); i++) {
            TempData.pass_masking = TempData.pass_masking + "*";
        }
        return pass;
    }

    public boolean check_Incorrect_Pass(String pass) {
        if (!(pass.length() >= 6 && pass.length() <= 32)) {
            TempData.warning = Constants.over32String;
            return true;
        } else if (pass.indexOf(" ") > 0) {
            TempData.warning = Constants.haveSpaceString;
            return true;
        } else {
            return false;
        }
    }

    /* Birthdate */
    public Date check_Date(int x) {
        Date birthdate = null;
        boolean is_Continue = true;
        while (is_Continue) {
            try {
                if (x == 0) {
                    RegisterCUI.Re_showAfterCheckEmail();
                    System.out.print(Constants.birthdate);
                } else if (x == 1) {
                    ProfileCUI.Re_showAfterEmail();
                    System.out.print(Constants.newbirthdate);
                } else {
                    System.out.print(Constants.changepremov);
                }
                birthdate = Date.valueOf(sc.nextLine());
                is_Continue = Range_Date(birthdate);
            } catch (Exception e) {
                TempData.warning = Constants.wrongdate;
            }
        }
        return birthdate;
    }

    public boolean Range_Date(Date birthdate) {
        Date a = Date.valueOf("1900-1-1");
        Date b = Date.valueOf(LocalDate.now());
        if (birthdate.compareTo(a) >= 0 && birthdate.compareTo(b) < 0) {
            return false;
        } else {
            TempData.warning = Constants.smalldate;
            return true;
        }
    }

    /* Email */
    public boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String checkEmail(int x) {
        boolean checkemail = true;
        String emailString = null;
        while (checkemail) {
            if (x == 0) {
                RegisterCUI.Re_showAfterName();
                System.out.print(Constants.email);
            } else {
                ProfileCUI.Re_showAfterName();
                System.out.print(Constants.newemail);
            }
            emailString = new ProcessInput().check_string_empty().trim();
            if (emailString.length() > 50 || emailString.length() < 10) {
                TempData.warning = Constants.wrongemailformat + Constants.over50String;
                continue;
            } else if (!(isValid(emailString))) {
                TempData.warning = Constants.wrongemailformat + Constants.over50String;
                continue;
            } else if (UserBLL.checkEmail_exist(emailString)) {
                TempData.warning = Constants.email_exist;
                continue;
            } else {
                checkemail = false;
            }
        }
        return emailString;
    }

    /* Test */
    public void checkAccTest(String userString) throws Exception {
        if (userString.isEmpty()) {
            throw new Exception("input failed");
        } else if (!check_Incorrect_Username(userString)) {
            throw new Exception("input failed");
        } else {
            throw new Exception("input OK");
        }
    }

    public void checkPassTest(String password) throws Exception {
        if (password.isEmpty()) {
            throw new Exception("input failed");
        } else if (check_Incorrect_Pass(password)) {
            throw new Exception("input failed");
        } else {
            throw new Exception("input OK");
        }
    }
    public void checkEmailTest(String email) throws Exception {
        if (email.isEmpty()) {
            throw new Exception("input failed");
        } else if (email.length() > 50 || email.length() < 10) {
            throw new Exception("input failed");
        } else if (!(isValid(email))) {
            throw new Exception("input failed");
        } else {
            throw new Exception("input OK");
        }
    }
}
