package vtc.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vtc.UI.FavouriteUI;

public class FavouriteDAL {
    public static void showFavourite(int memberID) throws SQLException {
        String sql = "{CALL listfavourite(?)}";
        CallableStatement call = DbUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        FavouriteUI.listfavourite(call);
    }

    public static void removeFavourite(int memberID, int movieID) throws SQLException {
        String sql = "{CALL rvfavouritelist(?,?)}";
        CallableStatement call = DbUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        call.setInt(2, movieID);
        call.execute();
        System.out.println("Remove!");
    }

    public static void addFavourite(int memberID, int movieID) throws SQLException {
        String sql = "{CALL addfavouritelist(?,?)}";
        CallableStatement call = DbUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        call.setInt(2, movieID);
        call.execute();
        System.out.println("Added!");
    }
    public static void updateFavourite(int memberID, int movieID) throws SQLException {
        String sql = "{CALL updatefavouritelist(?,?)}";
        CallableStatement call = DbUtil.getConnection().prepareCall(sql);
        call.setInt(1, memberID);
        call.setInt(2, movieID);
        call.execute();
        System.out.println("Update!");
    }

    public static int check_favourite_exist(int idmem, int idmov) {
        String sql = "SELECT * FROM csdl_movie.favourites WHERE ctm_id = " + idmem + " AND movie_id =" + idmov;
        int n = 0;
        try (Connection con = DbUtil.getConnection();
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
}
