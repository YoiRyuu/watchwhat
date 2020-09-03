package vtc.UI;

import static java.lang.System.out;

import java.sql.SQLException;
import java.util.Scanner;

import vtc.Utils.Process;
import vtc.BL.RequestBL;
import vtc.DAL.RequestDAL;
import vtc.Utils.Constants;

public class RequestUI {
    static Scanner sc = new Scanner(System.in);
    /* Use case request */
    public static void requestUI() throws SQLException {
        Boolean is_continue = true;
        while (is_continue) {
            Process.clrscr();
            out.println(Constants.Decorate2);
            out.println(Constants.UIrequest);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonsendreq);
            out.println(Constants.buttonviewreq);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            out.println(Constants.Decorate1);
            switch (choice) {
                case "1":
                    sendRequestUI();
                    break;
                case "2":
                    viewRequestSentUI();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.print("You choose wrong! Reselect: ");
                    break;
            }
        }
    }

    public static void sendRequestUI() {
        Process.clrscr();
        out.println(Constants.Decorate1);
        out.print("+ Enter the text you need to send: ");
        String Content = sc.nextLine();
        RequestBL.SendReqUI1(Content);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void viewRequestSentUI() throws SQLException {
        Process.clrscr();
        out.println(Constants.Decorate1);
        out.println("|               News sent              |");
        out.println(Constants.Decorate1);
        out.println(Constants.Decorate7);
        out.printf("| %-50s | %-10s | %-50s |\n", "Request", "Process", "Answer");
        out.println(Constants.Decorate7);
        RequestBL.viewUI1();
        out.println(Constants.Decorate7);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void ShowContentRequest(String request, String xuly, String answer) {
        out.printf("| %-50s | %-10s | %-50s |\n", request, xuly, answer);
    }

    /* Use case Manage request */
    public static void manageRequestUI() throws SQLException {
        Boolean is_continue = true;
        while (is_continue) {
            Process.clrscr();
            out.println(Constants.Decorate);
            out.println("|          REQUEST ADMIN               |");
            out.println(Constants.Decorate);
            out.println("| 1. See incoming mail                 |");
            out.println("| 2. Reply to the request              |");
            out.println("| 0. Exit                              |");
            out.println(Constants.Decorate);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            out.println(Constants.Decorate1);
            switch (choice) {
                case "1":
                    ViewMailUI();
                    break;
                case "2":
                    ReplyUI();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.print("You choose wrong! Reselect: ");
                    break;
            }
        }
    }

    public static void ViewMailUI() throws SQLException {
        Process.clrscr();
        out.println(Constants.Decorate1);
        out.println("Request sent");
        out.println(Constants.Decorate1);
        out.printf("| %-30s | %-10s | %-30s | %-15s |\n", "Name", "User ID", "Request", "Process");
        out.println(Constants.Decorate1);
        RequestBL.SeeReqUI2();
        out.println(Constants.Decorate1);
        out.print("Press enter to exit........");
        sc.nextLine();
    }

    public static void ContentMail(String name, String request, int id, String xuly) {
        out.printf("| %-30s | %-10s | %-30s | %-15s |\n", name, id, request, xuly);
    }

    public static void ReplyUI() throws SQLException {
        out.println(Constants.Decorate1);
        out.println("Request sent");
        out.println(Constants.Decorate1);
        RequestDAL.ListReqNoReply();
        out.println(Constants.Decorate1);
        out.print("Import ID_req want to reply: ");
        int id = sc.nextInt();
        sc.nextLine();
        out.print("Enter your reply: ");
        String content = sc.nextLine();
        RequestBL.Reply(id, content);
        out.print("Press enter to exit........");
        sc.nextLine();
    }

    public static void ContentMail2(int id, String request, int UserID) {
        out.printf("[ Id_req: %-5s ] [ %-50s ] [ User ID: %-5s]\n", id, request, UserID);
    }

}
