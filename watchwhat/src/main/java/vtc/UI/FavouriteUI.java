package vtc.UI;

import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import vtc.BL.FavouriteBL;
import vtc.BL.MovieBL;
import vtc.BL.SourcesBL;
import vtc.Persistance.Sources;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class FavouriteUI {
    static Scanner sc = new Scanner(System.in);

    // Use case favourite
    public static void favourite_main() throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        FavouriteBL.viewfavourite();
    }

    public static void favourite_update(int ctm) throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        out.print("| [>] Remove ID movie: ");
        int mov = new Process().check_number_empty();
        FavouriteBL.removefavourite(ctm, mov);
        System.out.println(Constants.Continue);
        sc.nextLine();
    }

    public static void listfavourite(CallableStatement call) throws SQLException {
        ResultSet rSet = call.executeQuery();
        int count = 0;
        System.out.println(Constants.Decorate8);
        while (rSet.next()) {
            String a = "" + rSet.getInt(1);
            out.printf("[ %-10s | %-43s | %-28s | %-4s ]\n", a, rSet.getString(2), rSet.getString(3), rSet.getInt(4));
            System.out.println(Constants.Decorate8);
            count++;
        }
        out.println("  [!] " + count + " movie(s) to found");
        System.out.println(Constants.Decorate8);
        if (count > 0) {
            System.out.println(Constants.buttonSelect);
            System.out.println(Constants.buttonRemove);
            System.out.print(Constants.pleasechoiceString);
            String key = new Process().check_string_empty();
            switch (key) {
                case "S":
                case "s":
                    System.out.print(Constants.mov_select);
                    int select = new Process().check_number_empty();
                    List<Sources> lst2 = new SourcesBL().getLinkMovies(select);
                    for (Sources sources : lst2) {
                        System.out.println(sources);
                    }
                    if (lst2.size() == 0) {
                        System.out.println(Constants.noepisode);
                    }
                    if (Constants.lvl_temp > 1) {
                        MovieBL.update_mov_info(select);
                    }
                    break;
                case "R":
                case "r":
                    favourite_update(Constants.id_temp);
                    break;
                default:
                    System.out.println(Constants.WrongSelect);
                    break;
            }
        } else {
            System.out.print(Constants.Continue);
            sc.nextLine();
        }
    }

    public static void addFavourite(int movieID) throws SQLException {
        System.out.println("Add to Favourite? (Y/N): ");
        int ys = new Process().Yes_No_int();
        if (ys == 0) {
            FavouriteBL.addfavourite(Constants.id_temp, movieID);
        }
    }
}
