package vtc.DataAccessLayers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vtc.Utils.ConnectUtil;

public class FavouriteDAL {
    public static int check_favourite_exist(int idmem, int idmov) {
        String sql = "SELECT * FROM wwdb.favourites WHERE acc_id = " + idmem + " AND movie_id =" + idmov;
        int n = 0;
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql);) {
            while (rSet.next()) {
                n++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return n;
    }

    public static void insertTo_favourite(int memberID, int movieID) throws SQLException {
        String sql = "{CALL add_favourite(?,?)}";
        CallableStatement call = ConnectUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        call.setInt(2, movieID);
        call.execute();
        System.out.print("  /!\\ Added! ");
    }

    public static void update_favourite(int memberID, int movieID) throws SQLException {
        String sql = "{CALL update_favourite(?,?)}";
        CallableStatement call = ConnectUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        call.setInt(2, movieID);
        call.execute();
        System.out.print("  /!\\ Update! ");
    }

    public static void remove_favourite(int memberID, int movieID) throws SQLException {
        String sql = "{CALL remove_favourite(?,?)}";
        CallableStatement call = ConnectUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        call.setInt(2, movieID);
        call.execute();
        System.out.print("  /!\\ Remove! ");
    }

}
