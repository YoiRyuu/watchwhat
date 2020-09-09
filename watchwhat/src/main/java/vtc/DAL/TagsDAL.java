package vtc.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.Persistance.Tags;

public class TagsDAL {
    private Tags getTags(final ResultSet rSet) throws SQLException {
        Tags nat = new Tags();
        nat.setTagID(rSet.getInt("tag_id"));
        nat.setTagNAME(rSet.getString("tag_name"));
        return nat;
    }

    public List<Tags> showTags() {
        String sql = "SELECT * FROM csdl_movie.tag";
        List<Tags> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getTags(rSet));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }
}
