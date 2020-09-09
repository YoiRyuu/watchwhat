package vtc.UI;

import static java.lang.System.out;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import vtc.BL.MovieBL;
import vtc.BL.NationBL;
import vtc.BL.SourcesBL;
import vtc.BL.TagsBL;
import vtc.Persistance.Movie;
import vtc.Persistance.Nation;
import vtc.Persistance.Sources;
import vtc.Persistance.Tags;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class MovieUI {
    static Scanner sc = new Scanner(System.in);

    public static void movieHeader() {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        Process.AlignCenter(100, "|", "|", Constants.UImovie);
        Process.DecorateLine(100, "+", "+");
    }

    // Use case Search & View Movie
    public static void movieUI() throws SQLException {
        boolean is_continue = true;
        String warning = "♪♫♪~d(^.^)b~♪♫♪";
        while (is_continue) {
            movieHeader();
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovname);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovnation);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovtag);
            Process.AlignCenter(100, "|", "|", Constants.buttonback);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    searchMovieName();
                    break;
                case "2":
                    searchMovieNation();
                    break;
                case "3":
                    searchMovieTags();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    public static void searchMovieName() throws SQLException {
        movieHeader();
        out.print(Constants.mov_name);
        String movname = new Process().check_string_empty();
        MovieBL.searchMovieName(movname);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void searchMovieNation() throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
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

    public static void searchMovieTags() throws SQLException {
        HeaderUI.headerUI();
        HeaderUI.login_success();
        List<Tags> lst = new TagsBL().showAllTags();
        for (Tags tags : lst) {
            out.println(tags);
        }
        out.print(Constants.mov_tag);
        int id = sc.nextInt();
        sc.nextLine();
        MovieBL.searchMovieTag(id);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void show_mov_list(Movie mov) {
        String a = "" + mov.getMovieID();
        String b = mov.getMovieNAME();
        String c = mov.getMovieDIC();
        String d = "" + mov.getMovieYEAR();
        out.printf("[ %-10s | %-43s | %-28s | %-8s ]\n", a, b, c, d);
        out.println(Constants.Decorate4);
    }

    public static void show_mov_info(List<Movie> lst, int id) {
        int count = 0;
        String a = "", b = "";
        String name = "", tags = "";
        for (Movie mov : lst) {
            if (id == mov.getMovieID() && !name.equalsIgnoreCase(mov.getMovieNAME())) {
                a = a + mov.getmovieNation() + ", ";
                name = mov.getMovieNAME();
            }
        }
        for (Movie mov : lst) {
            if (id == mov.getMovieID() && !tags.equalsIgnoreCase(mov.getmovieTag())) {
                b = b + mov.getmovieTag() + ", ";
                tags = mov.getmovieTag();
            }
        }
        for (Movie mov : lst) {
            if (id == mov.getMovieID() && count == 0) {
                Paragraph.DecorateLine(135);
                out.printf("[ %-30s | %-100s ]\n", Constants.info1String, Constants.info2String);
                out.printf("[ %-30s | %-100s ]\n", mov.getmovieCOVER(), mov.getMovieNAME());
                out.printf("[ %-30s | %-100s ]\n", "", Constants.info3String + mov.getMovieYEAR());
                out.printf("[ %-30s | %-100s ]\n", "", Constants.info4String + mov.getmoviePREDATE());
                out.printf("[ %-30s | %-100s ]\n", "", Constants.info5String + mov.getmovieRate());
                out.printf("[ %-30s | %-100s ]\n", "", Constants.info6String + mov.getMovieDIC());
                out.printf("[ %-30s | %-100s ]\n", "", Constants.info7String + mov.getmovieCERTIFICATE());
                out.printf("[ %-30s | %-100s ]\n", "", "Nation: " + a);
                out.printf("[ %-30s | %-100s ]\n", "", "Tags: " + b);
                Paragraph.DecorateLine(135);
                out.printf("[ %-133s ]\n", "Description");
                out.printf("[ %-133s ]\n", mov.getmovieDescription());
                count = 1;
            }
        }
    }

    public static void show_mov(List<Movie> lst) throws SQLException {
        int n = 0, id = 0;
        out.println(Constants.Decorate4);
        out.println(Constants.headmov1);
        out.println(Constants.Decorate4);
        for (Movie mov : lst) {
            if (id == mov.getMovieID()) {
                continue;
            } else {
                show_mov_list(mov);
            }
            id = mov.getMovieID();
            n++;
        }
        if (n > 0) {
            out.println(Constants.numbermov + n);
            out.print(Constants.mov_select);
            int select = new Process().check_number_empty();
            show_mov_info(lst, select);
            List<Sources> lst2 = new SourcesBL().getLinkMovies(select);
            Paragraph.DecorateLine(135);
            for (Sources sources : lst2) {
                out.printf("[ %-30s | %-100s ]\n", "Episode " + sources.getEpisode(), sources.getLink());
                Paragraph.DecorateLine(135);
            }
            if (lst2.size() == 0) {
                out.println(Constants.noepisode);
                Paragraph.DecorateLine(135);
            }
            FavouriteUI.addFavourite(select);
            if (Constants.lvl_temp > 1) {
                MovieBL.update_mov_info(select);
            }
        }
        if (n == 0) {
            out.println(Constants.noname);
            Paragraph.DecorateLine(100);
        }
    }

}
