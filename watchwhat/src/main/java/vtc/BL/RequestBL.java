package vtc.BL;

import java.sql.SQLException;
import java.util.Scanner;

import vtc.DAL.RequestDAL;
import vtc.Utils.Constants;

public class RequestBL {
    static Scanner sc = new Scanner(System.in);

    public static void SendReqUI1(String Content) {
        RequestDAL.sentRequest_User(Content, Constants.id_temp);
    }

    public static void viewUI1() throws SQLException {
        RequestDAL.sent_User();
    }

    public static void SeeReqUI2() throws SQLException {
        RequestDAL.ViewSendAdmin();
    }

    public static void Reply(int id, String content) throws SQLException {
        RequestDAL.ReplyOfAdmin(content, id);
    }

}