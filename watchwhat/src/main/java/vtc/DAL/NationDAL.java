package vtc.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vtc.Persistance.Nation;

public class NationDAL {
    private Nation getNation(final ResultSet rSet) throws SQLException {
        Nation nat = new Nation();
        nat.setNationID(rSet.getInt("contry_id"));
        nat.setNationNAME(rSet.getString("contry_name"));
        return nat;
    }

    public List<Nation> showNation() {
        String sql = "SELECT * FROM csdl_movie.contry";
        List<Nation> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rSet = stm.executeQuery(sql)) {
            while (rSet.next()) {
                lst.add(getNation(rSet));
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }
}