package vtc.BL;

import java.sql.SQLException;
import java.util.Scanner;

import vtc.DAL.RequestDAL;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class RequestBL {
    static Scanner sc = new Scanner(System.in);

    public static void ViewReqUser() throws SQLException {
        Boolean is_continue = true;
        while (is_continue) {
            Process.clrscr();
            System.out.println(Constants.Decorate2);
            System.out.println(Constants.requestheader);
            System.out.println(Constants.Decorate2);
            System.out.println(Constants.buttonsendreq);
            System.out.println(Constants.buttonviewreq);
            System.out.println(Constants.buttonback);
            System.out.println(Constants.Decorate2);
            System.out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            System.out.println(Constants.Decorate1);
            switch (choice) {
                case "1":
                    RequestBL.SendReqUI1();
                    break;
                case "2":
                    RequestBL.sentUI1();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    System.out.print("You choose wrong! Reselect: ");
                    break;
            }
        }

    }

    public static void SendReqUI1() {
        String Content;
        Process.clrscr();
        System.out.println(Constants.Decorate1);
        System.out.println(Constants.Decorate1);
        System.out.print("+ Enter the text you need to send: ");
        Content = sc.nextLine();
        int stt = 1;
        RequestDAL.sentRequest_User(Content, stt, Constants.id_temp);
        sc.nextLine();
    }

    public static void sentUI1() throws SQLException {
        Process.clrscr();
        System.out.println(Constants.Decorate1);
        System.out.println("|               News sent              |");
        System.out.println(Constants.Decorate1);
        RequestDAL.sent_User();
        // RequestDAL.AAAAAA(Constants.id_temp);
        sc.nextLine();
    }


    public static void ViewAdmin() throws SQLException {
        Boolean is_continue = true;
        while (is_continue) {
            Process.clrscr();
            System.out.println(Constants.Decorate);
            System.out.println("|          REQUEST ADMIN               |");
            System.out.println(Constants.Decorate);
            System.out.println("| 1. See incoming mail                 |");
            System.out.println("| 2. Reply to the request              |");
            System.out.println("| 0. Exit                              |");
            System.out.println(Constants.Decorate);
            System.out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            System.out.println(Constants.Decorate1);
            switch (choice) {
                case "1":
                    RequestBL.SeeReqUI2();
                    break;
                case "2":
                    RequestBL.Reply();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    System.out.print("You choose wrong! Reselect: ");
                    break;
            }
        }

    }

    public static void SeeReqUI2() throws SQLException {
        System.out.println(Constants.Decorate1);
        System.out.println("Request sent");
        System.out.println(Constants.Decorate1);
        RequestDAL.ViewSendAdmin();
        System.out.print("Press enter to exit........");
        sc.nextLine();
    }

    public static void Reply() throws SQLException {
        System.out.println(Constants.Decorate1);
        System.out.println("Request sent");
        System.out.println(Constants.Decorate1);
        RequestDAL.ListReqNoReply();
        System.out.println(Constants.Decorate1);
        System.out.print("Enter your reply: ");
        String content = sc.nextLine();
        System.out.print("Import ID_req want to reply: ");
        int id = sc.nextInt();
        RequestDAL.ReplyOfAdmin(content, id);
        System.out.print("Press enter to exit........");
        sc.nextLine();
    }

}