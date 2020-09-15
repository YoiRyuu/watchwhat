package group4.DataAccessLayers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import group4.PresentationLayers.Movie;
import group4.Utils.ConnectUtil;
import group4.Utils.Constants;
import group4.Utils.TempData;

public class MovieDAL {

    public List<Movie> getMovieAll() {
        String sql = "CALL getallmovies()";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
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
        mov.setMovieDIRECTORS(rSet.getString("movie_directors"));
        mov.setMovieCAST(rSet.getString("movie_casts"));
        mov.setMovieYEAR(rSet.getInt("movie_year"));
        mov.setmoviePREDATE(rSet.getDate("movie_premiereDay"));
        mov.setmovieCOVER(rSet.getString("movie_coverImage"));
        mov.setmovieCERTIFICATE(rSet.getString("movie_Certificate"));
        mov.setmovieRate(rSet.getDouble("movie_Rate"));
        mov.setmovieDescription(rSet.getString("movie_Description"));
        mov.setmovieNation(rSet.getString("nation_name"));
        mov.setmovieTag(rSet.getString("tag_name"));
        return mov;
    }

    public List<Movie> getMovieByName(String movname) {
        String sql = "CALL search_movie_name('" + movname + "')";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
                TempData.listmovies.add(rSet.getInt("movie_id"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovieByDirector(String director) {
        String sql = "CALL search_movie_director('" + director + "')";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
                TempData.listmovies.add(rSet.getInt("movie_id"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovieByCast(String cast) {
        String sql = "CALL search_movie_casts('" + cast + "')";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
                TempData.listmovies.add(rSet.getInt("movie_id"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovie_byNation(int id) {
        String sql = "CALL search_nation(" + id + ")";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
                TempData.listmovies.add(rSet.getInt("movie_id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovie_byTags(int id) {
        String sql = "CALL search_tag(" + id + ")";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
                TempData.listmovies.add(rSet.getInt("movie_id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovie_byFavourite(int id) {
        String sql = "CALL view_favourite(" + id + ")";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getMovie(rSet));
                TempData.listmovies.add(rSet.getInt("movie_id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lst;
    }

    public List<Movie> getMovie_byID(int id) {
        String sql = "CALL getmovieId(" + id + ")";
        List<Movie> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
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

    public static void update_movinfo(int id, String name, String dir, String cast, int year, Date predate,
            String cover, String certificate, String Description) throws SQLException {
        String callStoreProcedure = "{CALL update_movie_infor(?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement callableStatement = ConnectUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, name);
            callableStatement.setString(3, dir);
            callableStatement.setString(4, cast);
            callableStatement.setInt(5, year);
            callableStatement.setDate(6, predate);
            callableStatement.setString(7, cover);
            callableStatement.setString(8, certificate);
            callableStatement.setString(9, Description);
            callableStatement.execute();
            System.out.println(Constants.movieSuccess);
        } catch (Exception e) {
            System.out.println(Constants.movieFailed);
        }
    }
}
