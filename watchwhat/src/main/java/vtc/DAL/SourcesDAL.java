package vtc.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.Persistance.Sources;

public class SourcesDAL {
    public List<Sources> getSourcesByID(int select) {
        String sql = "SELECT * FROM csdl_movie.sources WHERE movie_id = " + select;
        List<Sources> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getSource(rSet));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }
    private Sources getSource(final ResultSet rSet) throws SQLException {
        Sources sou = new Sources();
        sou.setSourceID(rSet.getInt("sc_id"));
        sou.setEpisode(rSet.getInt("sc_episode"));
        sou.setLink(rSet.getString("sc_url"));
        sou.setMovieID(rSet.getInt("movie_id"));
        return sou;
    }
}