package vtc.Utils;

import java.sql.Date;

public class Constants {
    public static String Decorate = "+--------------------------------------+";
    public static String Decorate1 = "----------------------------------------";
    public static String Decorate2 = "+--------------------------------------------+";
    public static String Decorate3 = "+--------------------------------------------+--------------------------------------------+";
    public static String Decorate4 = "+------------+---------------------------------------------+------------------------------+----------+------------------------------------------------------------------------+";
    public static String InputTo = "=> ";
    public static String Wrongchoice = "Please choice again!";
    public static String Continue = " Press any key for continue... ";
    public static String ExitApp = "Thank you for used application!";
    public static String RegisterSuccess = "Register new Account is success!";
    public static String RegisterFailed = "Register new Account is failed!";
    public static String ChangePassSuccess = "\n  (～￣▽￣)～ New password has change!";
    public static String ChangePassFailed = "\n (っ °Д °;)っ Change password failed!";
    public static String ProfileSuccess = "\n  (～￣▽￣)～ New profile has change!";
    public static String ProfileFailed = "\n Change profile failed! o(TヘTo)";
    public static String movieSuccess = "\n  (～￣▽￣)～ New info has change!";
    public static String movieFailed = "\n Change info failed! o(TヘTo)";
    public static String LoginSuccess = "Login success! Welcome, ";
    public static String LoginFailed = "Wrong username or password!";
    public static String Again = "Do you want try again? (Y/N)...";
    public static String OnlyYesNo = "You can only choice Y or N...";
    public static String choiceoption = " Please choose one of options above: ";

    // Input username, password
    public static String username = "  [-] Username: ";
    public static String password = "  [-] Password: ";
    public static String fullname = "  [-] Fullname: ";
    public static String email = "  [-] Email: ";
    public static String birthdate = "  [-] Your birthday (YYYY-MM-dd): ";
    // Search Movie
    public static String mov_name = " [+] Movie's name: ";
    public static String mov_nation = " [+] ID Nation: ";
    public static String mov_select = " [+] Input ID movie to get link: ";
    public static String numbermov = " [!] Movie had found: ";
    public static String noname = " [x] Movie not found ";
    public static String noepisode = " [x] Movie's episode not have ";
    public static String headmov1 = "[   - ID -   |              - Movie's Name -               |         - Director -         | - Year - |                       - Image Cover -                                  ]";
    // update film
    public static String update_mov = " [V] Do you want movie's infomation update (Y/N): ";
    // Movie info temp
    public static int idmov_temp;
    // Error
    public static String checkEmpty = "Input is empty! Try again";
    public static String username_exist = "Username exist, please try again!";
    public static String wrongdate = "Date is wrong, try again...";
    public static String wrongpass = "Password wrong, try again...";
    public static String wrongoldpass = "Old Password wrong, try again? (Y/N)...";
    public static String wrongnewpass = "hmm... something wrong for new password, try again...";

    // mem infor temp
    public static int id_temp;
    public static String name_temp;
    public static String email_temp;
    public static Date bd_temp;
    public static Date since_temp;
    public static int stt_temp = 0;
    public static int lvl_temp = 0;
    public static String namelever = null;
    public static String user_temp;
    public static String pass_temp;

    // infor app
    public static String ver;
    public static String aboutme1 = "| Name: WatchWhat                            |";
    public static String aboutme2 = "| Version: " + ver + "                              |";
    public static String aboutme3 = "| Creator: Phan Gia Long & Tran Dai Loi      |";
    public static String aboutme4 = "| Intructor: Vu Tran Lam                     |";
    public static String aboutme5 = "| Code by Java, 2020                         |";
    public static String notepatch;

    public static String sendRequstUser = "Submit request successfully!!!";
}