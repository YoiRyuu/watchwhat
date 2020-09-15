package group4.BusinesLogicLayers;

import java.sql.SQLException;

import group4.DataAccessLayers.FavouriteDAL;

public class FavouriteBLL {

    public static void addfavourite(int memberID, int movieID) throws SQLException {
        // check_favourite_exist
        // neu khong ton tai thi tao moi
        if (FavouriteDAL.check_favourite_exist(memberID, movieID) == 0) {
            FavouriteDAL.insertTo_favourite(memberID, movieID);
        }
        // neu ton tai thi update
        else {
            FavouriteDAL.update_favourite(memberID, movieID);
        }

    }
    public static void removefavourite(int memberID, int movieID) throws SQLException {
        FavouriteDAL.remove_favourite(memberID, movieID);
    }
}
