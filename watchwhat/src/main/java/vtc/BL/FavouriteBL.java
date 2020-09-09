package vtc.BL;

import java.sql.SQLException;

import vtc.DAL.FavouriteDAL;
import vtc.Utils.Constants;

public class FavouriteBL {
    public static void viewfavourite() throws SQLException {
        FavouriteDAL.showFavourite(Constants.id_temp);
    }

    public static void removefavourite(int memberID, int movieID) throws SQLException {
        FavouriteDAL.removeFavourite(memberID, movieID);
    }

    public static void addfavourite(int memberID, int movieID) throws SQLException {
        // check_favourite_exist
        // neu khong ton tai thi tao moi
        if (FavouriteDAL.check_favourite_exist(memberID, movieID) == 0) {
            FavouriteDAL.addFavourite(memberID, movieID);
        }
        // neu ton tai thi update
        else {
            FavouriteDAL.updateFavourite(memberID, movieID);
        }

    }
}
