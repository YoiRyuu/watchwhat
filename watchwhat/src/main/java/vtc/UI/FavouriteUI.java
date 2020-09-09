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

    public static void favourite_header() {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        Process.AlignCenter(100, "|", "|", Constants.UIviewfavourite);
        Process.DecorateLine(100, "+", "+");
    }

    // Use case favourite
    public static void favourite_main() throws SQLException {
        favourite_header();
        FavouriteBL.viewfavourite();
    }

    public static void favourite_update(int ctm) throws SQLException {
        out.print("  [>] Remove ID movie: ");
        int mov = new Process().check_number_empty();
        FavouriteBL.removefavourite(ctm, mov);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void listfavourite(CallableStatement call) throws SQLException {
        boolean is_Continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_Continue) {
            ResultSet rSet = call.executeQuery();
            int count = 0;
            favourite_header();
            Process.AlignCenter(100, " ", " ", Constants.Decorate8);
            while (rSet.next()) {
                String a = "" + rSet.getInt(1);
                out.printf("  [ %-10s | %-43s | %-28s | %-4s ]\n", a, rSet.getString(2), rSet.getString(3),
                        rSet.getInt(4));
                Process.AlignCenter(100, " ", " ", Constants.Decorate8);
                count++;
            }
            out.println("  [!] " + count + " movie(s) to found");
            Process.AlignCenter(100, " ", " ", Constants.Decorate8);
            if (count > 0) {
                System.out.println(Constants.buttonSelect);
                System.out.println(Constants.buttonRemove);
                System.out.println(Constants.buttonBack);
                Process.DecorateLine(100, "+", "+");
                Process.AlignCenter(100, "!", "!", warning);
                Process.AlignCenterInput(100, Constants.pleasechoiceInt);
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
                        System.out.print(Constants.Continue);
                        sc.nextLine();
                        is_Continue = false;
                        break;
                    case "R":
                    case "r":
                        favourite_update(Constants.id_temp);
                        is_Continue = false;
                        break;
                    case "b":
                    case "B":
                        is_Continue = false;
                        break;
                    default:
                        warning = Constants.WrongchoiceString;
                        break;
                }

            } else {
                System.out.print(Constants.Continue);
                sc.nextLine();
                is_Continue = false;
            }
        }
    }

    public static void addFavourite(int movieID) throws SQLException {
        System.out.print("  Add to Favourite? (Y/N): ");
        int ys = new Process().Yes_No_int();
        if (ys == 0) {
            FavouriteBL.addfavourite(Constants.id_temp, movieID);
        }
    }
}
