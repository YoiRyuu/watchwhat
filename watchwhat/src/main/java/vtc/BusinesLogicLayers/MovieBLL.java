package vtc.BusinesLogicLayers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import vtc.DataAccessLayers.MovieDAL;
import vtc.PresentationLayers.Movie;

public class MovieBLL {
    private MovieDAL dal = new MovieDAL();

    public List<Movie> getAllMovies() {
        return dal.getMovieAll();
    }

    public List<Movie> getNameMovies(String movname) {
        return dal.getMovieByName(movname);
    }

    public List<Movie> getDirectorMovies(String director) {
        return dal.getMovieByDirector(director);
    }

    public List<Movie> getCastMovies(String cast) {
        return dal.getMovieByCast(cast);
    }

    public List<Movie> getNationMovies(int id) {
        return dal.getMovie_byNation(id);
    }

    public List<Movie> getIDMovies(int id) {
        return dal.getMovie_byID(id);
    }

    public List<Movie> getTagsMovies(int id) {
        return dal.getMovie_byTags(id);
    }

    public List<Movie> getFavourite(int id) {
        return dal.getMovie_byFavourite(id);
    }

    public static String GetNations(List<Movie> lst, int select) {
        String name = "", nations = "";
        for (Movie mov : lst) {
            if (select == mov.getMovieID() && !name.equalsIgnoreCase(mov.getMovieNAME())) {
                nations = nations + mov.getmovieNation() + ", ";
                name = mov.getMovieNAME();
            }
        }
        return nations;
    }

    public static String GetTags(List<Movie> lst, int select) {
        String name = "", tags = "";
        for (Movie mov : lst) {
            if (select == mov.getMovieID() && !name.equalsIgnoreCase(mov.getMovieNAME())) {
                tags = tags + mov.getmovieTag() + ", ";
                name = mov.getMovieNAME();
            }
        }
        return tags;
    }

    public static void checkInput(int id, String name, String dir, String cast, int year, Date predate, String cover,
            String certificate, String Description) throws SQLException {
        List<Movie> lst = new MovieBLL().getIDMovies(id);
        for (Movie movie : lst) {
            if (name.isBlank()) {
                name = movie.getMovieNAME();
            }
            if (dir.isBlank()) {
                dir = movie.getMovieDIRECTORS();
            }
            if (cast.isBlank()) {
                cast = movie.getMovieCAST();
            }
            if (cover.isBlank()) {
                cover = movie.getmovieCOVER();
            }
            if (certificate.isBlank()) {
                certificate = movie.getmovieCERTIFICATE();
            }
            if (Description.isBlank()) {
                Description = movie.getmovieDescription();
            }
        }
        MovieDAL.update_movinfo(id, name, dir, cast, year, predate, cover, certificate, Description);
    }
}
