package group4.PresentationLayers.ConsoleUserInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import group4.BusinesLogicLayers.MovieBLL;
import group4.PresentationLayers.Movie;
import group4.Utils.Constants;
import group4.Utils.Process;
import group4.Utils.TempData;

public class FavouriteCUI {
    static Scanner sc = new Scanner(System.in);
    final static int FavouriteCUI = 2;
    public static void favourite_header() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UIviewfavourite);
        Process.DecorateLine(100, "+", "+");
    }

    public static void viewFavourite() throws SQLException {
        favourite_header();
        List<Movie> lst = new MovieBLL().getFavourite(TempData.id_temp);
        MoviesCUI.show_list_movies(lst, FavouriteCUI);
    }
}
