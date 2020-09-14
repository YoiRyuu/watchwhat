package vtc.DataAccessLayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.PresentationLayers.Sources;
import vtc.Utils.ConnectUtil;

public class SourcesDAL {
    public List<Sources> getSourcesByID(int select) {
        String sql = "SELECT * FROM wwdb.sources WHERE movie_id = " + select + " ORDER BY source_episode";
        List<Sources> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
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
        sou.setSourceID(rSet.getInt("source_id"));
        sou.setMovieID(rSet.getInt("movie_id"));
        sou.setEpisode(rSet.getInt("source_episode"));
        sou.setLinkWatch(rSet.getString("source_url_watch"));
        sou.setLinkDown(rSet.getString("source_url_download"));
        return sou;
    }
}
