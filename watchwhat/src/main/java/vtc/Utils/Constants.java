package vtc.Utils;

import java.sql.Date;

public class Constants {
    // temp
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
    public static int inbox_temp = 0;
    public static String ver = "0.4.6";
    public static String notepatch;
    public static int idmov_temp;

    // Decorate
    public static String Decorate   = "+--------------------------------------+";
    public static String Decorate1  = "----------------------------------------";
    public static String Decorate2  = "+--------------------------------------------+";
    public static String Decorate3  = "+--------------------------------------------+--------------------------------------------+";
    public static String Decorate4  = "+------------+---------------------------------------------+------------------------------+----------+------------------------------------------------------------------------+";
    public static String Decorate5  = "+-------+--------------------------------+----------------------------------------------------+-------------+-------------+------------+--------+--------------------------------+";
    public static String Decorate6  = "+----------------------------------------------------------+--------------------------------------------------+";

    // Welcome & Header
    public static String Welcome1               = "|    Welcome to WatchWhat application!       |";
    public static String Welcome2               = "|    PF10 - Group 4 - Author: Long & Loi     |";
    public static String Welcome3               = "|            WatchWhat application!          |";
    public static String Welcome4               = "|    PF10 - Group 4 - Author: Long & Loi     |";
    public static String showver                = "|          [ Version " + Constants.ver + " ]                 |";
    public static String headmov1               = "[   - ID -   |              - Movie's Name -               |         - Director -         | - Year - |                       - Image Cover -                                  ]";
    public static String regiHeader             = "|    New Register become to member           |";
    public static String loginHeader            = "| Login into application by member's account |";
    public static String logString              = "Welcome, ";
    public static String requestheader          = "|              REQUEST                       |";
    /* Button */
    public static String buttonback        = "| [0] Back                                   |";
    public static String buttonexit         = "| [0] Exit                                   |";
    public static String buttonlogout       = "| [0] Logout                                 |";
    public static String buttonregister     = "| [1] Register Member                        |";
    public static String buttonlogin        = "| [2] Login                                  |";
    public static String buttonabout        = "| [9] About me                               |";
    public static String button_mngmem1     = "| [1] Search member by <Name>                |";
    public static String button_mngmem2     = "| [2] Select ID's member                     |";
    public static String buttonprofile      = "| [1] Profile                                |";
    public static String buttonchangepass   = "| [2] Change password                        |";
    public static String buttonfavourite    = "| [3] Favourite List                         |";
    public static String buttonsearchmovie  = "| [4] Search and View movie                  |";
    public static String buttonsearchmovie2 = "| [4] Search, View and Update movie          |";
    public static String buttonrequest      = "| [5] Request                                |";
    public static String buttonmngrequest   = "| [5] Manage request                         |";
    public static String buttonmngmember    = "| [6] Manage members                         |";
    public static String buttonsendreq      = "| [1] Send new a request                     |";
    public static String buttonviewreq      = "| [2] View requests send                     |";
    // Warning
    public static String pleasechoiceString = " Please choose one of options above: ";
    public static String Wrongchoice        = "  [!] Please choice again!";
    public static String Continue           = "  [>] Press any key for continue... ";
    public static String ExitApp            = "  [!] Thank you for used application!";
    public static String RegisterSuccess    = "  [!] Register new Account is success!";
    public static String RegisterFailed     = "  [x] Register new Account is failed!";
    public static String ChangePassSuccess  = "\n  [!] (～￣▽￣)～ New password has change!";
    public static String ChangePassFailed   = "\n  [x] (っ °Д °;)っ Change password failed!";
    public static String ProfileSuccess     = "\n  [!] (～￣▽￣)～ New profile has change!";
    public static String ProfileFailed      = "\n  [x] (っ °Д °;)っ Change profile failed!";
    public static String movieSuccess       = "\n  [!] New info has change!";
    public static String movieFailed        = "\n  [x] Change info failed!";
    public static String LoginSuccess       = "  [!] Login successful! Welcome, ";
    public static String LoginFailed        = "  [x] Wrong username or password!";
    public static String Again              = "  [?] Do you want try again? (Y/N)...";
    public static String OnlyYesNo          = "  [!] You can only choice Y or N...";
    public static String sendRequstUser     = "  [!] Submit request successfully!!!";
    public static String choiceoption       = "  [>] Please choose one of options above: ";
    // Error
    public static String checkEmpty         = "  [!] Input is empty! Try again";
    public static String checkNumberEmpty   = "  [!] Try again! Input is Integer number > 0";
    public static String username_exist     = "  [x] Username exist, please try again!";
    public static String wrongdate          = "  [x] Date is wrong, try again... ";
    public static String wrongpass          = "  [x] Password wrong, try again... ";
    public static String wrongoldpass       = "  [?] Old Password wrong, try again? (Y/N)...";
    public static String wrongnewpass       = "  [x] hmm... something wrong for new password, try again...";
    // Input username, password
    public static String username       = "  [>] Username: ";
    public static String password       = "  [>] Password: ";
    public static String fullname       = "  [>] Fullname: ";
    public static String email          = "  [>] Email: ";
    public static String birthdate      = "  [>] Your birthday (YYYY-MM-dd): ";
    // Search
    public static String mov_name       = " [>] Movie's name: ";
    public static String mov_nation     = " [>] ID Nation: ";
    public static String mov_select     = " [>] Input ID movie to get link: ";
    public static String numbermov      = " [!] Movie had found: ";
    public static String noname         = " [x] Movie not found ";
    public static String noepisode      = " [x] Movie's episode not have ";
    public static String id_select      = "|  [>] Input ID                                            : ";
    public static String change_name    = "|  [>] Change Name to                                      : ";
    public static String change_email   = "|  [>] Change Email to                                     : ";
    public static String change_bd      = "|  [>] Change Birthday to (yyyy-MM-dd)                     : ";
    public static String change_stt     = "|  [>] Change Status to ([1] Actived or [2] Non-active)    : ";
    public static String change_lvl     = "|  [>] Change Role to ([1] Member or [2] Admin)            : ";
    // update film
    public static String changenamemov  = "[~] Change Name      : ";
    public static String changedirmov   = "[~] Change Director  : ";
    public static String changeyearmov  = "[~] Change Year      : ";
    public static String changeurlmov   = "[~] Change URL       : ";
    public static String update_mov     = "[?] Do you want movie's infomation update (Y/N): ";
    
    // infor app
    public static String aboutme1 = "| Name: WatchWhat                            |";
    public static String aboutme2 = "| Version: " + ver + "                              |";
    public static String aboutme3 = "| Creator: Phan Gia Long & Tran Dai Loi      |";
    public static String aboutme4 = "| Intructor: Vu Tran Lam                     |";
    public static String aboutme5 = "| Code by Java, 2020                         |";
}