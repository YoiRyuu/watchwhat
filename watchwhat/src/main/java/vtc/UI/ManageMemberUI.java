package vtc.UI;

import static java.lang.System.out;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import vtc.BL.UserBL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class ManageMemberUI {
    static Scanner sc = new Scanner(System.in);

    /* Use case Manage Members - Quản lý thành viên */
    public static void Manage_memberUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            HeaderUI.headerUI();
            HeaderUI.login_success();
            out.println(Constants.UImanagemember);
            out.println(Constants.Decorate2);
            out.println(Constants.button_mngmem1);
            out.println(Constants.button_mngmem2);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    search_member_bynameUI();
                    break;
                case "2":
                    select_member_byidUI();
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

    public static void search_member_bynameUI() throws SQLException {
        System.out.print(Constants.username);
        String name = new Process().check_string_empty();
        UserBL.search_byname(name);
    }

    public static void select_member_byidUI() throws SQLException {
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.id_select);
        int id = new Process().check_number_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_name);
        String name = new Process().check_string_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_email);
        String email = new Process().check_string_empty();
        System.out.println(Constants.Decorate6);
        Date bd = new Process().check_Date(Constants.change_bd);
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_stt);
        int stt = new Process().check_number_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_lvl);
        int lvl = new Process().check_number_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.WantUpdate);
        int key = new Process().Yes_No_int();
        if (key == 0) {
            UserBL.Update_byID(id, name, email, bd, stt, lvl);
        }
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void show_mem_byname(CallableStatement call) throws SQLException {
        ResultSet rs = call.executeQuery();
        int count = 0;
        out.println(Constants.Decorate5);
        out.println(
                "| ID    | Name     -         -         - | Email     -         -         -         -          | Birthday    | Since       | Status     | Role   | Account   -         -          |");
        String stt = null, role = null;
        out.println(Constants.Decorate5);
        while (rs.next()) {
            if (rs.getInt(6) == 1) {
                stt = "Actived   ";
            } else {
                stt = "non-Active";
            }
            if (rs.getInt(7) == 1) {
                role = "Member";
            } else {
                role = "Admin ";
            }
            out.printf("| %-5s | %-30s | %-50s | %-11s | %-11s | %-6s | %-6s | %-30s |\n", rs.getInt(1),
                    rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), stt, role, rs.getString(8));
            out.println(Constants.Decorate5);
            count++;
        }
        out.println("  [!] " + count + " member(s) to found");
        if (count > 0) {
            select_member_byidUI();
        } else {
            System.out.print(Constants.Continue);
            sc.nextLine();
        }
    }
}
