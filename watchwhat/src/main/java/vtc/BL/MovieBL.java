package vtc.BL;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import vtc.DAL.MovieDAL;
import vtc.Persistance.Movie;
import vtc.UI.MovieUI;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class MovieBL {
    static Scanner sc = new Scanner(System.in);
    private MovieDAL dal = new MovieDAL();

    public List<Movie> getAllMovies() {
        return dal.getMovieAll();
    }

    public List<Movie> getNameMovies(String movname) {
        return dal.getMovieByName(movname);
    }

    public List<Movie> getNationMovies(int id) {
        return dal.getMovie_byNation(id);
    }

    public List<Movie> getTagsMovies(int id) {
        return dal.getMovie_byTags(id);
    }

    public static void searchMovieName(String movname) throws SQLException {
        List<Movie> lst = new MovieBL().getNameMovies(movname);
        MovieUI.show_mov(lst);
    }

    public static void searchMovieNation(int id) throws SQLException {
        List<Movie> lst2 = new MovieBL().getNationMovies(id);
        MovieUI.show_mov(lst2);
    }

    public static void searchMovieTag(int id) throws SQLException {
        List<Movie> lst3 = new MovieBL().getNationMovies(id);
        MovieUI.show_mov(lst3);
    }

    //get infor movie
    public static void getinformovie(int id) {
        
    }
    // For Admin
    public static void update_mov_info(int select) throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            System.out.print(Constants.update_mov);
            String ys = new Process().check_string_empty();
            switch (ys) {
                case "y":
                case "Y":
                    System.out.print(Constants.changenamemov);
                    String name = new Process().check_string_empty();
                    System.out.print(Constants.changedirmov);
                    String dir = sc.nextLine();
                    System.out.print(Constants.changeyearmov);
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print(Constants.changeurlmov);
                    String cv = sc.nextLine();
                    MovieDAL.update_movinfo(name, dir, year, cv, select);
                    is_continue = false;
                    break;
                case "n":
                case "N":
                    is_continue = false;
                    break;
                default:
                    System.out.println(Constants.OnlyYesNo);
                    break;
            }
        }
    }

    
}