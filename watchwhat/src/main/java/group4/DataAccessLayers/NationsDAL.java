package group4.DataAccessLayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import group4.PresentationLayers.Nations;
import group4.Utils.ConnectUtil;
import group4.Utils.TempData;

public class NationsDAL {
    private Nations getNations(final ResultSet rSet) throws SQLException {
        Nations nat = new Nations();
        nat.setNationID(rSet.getInt("nation_id"));
        nat.setNationNAME(rSet.getString("nation_name"));
        return nat;
    }

    public List<Nations> showNation() {
        String sql = "SELECT * FROM wwdb.nations";
        List<Nations> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getNations(rSet));
                TempData.listmovies.add(rSet.getInt("nation_id"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }
}
