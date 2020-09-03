package vtc.UI;

import static java.lang.System.out;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import vtc.BL.MovieBL;
import vtc.BL.NationBL;
import vtc.BL.SourcesBL;
import vtc.Persistance.Movie;
import vtc.Persistance.Nation;
import vtc.Persistance.Sources;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class MovieUI {
    static Scanner sc = new Scanner(System.in);
    // Use case Search & View Movie
    public static void movieUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            HeaderUI.headerUI();
            HeaderUI.login_success();
            out.println(Constants.UImovie);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonsearchmovname);
            out.println(Constants.buttonsearchmovnation);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    searchMovieName();
                    break;
                case "2":
                    searchMovieNation();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void searchMovieName() throws SQLException {
        Process.clrscr();
        out.print(Constants.mov_name);
        String movname = new Process().check_string_empty();
        MovieBL.searchMovieName(movname);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void searchMovieNation() throws SQLException {
        Process.clrscr();
        List<Nation> lst = new NationBL().showAllNations();
        for (Nation nation : lst) {
            out.println(nation);
        }
        out.print(Constants.mov_nation);
        int id = sc.nextInt();
        sc.nextLine();
        MovieBL.searchMovieNation(id);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void show_mov_info(Movie mov) {
        String a = "" + mov.getMovieID();
        String b = mov.getMovieNAME();
        String c = mov.getMovieDIC();
        String d = "" + mov.getMovieYEAR();
        String e = mov.getmovieCOVER();
        out.printf("[ %-10s | %-43s | %-28s | %-8s | %-70s ]\n", a, b, c, d, e);
        out.println(Constants.Decorate4);
    }

    public static void show_mov_list(List<Movie> lst) throws SQLException {
        int n = 0;
        out.println(Constants.Decorate4);
        out.println(Constants.headmov1);
        out.println(Constants.Decorate4);
        for (Movie mov : lst) {
            show_mov_info(mov);
            n++;
        }
        if (n > 0) {
            out.println(Constants.numbermov + n);
            out.print(Constants.mov_select);
            int select = new Process().check_number_empty();
            List<Sources> lst2 = new SourcesBL().getLinkMovies(select);
            Process.DecorateLine(173);
            for (Sources sources : lst2) {
                out.println(sources);
                Process.DecorateLine(173);
            }
            if (lst2.size() == 0) {
                out.println(Constants.noepisode);
                Process.DecorateLine(173);
            }
            FavouriteUI.addFavourite(select);
            if (Constants.lvl_temp > 1) {
                MovieBL.update_mov_info(select);
            }
        }
        if (n == 0) {
            out.println(Constants.noname);
            Process.DecorateLine(173);
        }
    }

}
