package vtc.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.Persistance.Movie;
import vtc.Persistance.Sources;

public class MovieDAL {
    public List<Movie> getMovieAll() {
        String sql = "SELECT * FROM csdl_movie.movie;";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovieByName(String movname) {
        String sql = "SELECT * FROM csdl_movie.movie WHERE movie_name LIKE '%" + movname + "%'";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }

    private Movie getMovie(final ResultSet rSet) throws SQLException {
        Movie mov = new Movie();
        mov.setMovieID(rSet.getInt("movie_id"));
        mov.setMovieNAME(rSet.getString("movie_name"));
        mov.setMovieDIC(rSet.getString("movie_directors"));
        mov.setMovieYEAR(rSet.getInt("movie_year"));
        mov.setmoviePREDATE(rSet.getDate("movie_premiereDay"));
        mov.setmovieCOVER(rSet.getString("movie_coverImage"));
        mov.setmovieCERTIFICATE(rSet.getString("movie_Certificate"));
        return mov;
    }
}