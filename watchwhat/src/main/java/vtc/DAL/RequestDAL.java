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
import vtc.Utils.Constants;

public class RequestDAL {
    static Scanner sc = new Scanner(System.in);
    static String sql = "SELECT * FROM csdl_movie.reques";
    static CallableStatement callableStatement = null;
    static String callStoreProcedure = null;
    static String xuly =null;

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
        request.setReqStatus(rs.getInt("req_status"));
        request.setUserID(rs.getInt("userID"));
        request.setReqASN(rs.getString("ANS"));
        return request;
    }

    // user send request
    public static void sentRequest_User(String contentOfUser, int statusofUser, int userID) {
        callStoreProcedure = "call sendrequest(?,?,?)";

        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setString(1, contentOfUser);
            callableStatement.setInt(2, statusofUser);
            callableStatement.setInt(3, userID);
            callableStatement.execute();
            System.out.println(Constants.sendRequstUser);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void AAAAAA(int Id) {
        callStoreProcedure = "CALL sent(?)";
        try(CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, Id);
            callableStatement.execute();
            System.out.println(Constants.Decorate1);
            System.out.print("Press enter to exit the program........");

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void sent_User() throws SQLException {
        String sql1 = "SELECT req_content, req_status, ctm_id, ans FROM csdl_movie.reques WHERE ctm_id = ";
        Statement statement = DbUtil.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql1  + Constants.id_temp );
        while (rs.next()) {
            // String xuly = null;
            if (rs.getInt(2) == 1) {
                xuly = "Processing";
            } else {
                xuly = "No process";
            }
            System.out.println("| " + rs.getString(1) + " | " + xuly + " | " + rs.getString(4) + " | ");
            System.out.println(Constants.Decorate1);
        }
        System.out.print("Press enter to exit the program........");
    }


    //ADMIN 
    public static void ViewSendAdmin() throws SQLException {
        String sql2 = "SELECT * FROM bangrequest";
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql2);
        int n =0;
        while (rs.next()) {
            if (rs.getInt(4) == 1) {
                n++;
                xuly = "Processing";
                System.out.println("[ " + rs.getString(1) + " ]  [ " + rs.getString(2) + " ]  [ UserId: " + rs.getInt(3) + " ]  [ " + xuly + " ]");
                System.out.println(Constants.Decorate1);
            }
        }
        Constants.inbox_temp =n;
    }
    public static void getInbox() throws SQLException {
        String sql2 = "SELECT * FROM bangrequest";
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql2);
        int n =0;
        while (rs.next()) {
            if (rs.getInt(4) == 1) {
                n++;
            }
        }
        Constants.inbox_temp =n;
    }

    public static void ListReqNoReply() throws SQLException {
        String sql = "SELECT * FROM csdl_movie.reques";
        Statement stmt = DbUtil.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            // String xuly = null;
            if (rs.getInt(3) == 1) {
                xuly = "Processing";
                System.out.println("[ Id_req: " + rs.getInt(1) + " ] [ " + rs.getString(2) + " ] [ " + xuly + " ] [ UserID: " + rs.getInt(4) + " ] [ " + rs.getString(5) + "]");
                System.out.println(Constants.Decorate1);
            }
            
        }
        
    }

    public static void ReplyOfAdmin(String content, int id) {
        callStoreProcedure = "call reply(?,?)";
        try(CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setString(1, content);
            callableStatement.setInt(2, id);
            callableStatement.execute();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}
