package group4.PresentationLayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import group4.Utils.ConnectUtil;

public class Aboutme {
    public static void getAbout() {
        String sql = "SELECT * FROM wwdb.aboutme ORDER BY verid DESC LIMIT 3";
        try (Connection con = ConnectUtil.getConnection()) {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\nPatchnote: " + rs.getString("ver"));
                System.out.println(rs.getString("notepatch"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
