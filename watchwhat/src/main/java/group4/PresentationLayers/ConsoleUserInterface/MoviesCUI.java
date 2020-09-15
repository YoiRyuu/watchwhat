package group4.PresentationLayers.ConsoleUserInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import group4.BusinesLogicLayers.FavouriteBLL;
import group4.BusinesLogicLayers.MovieBLL;
import group4.BusinesLogicLayers.NationsBLL;
import group4.BusinesLogicLayers.ProcessInput;
import group4.BusinesLogicLayers.SourcesBLL;
import group4.BusinesLogicLayers.TagsBLL;
import group4.PresentationLayers.Movie;
import group4.PresentationLayers.Nations;
import group4.PresentationLayers.Sources;
import group4.PresentationLayers.Tags;
import group4.Utils.Constants;
import group4.Utils.Process;
import group4.Utils.TempData;

public class MoviesCUI {
    static Scanner sc = new Scanner(System.in);
    final static int MoviesCUI = 1;

    public static void movieHeader() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UImovie);
        Process.DecorateLine(100, "+", "+");
    }

    // Use case Search & View Movie
    public static void movieCUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            movieHeader();
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovname);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovdire);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovcast);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovnation);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovtag);
            Process.AlignCenter(100, "|", "|", Constants.buttonback);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", TempData.warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    searchMovieName(MoviesCUI);
                    break;
                case "2":
                    searchMovieDirector(MoviesCUI);
                    break;
                case "3":
                    searchMovieCast(MoviesCUI);
                    break;
                case "4":
                    searchMovieNation(MoviesCUI);
                    break;
                case "5":
                    searchMovieTags(MoviesCUI);
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    TempData.warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    public static void searchMovieName(int x) throws SQLException {
        movieHeader();
        System.out.print(Constants.mov_name);
        String movname = sc.nextLine();
        List<Movie> lst = new MovieBLL().getNameMovies(movname);
        show_list_movies(lst, x);
    }

    public static void searchMovieDirector(int x) throws SQLException {
        movieHeader();
        System.out.print(Constants.mov_director);
        String director = sc.nextLine();
        List<Movie> lst = new MovieBLL().getDirectorMovies(director);
        show_list_movies(lst, x);
    }

    public static void searchMovieCast(int x) throws SQLException {
        movieHeader();
        System.out.print(Constants.mov_cast);
        String cast = sc.nextLine();
        List<Movie> lst = new MovieBLL().getCastMovies(cast);
        show_list_movies(lst, x);
    }

    public static void searchMovieNation(int x) throws SQLException {
        movieHeader();
        List<Nations> lst2 = new NationsBLL().showAllNations();
        for (Nations nations : lst2) {
            System.out.printf("[ %-5s ] = [ %-20s ]\n", nations.getNationID(), nations.getNationeNAME());
        }
        System.out.print(Constants.mov_nation);
        int id = sc.nextInt();
        sc.nextLine();
        List<Movie> lst = new MovieBLL().getNationMovies(id);
        show_list_movies(lst, x);
    }

    public static void searchMovieTags(int x) throws SQLException {
        movieHeader();
        List<Tags> lst2 = new TagsBLL().showAllTags();
        for (Tags tags : lst2) {
            System.out.printf("[ %-5s ] = [ %-50s ]\n", tags.getTagID(), tags.getTagNAME());
        }
        System.out.print(Constants.mov_tag);
        int id = sc.nextInt();
        sc.nextLine();
        List<Movie> lst = new MovieBLL().getTagsMovies(id);
        show_list_movies(lst, x);
    }

    public static void show_list_movies(List<Movie> lst, int x) throws SQLException {
        int n = 0, id = 0;
        System.out.println(Constants.headmov1);
        Process.DecorateLine(100, "+", "+");
        for (Movie mov : lst) {
            if (id == mov.getMovieID()) {
                continue;
            } else {
                show_list_simple(mov);
            }
            id = mov.getMovieID();
            n++;
        }
        System.out.println(Constants.numbermov + n);
        Process.DecorateLine(100, "+", "+");
        if (n > 0) {
            boolean is_continue = true;
            while (is_continue) {
                System.out.print(Constants.mov_select);
                int select = new ProcessInput().check_number_empty();
                int m = 0;
                for (int i = 0; i < TempData.listmovies.size(); i++) {
                    if (select == TempData.listmovies.get(i)) {
                        show_movie_details(lst, select);
                        if (x == 1) {
                            Process.AlignLeft(50, " ", " ", Constants.buttonAdd);
                        } else if (x == 2) {
                            Process.AlignLeft(50, " ", " ", Constants.buttonRemove);
                        } else {
                            Process.AlignLeft(50, " ", " ", Constants.buttonUpdate);
                        }
                        System.out.println("\n         Or");
                        Process.AlignLeft(50, " ", " ", Constants.Continue);
                        String key = sc.nextLine();
                        switch (key) {
                            case "a":
                            case "A":
                                if (x == 1) {
                                    FavouriteBLL.addfavourite(TempData.id_temp, select);
                                    sc.nextLine();
                                }
                                break;
                            case "r":
                            case "R":
                                if (x == 2) {
                                    FavouriteBLL.removefavourite(TempData.id_temp, select);
                                    sc.nextLine();
                                }
                                break;
                            case "u":
                            case "U":
                                if (x == 3) {
                                    ManageMoviesCUI.update_mov_info(select);
                                }
                                break;
                            default:
                                break;
                        }
                        m = 1;
                        is_continue = false;
                    }
                }
                if (m == 0) {
                    System.out.println(Constants.TryAgain);
                }
            }
        } else {
            Process.AlignCenterInput(100, Constants.Continue);
            sc.nextLine();
        }
    }

    public static void show_list_simple(Movie mov) {
        String a = "" + mov.getMovieID();
        String b = mov.getMovieNAME();
        String c = mov.getMovieDIRECTORS();
        String d = "" + mov.getMovieYEAR();
        System.out.printf("[ %-10s | %-43s | %-28s | %-8s ]\n", a, b, c, d);
        Process.DecorateLine(100, "+", "+");
    }

    public static void show_movie_details(List<Movie> lst, int select) {
        int count = 0;
        String nations = MovieBLL.GetNations(lst, select);
        String tags = MovieBLL.GetTags(lst, select);
        for (Movie mov : lst) {
            if (select == mov.getMovieID() && count == 0) {
                Process.DecorateLine(100, "+", "+");
                System.out.printf("[ %-30s | %-65s ]\n", Constants.info1String, Constants.info2String);
                System.out.printf("[ %-30s | %-65s ]\n", mov.getmovieCOVER(), mov.getMovieNAME());
                System.out.printf("[ %-30s | %-65s ]\n", "", Constants.info3String + mov.getMovieYEAR());
                System.out.printf("[ %-30s | %-65s ]\n", "", Constants.info4String + mov.getmoviePREDATE());
                System.out.printf("[ %-30s | %-65s ]\n", "", Constants.info5String + mov.getmovieRate());
                System.out.printf("[ %-30s | %-65s ]\n", "", Constants.info6String + mov.getMovieDIRECTORS());
                System.out.printf("[ %-30s | %-65s ]\n", "", Constants.info8String + mov.getMovieCAST());
                System.out.printf("[ %-30s | %-65s ]\n", "", Constants.info7String + mov.getmovieCERTIFICATE());
                System.out.printf("[ %-30s | %-65s ]\n", "", "Nation: " + nations);
                System.out.printf("[ %-30s | %-65s ]\n", "", "Tags: " + tags);
                Process.DecorateLine(100, "+", "+");
                System.out.printf("[ %-98s ]\n\n  ", "Description");
                System.out.println(mov.getmovieDescription());
                count = 1;
            }
        }
        List<Sources> lst2 = new SourcesBLL().getLinkMovies(select);
        Process.DecorateLine(100, "+", "+");
        for (Sources sources : lst2) {
            System.out.printf("[ %-30s | %-65s ]\n", "Episode " + sources.getEpisode(), sources.getLinkWatch());
            System.out.printf("[ %-30s | %-65s ]\n", "Episode " + "Link Download", sources.getLinkDown());
            Process.DecorateLine(100, "+", "+");
        }
        if (lst2.size() == 0) {
            System.out.println(Constants.noepisode);
            Process.DecorateLine(100, "+", "+");
        }

        // FavouriteUI.addFavourite(select);
        // if (Constants.lvl_temp > 1) {
        // MovieBL.update_mov_info(select);
        // }
        TempData.listmovies.clear();
    }
}
