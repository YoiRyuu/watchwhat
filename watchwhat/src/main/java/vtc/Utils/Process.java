package vtc.Utils;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Persistance.User;
import vtc.UI.LoginUI;
import vtc.UI.RegisterUI;

public class Process {
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
                    System.out.print(Constants.checkNumberEmpty);
                } else {
                    a = false;
                }
                sc.nextLine();
            } catch (Exception e) {
                System.out.print(Constants.checkNumberEmpty);
                sc.nextLine();
            }
        }
        return input;
    }

    public Date check_Date(String text) {
        Date birthdate = null;
        while (true) {
            try {
                System.out.print(text);
                birthdate = Date.valueOf(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print(Constants.wrongdate);
            }
        }
        return birthdate;

    }

    public String checkAcc(int x) throws SQLException {
        boolean checkuser = true;
        String userString = null;
        while (checkuser) {
            System.out.print(Constants.username);
            userString = new Process().check_string_empty().trim();
            checkuser = Authentication_Acc(userString, x);
        }
        return userString;
    }

    public boolean Authentication_Acc(String userString, int x) throws SQLException {
        List<User> lst = new UserBL().getAllCustomers();
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        if (userString.length() > 32 || userString.length() < 3) {
            RegisterUI.Re_showAfterCheckAcc();
            warning = Constants.over32String;
            Process.AlignCenter(100, "!", "!", warning);
            return true;
            // throw new SQLException("input failed");
        } else if (userString.indexOf(" ") > 0) {
            RegisterUI.Re_showAfterCheckAcc();
            warning = Constants.haveSpaceString;
            Process.AlignCenter(100, "!", "!", warning);
            return true;
            // throw new SQLException("input failed");
        } else if (userString.charAt(0) >= '0' && userString.charAt(0) <= '9') {
            RegisterUI.Re_showAfterCheckAcc();
            warning = Constants.numberindex0;
            Process.AlignCenter(100, "!", "!", warning);
            return true;
            // throw new SQLException("input failed");
        } else {
            // so sanh username nhap vao voi list xem co trung hay khong
            for (User user : lst) {
                if (userString.equalsIgnoreCase(user.getUserAcc()) && x == 0) {
                    RegisterUI.Re_showAfterCheckAcc();
                    warning = Constants.username_exist;
                    Process.AlignCenter(100, "!", "!", warning);
                    return true;
                    // throw new SQLException("input failed");
                }
                if (userString.equalsIgnoreCase(user.getUserAcc()) && x == 1) {
                    LoginUI.HeaderLoginUI();
                    System.out.println(Constants.username+userString);
                    return false;
                    // throw new SQLException("input OK");
                }
            }

        }
        return false;
        // throw new SQLException("input OK");
    }

    public boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String checkEmail() {
        List<User> lst = new UserBL().getAllCustomers();
        boolean checkemail = true;
        String emailString = null;
        while (checkemail) {
            int m = 0;
            System.out.print(Constants.email);
            emailString = new Process().check_string_empty().trim();
            if (emailString.length() > 50 || emailString.length() < 10) {
                RegisterUI.Re_showAfterCheckEmail(Constants.over50String);
                m = 1;
            } else if (emailString.indexOf(" ") > 0) {
                RegisterUI.Re_showAfterCheckEmail(Constants.haveSpaceString);
                m = 1;
            } else if (emailString.charAt(0) >= '0' && emailString.charAt(0) <= '9') {
                RegisterUI.Re_showAfterCheckEmail(Constants.numberindex0);
                m = 1;
            } else if (!(checkemail = isValid(emailString))) {
                RegisterUI.Re_showAfterCheckEmail_format();
                m = 1;
            } else {
                // so sanh email nhap vao voi list xem co trung hay khong
                for (User user : lst) {
                    if (emailString.equalsIgnoreCase(user.getUserEmail())) {
                        RegisterUI.Re_showAfterCheckEmail(Constants.username_exist);
                        m = 1;
                    }
                }
            }
            if (m == 0) {
                checkemail = false;
            } else {
                checkemail = true;
            }
        }
        return emailString;
    }

    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public boolean tryAgain() {
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
                return tryAgain();
        }
    }

    public int Yes_No_int() {
        String key = new Process().check_string_empty();
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

    public static void AlignCenter(int value, String deco, String deco2, String content) {
        int space = (value - content.length()) / 2;
        System.out.printf(deco + "%-" + space + "s%-" + (value - space * 2) + "s%-" + space + "s" + deco2 + "\n", "",
                content, "");
    }

    public static void AlignLeft(int value, String deco, String deco2, String content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignLeft(int value, String deco, String deco2, int content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignLeft(int value, String deco, String deco2, Date content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignCenterInput(int value, String content) {
        int space = (value - content.length()) / 2;
        System.out.printf("%-" + space + "s" + "%-" + (value - space * 2) + "s", "", content);
    }

    public static void DecorateLine(int value, String deco1, String deco2) {
        String line = "";
        for (int i = 0; i < value; i++) {
            line = line + "-";
        }
        System.out.printf(deco1 + "%" + value + "s" + deco2 + "\n", line);
    }

    public static void DecorateLine2Column(int value, String deco1, String deco2, String deco3) {
        String line = "";
        int value_after = (value / 2) - 1;
        for (int i = 0; i < value_after; i++) {
            line = line + "-";
        }
        System.out.printf(deco1 + "%-" + value_after + "s" + deco2 + deco2 + "%-" + value_after + "s" + deco3 + "\n",
                line, line);
    }
}