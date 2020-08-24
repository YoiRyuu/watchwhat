package vtc.BL;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import vtc.DAL.UserDAL;
import vtc.Utils.Constants;
import vtc.Utils.Process;
import vtc.Utils.UILayer;
import vtc.Persistance.User;

public class UserBL {
    static Scanner sc = new Scanner(System.in);

    private UserDAL dal = new UserDAL();

    public List<User> getAllCustomers() {
        return dal.getAll();
    }

    public static void regiter_member() throws SQLException, ParseException {
        /* Check username exist */
        String userString = null;
        String passString = null;
        String nameString = null;
        String emailString = null;

        userString = new Process().checkAcc();

        System.out.print(Constants.password);
        passString = new Process().check_input_empty();

        System.out.print(Constants.fullname);
        nameString = sc.nextLine();

        System.out.print(Constants.email);
        emailString = new Process().check_input_empty();

        System.out.print(Constants.birthdate);
        Date birthdate = new Process().check_Date();

        UserDAL.insert_mem(userString, passString, nameString, emailString, birthdate);
    }

    public static void login_into() throws SQLException {
        // input & check username,password
        boolean is_Continues = true;
        while (is_Continues) {
            System.out.print(Constants.username);
            String userString = new Process().check_input_empty();

            System.out.print(Constants.password);
            String passString = new Process().check_input_empty();

            int n = 0, m = 0;

            List<User> lst = new UserBL().getAllCustomers();
            for (User user : lst) {
                if (userString.equalsIgnoreCase(user.getUserAcc()) && passString.equals(user.getUserPass())) {
                    Constants.id_temp = user.getUserID();
                    Constants.name_temp = user.getUserName();
                    Constants.email_temp = user.getUserEmail();
                    Constants.bd_temp = user.getBirthday();
                    Constants.since_temp = user.getCreateDate();
                    Constants.stt_temp = user.getUserStt();
                    Constants.lvl_temp = user.getUserlvl();
                    Constants.user_temp = user.getUserAcc();
                    m = user.getUserlvl();
                    n = user.getUserID();
                    switch (m) {
                        case 1:
                            Constants.namelever = "Lever: Member";
                            break;
                        case 2:
                            Constants.namelever = "Lever: Admin ";
                            break;

                        default:
                            break;
                    }
                }
            }

            if (n > 0) {
                // Chay UI cua member
                UILayer.memberloginUI2();
                is_Continues = false;
            } else {
                System.out.println(Constants.LoginFailed);
                System.out.print(Constants.Again);
                is_Continues = new Process().tryAgain();
            }

        }
    }

    public static void change_pass() throws SQLException {
        boolean is_Continues = true;
        while (is_Continues) {
            System.out.print("  [-] Old password:            ");
            String oldpass = new Process().check_input_empty();
            List<User> lst = new UserBL().getAllCustomers();
            int n = 0;
            for (User user : lst) {
                if (Constants.user_temp.equalsIgnoreCase(user.getUserAcc()) && oldpass.equals(user.getUserPass())) {
                    while (true) {
                        System.out.print("  [+] New password:            ");
                        String newpass = new Process().check_input_empty();
                        System.out.print("  [+] Re-input new password:   ");
                        String newpass2 = new Process().check_input_empty();
                        if (newpass.equals(newpass2)) {
                            UserDAL.update_pass(user.getUserID(), newpass);
                            n = 1;
                            is_Continues = false;
                            break;
                        } else {
                            System.out.println(Constants.wrongnewpass);
                        }
                    }
                }
            }
            if (n == 0) {
                System.out.print(Constants.wrongoldpass);
                is_Continues = new Process().tryAgain();
            }
        }
    }

    // PROFILE
    public static void view_profile() {
        Process.clrscr();
        System.out.println(Constants.Decorate3);
        System.out.println("| My aliases, yeah I am only one             | " + Constants.id_temp);
        System.out.println("| My name is                                 | " + Constants.name_temp);
        System.out.println("| Account to log into the system             | " + Constants.user_temp);
        System.out.println("| Password to log into the system            | hmm...");
        System.out.println("| Electronic Mail, oh is Email               | " + Constants.email_temp);
        System.out.println("| The first day you cried                    | " + Constants.bd_temp);
        System.out.print("| Big hand hah                               | ");
        if (Constants.lvl_temp == 1) {
            System.out.println("Hehe, just is member no more o(*￣▽￣*)o");
        } else {
            System.out.println("Yep, I'm BOSS ( •̀ ω •́ )✧");
        }
        System.out.println("| Join into the system from                  | " + Constants.since_temp);
        System.out.println(Constants.Decorate3);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void update_profile() throws SQLException {
        Process.clrscr();
        System.out.print("  [!] New name                    : ");
        String name = new Process().check_input_empty();

        System.out.print("  [!] New email                   : ");
        String email = new Process().check_input_empty();

        System.out.print("  [!] New birthdate (yyyy-MM-dd)  : ");
        Date birthdate = new Process().check_Date();

        List<User> lst = new UserBL().getAllCustomers();
        for (User user : lst) {
            if (Constants.id_temp == user.getUserID()) {
                UserDAL.update_profile(user.getUserID(), name, email, birthdate);
            }
        }
        System.out.print(Constants.Continue);
        sc.nextLine();
    }
}