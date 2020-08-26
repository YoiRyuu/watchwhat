package vtc.BL;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import vtc.DAL.MovieDAL;
import vtc.Persistance.Nation;
import vtc.Persistance.Movie;
import vtc.Utils.Constants;
import vtc.Utils.Process;
import vtc.Utils.UILayer;

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

    public static void searchMovieName() throws SQLException {
        Process.clrscr();
        System.out.print(Constants.mov_name);
        String movname = new Process().check_input_empty();
        List<Movie> lst = new MovieBL().getNameMovies(movname);
        UILayer.show_mov_info2(lst);
    }

    public static void searchMovieNation() throws SQLException {
        Process.clrscr();
        List<Nation> lst = new NationBL().showAllNations();
        for (Nation nation : lst) {
            System.out.println(nation);
        }
        System.out.print(Constants.mov_name);
        int id = sc.nextInt();
        sc.nextLine();
        List<Movie> lst2 = new MovieBL().getNationMovies(id);
        UILayer.show_mov_info2(lst2);
    }

    // For Admin
    public static void update_mov_info(String ys, int select) throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            switch (ys) {
                case "y":
                case "Y":
                    System.out.print("name ");
                    String name = new Process().check_input_empty();
                    System.out.print("dir ");
                    String dir = sc.nextLine();
                    System.out.print("year ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print("cover ");
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