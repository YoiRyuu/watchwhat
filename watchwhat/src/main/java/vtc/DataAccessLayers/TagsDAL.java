package vtc.DataAccessLayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.PresentationLayers.Tags;
import vtc.Utils.ConnectUtil;

public class TagsDAL {
    private Tags getTags(final ResultSet rSet) throws SQLException {
        Tags nat = new Tags();
        nat.setTagID(rSet.getInt("tag_id"));
        nat.setTagNAME(rSet.getString("tag_name"));
        return nat;
    }

    public List<Tags> showTags() {
        String sql = "SELECT * FROM wwdb.tags";
        List<Tags> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
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
