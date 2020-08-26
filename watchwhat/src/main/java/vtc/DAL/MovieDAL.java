package vtc.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.Persistance.Movie;
import vtc.Utils.Constants;

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
        // String sql = "SELECT * FROM csdl_movie.movie WHERE movie_name LIKE concat('%'," + movname + ",'%)'";
        String sql = "CALL search_name('" + movname + "')";
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

    public List<Movie> getMovie_byNation(int id) {
        String sql = "CALL search_nation(" + id + ")";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
            }
        } catch (Exception e) {
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

    public static void update_movinfo(String name, String dir, int year, String cv,int id) throws SQLException {
        String callStoreProcedure = "{CALL update_mov_info(?,?,?,?,?)}";
        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setString(1, name);
            callableStatement.setString(2, dir);
            callableStatement.setInt(3, year);
            callableStatement.setString(4, cv);
            callableStatement.setInt(5, id);
            callableStatement.execute();
            System.out.println(Constants.movieSuccess);
        } catch (Exception e) {
            System.out.println(Constants.movieFailed);
        }
    }
}
