package vtc.Utils;

import static java.lang.System.out;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import vtc.BL.MovieBL;
import vtc.BL.UserBL;

public class UILayer {
    static Scanner sc = new Scanner(System.in);

    public static void headerUI() {
        Process.clrscr();
        out.println(Constants.Decorate);
        out.println("| Welcome to WatchWhat application!    |");
        out.println("|          [ Version " + Constants.ver + " ]           |");
        out.println(Constants.Decorate);
    }

    public static void headerLongUI() {
        Process.clrscr();
        out.println(Constants.Decorate2);
        out.println("|            WatchWhat application!          |");
        out.println("|             [ Version " + Constants.ver + " ]              |");
        out.println(Constants.Decorate2);
    }

    public static void login_success() {
        out.println(Constants.Decorate2);
        out.println("  " + Constants.LoginSuccess + "[ " + Constants.name_temp + " ]");
        out.println(Constants.Decorate2);
        out.println("| [ " + Constants.namelever + " ]    [ Since: " + Constants.since_temp + " ] |");
        out.println(Constants.Decorate2);
    }

    public static void welcome() throws SQLException, ParseException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            out.println("| [1] Register Member                  |");
            out.println("| [2] Login                            |");
            out.println("| [9] About me                         |");
            out.println("| [0] Exit                             |");
            out.println(Constants.Decorate);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    registerUI();
                    break;
                case "2":
                    memberloginUI();
                    break;
                case "9":
                    aboutme();
                    break;
                case "0":
                    out.println(Constants.ExitApp);
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void registerUI() throws SQLException, ParseException {
        headerUI();
        out.println("| New Register become to member        |");
        out.println(Constants.Decorate);
        UserBL.regiter_member();
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void memberloginUI() throws SQLException {
        headerLongUI();
        out.println("| Login into application by member's account |");
        out.println(Constants.Decorate2);
        UserBL.login_into();
    }

    public static void memberloginUI2() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerLongUI();
            login_success();
            out.println("| [1] Profile                                |");
            out.println("| [2] Change password                        |");
            out.println("| [3] Favourite List                         |");
            out.println("| [4] Search and View movie                  |");
            if (Constants.lvl_temp == 1) {
                out.println("| [5] Request                                |");
            }

            if (Constants.lvl_temp > 1) {
                out.println("| ------- Control Panel for Admin ---------- |");
                out.println("| [5] Manage request                         |");
                out.println("| [6] Manage members                         |");
                out.println("| [7] Manage movies                          |");
            }
            out.println("| [0] Logout                                 |");
            out.println(Constants.Decorate2);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    profileUI();
                    break;
                case "2":
                    changepassword();
                    break;
                case "3":
                    favourite_main();
                    break;
                case "4":
                    movieUI();
                    break;
                case "5":
                    if (Constants.lvl_temp == 1) {
                        System.out.println("Request for member");
                    }
                    if (Constants.lvl_temp > 1) {
                        System.out.println("Request for admin");
                    }
                    break;
                case "6":
                    if (Constants.lvl_temp == 1) {
                        out.println(Constants.Wrongchoice);
                    }
                    if (Constants.lvl_temp > 1) {
                        System.out.println("M-mem");
                    }
                    break;
                case "7":
                    if (Constants.lvl_temp == 1) {
                        out.println(Constants.Wrongchoice);
                    }
                    if (Constants.lvl_temp > 1) {
                        System.out.println("M-movie");
                    }
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void choice4() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            login_success();
            out.println("| [1] Send new a request                     |");
            out.println("| [2] View requests send                     |");
            out.println("| [0] Back                                   |");
            out.println(Constants.Decorate2);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Update ^^");
                    break;
                case "2":
                    System.out.println("Change pass ^^");
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void favourite_main() {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            login_success();
            out.println("| [1] View Favourite list                    |");
            out.println("| [2] Update Favourite list                  |");
            out.println("| [0] Back                                   |");
            out.println(Constants.Decorate2);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Update ^^");
                    break;
                case "2":
                    System.out.println("Change pass ^^");
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void favourite_view() {
        headerUI();
        login_success();
        out.println("| [1] View Favourite list                    |");
        out.println("| [2] Update Favourite list                  |");
        out.println("| [0] Back                                   |");
        out.println(Constants.Decorate2);
        out.print(Constants.choiceoption);
        sc.nextLine();
    }

    public static void favourite_update() {
        headerUI();
        login_success();
        out.println("| [1] View Favourite list                    |");
        out.println("| [2] Update Favourite list                  |");
        out.println("| [0] Back                                   |");
        out.println(Constants.Decorate2);
        out.print(Constants.choiceoption);
        sc.nextLine();
    }

    public static void changepassword() throws SQLException {
        headerLongUI();
        login_success();
        UserBL.change_pass();
        out.println(Constants.Decorate2);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void profileUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerLongUI();
            login_success();
            out.println("| [1] View profile                           |");
            out.println("| [2] Update Profile                         |");
            out.println("| [0] Back                                   |");
            out.println(Constants.Decorate2);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    view_profile();
                    break;
                case "2":
                    UserBL.update_profile();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

    public static void movieUI() {
        boolean is_continue = true;
        while (is_continue) {
            headerLongUI();
            login_success();
            out.println("| [1] Search movie by name                   |");
            out.println("| [2] Search movie by nation                 |");
            out.println("| [3] Search movie by tag                    |");
            out.println("| [0] Back                                   |");
            out.println(Constants.Decorate2);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    MovieBL.searchMovieBL();
                    break;
                case "2":
                    System.out.println("Name");
                    break;
                case "3":
                    System.out.println("Name");
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    out.println(Constants.Wrongchoice);
                    break;
            }
        }
    }

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

    public static void aboutme() throws SQLException {
        Process.clrscr();
        out.println(Constants.Decorate2);
        out.println(Constants.aboutme1);
        out.println(Constants.aboutme2);
        out.println(Constants.aboutme3);
        out.println(Constants.aboutme4);
        out.println(Constants.aboutme5);
        out.println(Constants.Decorate2);
        Aboutme.getAbout();
        out.println(Constants.Decorate2);
        out.print(Constants.Continue);
        sc.nextLine();
    }

}
