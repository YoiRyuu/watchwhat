package vtc.Utils;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Persistance.User;

public class Process {
    static Scanner sc = new Scanner(System.in);

    public String check_input_empty() {
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println(Constants.checkEmpty);
                continue;
            }
            return input;
        }
    }

    public Date check_Date() {
        Date birthdate = null;
        while (true) {
            try {
                birthdate = Date.valueOf(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(Constants.wrongdate);
            }
        }
        return birthdate;

    }

    public String checkAcc() {
        List<User> lst = new UserBL().getAllCustomers();
        boolean checkuser = true;
        String userString = null;
        while (checkuser) {
            System.out.print(Constants.username);
            userString = new Process().check_input_empty();
            int m = 0;
            // so sanh username nhap vao voi list xem co trung hay khong
            for (User user : lst) {
                if (userString.equalsIgnoreCase(user.getUserAcc())) {
                    System.out.println(Constants.username_exist);
                    m = 1;
                }
            }
            if (m == 0) {
                checkuser = false;
            }
        }
        return userString;
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
}