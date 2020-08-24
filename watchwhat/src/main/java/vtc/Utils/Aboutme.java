package vtc.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import vtc.DAL.DbUtil;

public class Aboutme {
    public static void getAbout() {
        String sql = "SELECT * FROM csdl_movie.aboutme ORDER BY verid DESC";
        try (Connection con = DbUtil.getConnection()) {
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

    public static void autogetAbout() {
        String sql = "SELECT ver FROM csdl_movie.aboutme ORDER BY verid DESC LIMIT 1";
        try (Connection con = DbUtil.getConnection()) {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Constants.ver = rs.getString("ver");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}