package vtc.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.Utils.Constants;
import vtc.Utils.Process;
import vtc.Persistance.User;
import vtc.UI.ManageMemberUI;

public class UserDAL {
    static Scanner sc = new Scanner(System.in);
    static String username = null;
    static String password = null;
    static String sql = "SELECT * FROM csdl_movie.customers";
    static String callStoreProcedure = null;
    static CallableStatement callableStatement = null;

    public List<User> getAll() {
        List<User> lst = new ArrayList<>();
        try (Connection con = DbUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getUser(rs));
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    private User getUser(final ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("ctm_id"));
        user.setUserAcc(rs.getString("ctm_account"));
        user.setUserPass(rs.getString("ctm_pass"));
        user.setUserName(rs.getString("ctm_name"));
        user.setUserEmail(rs.getString("ctm_email"));
        user.setUserlvl(rs.getInt("ctm_lever"));
        user.setBirthday(rs.getDate("ctm_brithday"));
        user.setCreateDate(rs.getDate("ctm_since"));
        user.setUserStt(rs.getInt("ctm_status"));
        return user;
    }

    public static void insert_mem(String userString, String passString, String nameString, String emailString,
            Date birthdDate) throws SQLException {
        callStoreProcedure = "{CALL createCustomer(?,?,?,?,?)}";
        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            // insert member
            callableStatement.setString(1, userString);
            callableStatement.setString(2, passString);
            callableStatement.setString(3, nameString);
            callableStatement.setString(4, emailString);
            callableStatement.setDate(5, birthdDate);
            callableStatement.execute();
            System.out.println(Constants.RegisterSuccess);
            // throw new SQLException("insert OK");
        } catch (SQLException e) {
            System.out.println(Constants.RegisterFailed);
            // throw new SQLException("insert failed");
        }
    }

    public static void update_pass(int id, String newpass) throws SQLException {
        callStoreProcedure = "{CALL changepass(?,?)}";
        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, newpass);
            callableStatement.execute();
            Process.AlignCenter(100, " ", " ", Constants.ChangePassSuccess);
        } catch (Exception e) {
            Process.AlignCenter(100, " ", " ", Constants.ChangePassFailed);
        }
    }

    public static void update_profile(int id, String name, String email, Date birthdate) throws SQLException {
        callStoreProcedure = "{CALL updateprofile(?,?,?,?)}";
        try (CallableStatement callableStatement = DbUtil.getConnection().prepareCall(callStoreProcedure)) {
            callableStatement.setInt(1, id);
            callableStatement.setString(2, name);
            callableStatement.setString(3, email);
            callableStatement.setDate(4, birthdate);
            callableStatement.execute();
            Constants.name_temp = name;
            Constants.email_temp = email;
            Constants.bd_temp = birthdate;
            System.out.println(Constants.ProfileSuccess);
        } catch (Exception e) {
            System.out.println(Constants.ProfileFailed);
        }
    }

    public static void get_byname(String name) throws SQLException {
        String sql = "{CALL searchmember_byname(?)}";
        CallableStatement call = DbUtil.getConnection().prepareCall(sql);
        call.setString(1, name);
        ManageMemberUI.show_mem_byname(call);
    }

    public static void update_byid(int id, String name, String email, Date bd, int stt, int lvl) throws SQLException {
        String sql = "{CALL updatemember_id(?,?,?,?,?,?)}";
        try (CallableStatement call = DbUtil.getConnection().prepareCall(sql);) {
            call.setInt(1, id);
            call.setString(2, name);
            call.setString(3, email);
            call.setDate(4, bd);
            call.setInt(5, stt);
            call.setInt(6, lvl);
            call.execute();
            System.out.println(Constants.ProfileSuccess);
        } catch (Exception e) {
            System.out.println(Constants.ProfileFailed);
        }

    }
}