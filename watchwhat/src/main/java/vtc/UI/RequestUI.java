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

    public static void requestHeader(String a) {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        Process.AlignCenter(100, "|", "|", a);
        Process.DecorateLine(100, "+", "+");
    }

    /* Use case request */
    public static void requestUI() throws SQLException {
        Boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            requestHeader(Constants.UIrequest);
            Process.AlignCenter(100, "|", "|", Constants.buttonsendreq);
            Process.AlignCenter(100, "|", "|", Constants.buttonviewreq);
            Process.AlignCenter(100, "|", "|", Constants.buttonback);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
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
                    warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    public static void sendRequestUI() {
        requestHeader(Constants.UIrequest);
        out.print("+ Enter the text you need to send: ");
        String Content = sc.nextLine();
        RequestBL.SendReqUI1(Content);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void viewRequestSentUI() throws SQLException {
        requestHeader(Constants.UIrequest);
        Process.AlignCenter(100, "|", "|", "News sent");
        Process.DecorateLine(100, "+", "+");
        RequestBL.viewUI1();
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void ShowContentRequest(String request, String xuly, String answer) {
        out.println(Constants.Decorate7);
        out.printf("| %-86s | %-9s |\n", "Request", "Process");
        out.printf("| - %-84s | [%-7s] |\n", request, xuly);
        out.println(Constants.Decorate7);
        out.printf("| %-98s |\n", "Answer");
        out.printf("| - %-96s |\n", answer);
        out.println(Constants.Decorate7);
        out.println();
    }

    /* Use case Manage request */
    public static void manageRequestUI() throws SQLException {
        Boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            requestHeader("REQUEST ADMIN");
            Process.AlignCenter(100, "|", "|", "| 1. See incoming mail                 |");
            Process.AlignCenter(100, "|", "|", "| 2. Reply to the request              |");
            Process.AlignCenter(100, "|", "|", "| 0. Exit                              |");
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
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
                    warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    public static void ViewMailUI() throws SQLException {
        requestHeader("Request sent");
        out.printf("| %-10s | %-41s | %-41s |\n", "User ID", "Name", "Request");
        Process.DecorateLine(100, "+", "+");
        RequestBL.SeeReqUI2();
        Process.DecorateLine(100, "+", "+");
        out.print("Press enter to exit........");
        sc.nextLine();
    }

    public static void ContentMail(String name, String request, int id, String xuly) {
        out.printf("| %-10s | %-41s | %-41s | %-10s |\n", id, name, request, xuly);
    }

    public static void ReplyUI() throws SQLException {
        requestHeader("Request sent");
        RequestDAL.ListReqNoReply();
        Process.DecorateLine(100, "+", "+");
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
        out.printf("[ Id_req: %-5s ] [ %-100s ] [ User ID: %-5s]\n", id, request, UserID);
    }

}
