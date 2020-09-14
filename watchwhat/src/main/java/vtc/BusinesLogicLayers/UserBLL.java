package vtc.BusinesLogicLayers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import vtc.DataAccessLayers.UserDAL;
import vtc.PresentationLayers.User;
import vtc.Utils.Constants;
import vtc.Utils.TempData;

public class UserBLL {
    private UserDAL dal = new UserDAL();

    public List<User> getAllCustomers() {
        return dal.getAll();
    }

    public static boolean Authentication_Acc(String userString, int x) throws SQLException {
        List<User> lst = new UserBLL().getAllCustomers();
        for (User user : lst) {
            // Register
            if (userString.equalsIgnoreCase(user.getUserAcc()) && x == 0) {
                TempData.warning = Constants.username_exist;
                TempData.user_temp = userString;
                return true;
            }
            // Login
            else if (userString.equalsIgnoreCase(user.getUserAcc()) && x == 1) {
                TempData.user_temp = userString;
                return false;
            }
        }
        return false;
    }

    public static void regiter_member(String userString, String passString, String nameString, String emailString,
            Date birthdate) throws SQLException {
        UserDAL.insert_acc(userString, passString, birthdate, emailString, nameString);
    }

    public static boolean login_into(String userString, String passString) throws SQLException {
        List<User> lst = new UserBLL().getAllCustomers();
        for (User user : lst) {
            boolean isAccount = userString.equalsIgnoreCase(user.getUserAcc()) && passString.equals(user.getUserPass());
            if (isAccount) {
                TempData.id_temp = user.getUserID();
                TempData.user_temp = user.getUserAcc();
                TempData.pass_temp = user.getUserPass();
                TempData.stt_temp = user.getUserStt();
                TempData.since_temp = user.getCreateDate();
                TempData.bd_temp = user.getBirthday();
                TempData.email_temp = user.getUserEmail();
                TempData.name_temp = user.getUserName();
                switch (user.getUserStt()) {
                    case 1:
                        TempData.level_temp = "Role: Member";
                        break;
                    case 2:
                        TempData.level_temp = "Role: Admin ";
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public static void update_profile(String name, String email, Date birthdate) throws SQLException {
        List<User> lst = new UserBLL().getAllCustomers();
        for (User user : lst) {
            if (TempData.id_temp == user.getUserID()) {
                UserDAL.update_profile(user.getUserID(), name, email, birthdate);
            }
        }
    }

    public static boolean checkoldpass(String oldpass) {
        List<User> lst = new UserBLL().getAllCustomers();
        for (User user : lst) {
            if (TempData.id_temp == user.getUserID() && oldpass.equals(user.getUserPass())) {
                return true;
            }
        }
        return false;
    }

    public static void update_pass(String newpass) throws SQLException {
        List<User> lst = new UserBLL().getAllCustomers();
        for (User user : lst) {
            if (TempData.id_temp == user.getUserID()) {
                UserDAL.update_pass(user.getUserID(), newpass);
            }
        }
    }
}
