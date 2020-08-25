package vtc.BL;

import java.util.List;
import java.util.Scanner;

import vtc.DAL.MovieDAL;
import vtc.DAL.SourcesDAL;
import vtc.Persistance.Movie;
import vtc.Persistance.Sources;
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

    

    public static void searchMovieBL() {
        System.out.print(Constants.mov_name);
        String movname = new Process().check_input_empty();
        int n = 0;
        List<Movie> lst = new MovieBL().getNameMovies(movname);
        for (Movie movie : lst) {
            System.out.println(movie);
            n++;
        }
        if (n>0) {
            System.out.print(Constants.mov_select);
            int select = sc.nextInt();
            sc.nextLine();
            List<Sources> lst2 = new SourcesBL().getLinkMovies(select);
            for (Sources sources : lst2) {
                System.out.println(sources);
            }
            System.out.print(Constants.Continue);
            sc.nextLine();
        }
        if (n == 0) {
            System.out.println(Constants.noname);
        }
    }
}