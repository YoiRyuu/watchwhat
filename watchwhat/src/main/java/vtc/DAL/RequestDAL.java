package vtc.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.Persistance.Request;
import vtc.UI.RequestUI;
import vtc.Utils.Constants;

public class RequestDAL {
    static Scanner sc = new Scanner(System.in);
    static String sql = "SELECT * FROM csdl_movie.request";
    static CallableStatement callableStatement = null;
    static String callStoreProcedure = null;
    static String xuly = null;

    public List<Request> getAll() {
        List<Request> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                lst.add(getRequest(rs));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return lst;
    }

    private Request getRequest(final ResultSet rs) throws SQLException {
        Request request = new Request();
        request.setReqID(rs.getInt("req_id"));
        request.setReqContent(rs.getString("req_content"));
        request.setReqStatus(rs.getInt("req_stt_send"));
        request.setUserID(rs.getInt("userID"));
        request.setReqASN(rs.getString("req_answer"));
        return request;
    }

    // user send request
    public static void sentRequest_User(String contentOfUser, int userID) {
        callStoreProcedure = "call sendrequest(?,?)";

        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setString(1, contentOfUser);
            callableStatement.setInt(2, userID);
            callableStatement.execute();
            System.out.println(Constants.sendRequstUser);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void AAAAAA(int Id) {
        callStoreProcedure = "CALL sent(?)";
        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, Id);
            callableStatement.execute();
            System.out.println(Constants.Decorate1);
            System.out.print("Press enter to exit the program........");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void sent_User() throws SQLException {
        String sql1 = "SELECT req_content, req_stt_send, ctm_id, req_answer, req_id FROM csdl_movie.request WHERE ctm_id = ";
        Statement statement = DbUtil.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql1 + Constants.id_temp);
        while (rs.next()) {
            switch (rs.getInt(2)) {
                case 0:
                    xuly = "Sent";
                    break;
                case 1:
                    xuly = "Wait...";
                    break;
                case 2:
                    xuly = "Replied";
                    break;
                case 3:
                    xuly = "Old";
                    break;
                default:
                    break;
            }
            RequestUI.ShowContentRequest(rs.getString(1), xuly, rs.getString(4));
            if (rs.getInt(2) == 2) {
                stt_mail(rs.getInt("req_id"), 3);
                getInbox(Constants.id_temp);
            }
        }
    }

    public static void stt_mail(int id, int stt) throws SQLException {
        String sql = "{CALL updatemail(?,?)}";
        try (CallableStatement call = DbUtil.getConnection().prepareCall(sql)) {
            call.setInt(1, id);
            call.setInt(2, stt);
            call.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // ADMIN
    public static void ViewSendAdmin() throws SQLException {
        String sql2 = "SELECT * FROM bangrequest";
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql2);
        String xuly;
        while (rs.next()) {
            if (rs.getInt(4) == 0) {
                xuly = "New";
                RequestUI.ContentMail(rs.getString(1), rs.getString(2), rs.getInt(3), xuly);
                stt_mail(rs.getInt("req_id"), 1);
            }
        }
        Constants.inbox_temp = 0;
    }

    public static void getInbox(int id) throws SQLException {
        String sql2 = "SELECT * FROM request WHERE ctm_id =" + id;
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql2);
        int n = 0;
        while (rs.next()) {
            if (rs.getInt("req_stt_send") == 2) {
                n++;
            }
        }
        Constants.inbox_temp = n;
    }

    public static void getInboxAdmin() throws SQLException {
        String sql2 = "SELECT * FROM bangrequest";
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql2);
        int n = 0;
        while (rs.next()) {
            if (rs.getInt("req_stt_send") == 0) {
                n++;
            }
        }
        Constants.inbox_temp = n;
    }

    public static void ListReqNoReply() throws SQLException {
        String sql = "SELECT * FROM csdl_movie.request";
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if (rs.getInt(3) == 0 || rs.getInt(3) == 1) {
                RequestUI.ContentMail2(rs.getInt(1), rs.getString(2), rs.getInt("ctm_id"));
            }
        }
    }

    public static void ReplyOfAdmin(String content, int id) {
        callStoreProcedure = "call reply(?,?)";
        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setString(1, content);
            callableStatement.setInt(2, id);
            callableStatement.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
