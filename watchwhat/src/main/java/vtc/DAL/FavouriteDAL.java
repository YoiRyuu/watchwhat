package vtc.DAL;

import java.sql.CallableStatement;
import java.sql.SQLException;

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
}
