package vtc.BL;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import vtc.DAL.RequestDAL;
import vtc.DAL.UserDAL;
import vtc.Utils.Constants;
import vtc.Utils.Process;
import vtc.Persistance.User;
import vtc.UI.LoginUI;
import vtc.UI.ProfileUI;

public class UserBL {
    static Scanner sc = new Scanner(System.in);

    private UserDAL dal = new UserDAL();

    public List<User> getAllCustomers() {
        return dal.getAll();
    }

    public static void regiter_member(String userString, String passString, String nameString, String emailString,
            Date birthdate) throws SQLException, ParseException {
        UserDAL.insert_mem(userString, passString, nameString, emailString, birthdate);
    }

    public static int login_into(String userString, String passString) throws SQLException {
        int n = 0;
        List<User> lst = new UserBL().getAllCustomers();
        for (User user : lst) {
            boolean isAccount = userString.equalsIgnoreCase(user.getUserAcc()) && passString.equals(user.getUserPass());
            if (isAccount) {
                Constants.id_temp = user.getUserID();
                Constants.name_temp = user.getUserName();
                Constants.email_temp = user.getUserEmail();
                Constants.bd_temp = user.getBirthday();
                Constants.since_temp = user.getCreateDate();
                Constants.stt_temp = user.getUserStt();
                Constants.lvl_temp = user.getUserlvl();
                Constants.user_temp = user.getUserAcc();
                n = 1;
                switch (user.getUserlvl()) {
                    case 1:
                        Constants.namelever = "Role: Member";
                        RequestDAL.getInbox(Constants.id_temp);
                        break;
                    case 2:
                        Constants.namelever = "Role: Admin ";
                        RequestDAL.getInboxAdmin();
                        break;
                    default:
                        break;
                }
            }
        }
        if (n > 0) {
            if (Constants.stt_temp == 1) {
                // Chay UI cua member
                LoginUI.memberloginUI_success();
                return 1;
            } else {
                System.out.print("Tai khoan bi khoa, neu co gi thac mac vui long lien he admin");
                sc.nextLine();
                return 1;
            }

        } else {
            System.out.println(Constants.LoginFailed);
            System.out.print(Constants.Again);
            return new Process().Yes_No_int();
        }
    }

    public static int change_pass(String oldpass) throws SQLException {
        List<User> lst = new UserBL().getAllCustomers();
        int n = 0;
        for (User user : lst) {
            if (Constants.id_temp == user.getUserID() && oldpass.equals(user.getUserPass())) {
                ProfileUI.input_newpass();
                UserDAL.update_pass(user.getUserID(), Constants.pass_temp);
                n = 1;
                break;
            }
        }
        if (n == 0) {
            System.out.print(Constants.wrongoldpass);
            return new Process().Yes_No_int();
        }
        return n;
    }

    // PROFILE
    public static void update_profile(String name, String email, Date birthdate) throws SQLException {
        List<User> lst = new UserBL().getAllCustomers();
        for (User user : lst) {
            if (Constants.id_temp == user.getUserID()) {
                UserDAL.update_profile(user.getUserID(), name, email, birthdate);
            }
        }
    }

    public static void search_byname(String name) throws SQLException {
        UserDAL.get_byname(name);
    }

    public static void Update_byID(int id, String name, String email, Date bd, int stt, int lvl) throws SQLException {
        UserDAL.update_byid(id, name, email, bd, stt, lvl);
    }
}