package group4.DataAccessLayers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import group4.PresentationLayers.User;
import group4.Utils.ConnectUtil;
import group4.Utils.Constants;
import group4.Utils.Process;

public class UserDAL {
    static Scanner sc = new Scanner(System.in);
    static String username = null;
    static String password = null;
    static String sql = "SELECT * FROM wwdb.accounts";
    static String callStoreProcedure = null;
    static CallableStatement callableStatement = null;

    public List<User> getAll() {
        List<User> lst = new ArrayList<>();
        try (Connection con = ConnectUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                lst.add(getUser(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Cant get username");
        }
        return lst;
    }

    private User getUser(final ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("acc_id"));
        user.setUserAcc(rs.getString("acc_username"));
        user.setUserPass(rs.getString("acc_password"));
        user.setUserStt(rs.getInt("acc_status"));
        user.setCreateDate(rs.getTimestamp("acc_create_since"));
        user.setBirthday(rs.getDate("acc_birthdate"));
        user.setUserEmail(rs.getString("acc_email"));
        user.setUserName(rs.getString("acc_fullname"));
        return user;
    }

    public static void insert_acc(String userString, String passString, Date birthdDate, String emailString, String nameString) throws SQLException {
        callStoreProcedure = "{CALL insert_acc(?,?,?,?,?)}";
        try (CallableStatement callableStatement = ConnectUtil.getConnection().prepareCall(callStoreProcedure)) {
            // insert member
            callableStatement.setString(1, userString);
            callableStatement.setString(2, passString);
            callableStatement.setDate(3, birthdDate);
            callableStatement.setString(4, emailString);
            callableStatement.setString(5, nameString);
            callableStatement.execute();
            Process.AlignCenter(80, "\\\\\\\\\\\\\\\\\\\\", "//////////", Constants.RegisterSuccess);
            // throw new SQLException("insert OK");
        } catch (SQLException e) {
            System.out.println(Constants.RegisterFailed);
            // throw new SQLException("insert failed");
        }
    }
    public static void update_profile(int id, String name, String email, Date birthdate) throws SQLException {
        callStoreProcedure = "{CALL update_acc(?,?,?,?)}";
        try (CallableStatement callableStatement = ConnectUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, id);
            callableStatement.setDate(2, birthdate);
            callableStatement.setString(3, email);
            callableStatement.setString(4, name);
            callableStatement.execute();
            Process.AlignCenter(80, "\\\\\\\\\\\\\\\\\\\\", "//////////", Constants.ProfileSuccess);
        } catch (Exception e) {
            Process.AlignCenter(100, " ", " ", Constants.ProfileFailed);
        }
    }

    public static void update_pass(int id, String newpass) throws SQLException {
        callStoreProcedure = "{CALL change_pass(?,?)}";
        try (CallableStatement callableStatement = ConnectUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, newpass);
            callableStatement.execute();
            Process.AlignCenter(100, " ", " ", Constants.ChangePassSuccess);
        } catch (Exception e) {
            Process.AlignCenter(100, " ", " ", Constants.ChangePassFailed);
        }
    }
}
