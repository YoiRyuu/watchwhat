package vtc.Utils;

import static java.lang.System.out;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import vtc.BL.MovieBL;
import vtc.BL.RequestBL;
import vtc.BL.SourcesBL;
import vtc.BL.UserBL;
import vtc.Persistance.Movie;
import vtc.Persistance.Sources;

public class UILayer {
    static Scanner sc = new Scanner(System.in);

    public static void headerUI() {
        Process.clrscr();
        out.println(Constants.Decorate);
        out.println(Constants.Welcome1);
        out.println(Constants.Welcome2);
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
        out.print("| [ " + Constants.namelever + " ]    ");
        if (Constants.lvl_temp==1) {
            System.out.println("                       |");
        } else {
            System.out.println("   [ New request: " + Constants.inbox_temp + " ]  |");
        }
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
            if (Constants.lvl_temp == 1) {
                out.println("| [4] Search and View movie                  |");
                out.println("| [5] Request                                |");
            }

            if (Constants.lvl_temp > 1) {
                out.println("| [4] Search, View and Update movie          |");
                out.println("| ------- Control Panel for Admin ---------- |");
                out.println("| [5] Manage request                         |");
                out.println("| [6] Manage members                         |");
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
                        RequestBL.ViewReqUser();
                    }
                    if (Constants.lvl_temp > 1) {
                        RequestBL.ViewAdmin();
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

    public static void movieUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerLongUI();
            login_success();
            out.println("| [1] Search movie by name                   |");
            out.println("| [2] Search movie by nation                 |");
            out.println("| [0] Back                                   |");
            out.println(Constants.Decorate2);
            out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    MovieBL.searchMovieName();
                    break;
                case "2":
                    MovieBL.searchMovieNation();
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

    public static void show_mov_info(Movie mov) {
        String a = "" + mov.getMovieID();
        String b = mov.getMovieNAME();
        String c = mov.getMovieDIC();
        String d = "" + mov.getMovieYEAR();
        String e = mov.getmovieCOVER();
        System.out.printf("[ %-10s | %-43s | %-28s | %-8s | %-70s ]\n", a,b,c,d,e);
        System.out.println(Constants.Decorate4);
    }
    public static void show_mov_info2(List<Movie> lst) throws SQLException {
        int n = 0;
        System.out.println(Constants.Decorate4);
        System.out.println(Constants.headmov1);
        System.out.println(Constants.Decorate4);
        for (Movie mov : lst) {
            UILayer.show_mov_info(mov);
            n++;
        }
        if (n > 0) {
            System.out.println(Constants.numbermov + n);
            System.out.print(Constants.mov_select);
            int select = new Process().check_number_empty();
            List<Sources> lst2 = new SourcesBL().getLinkMovies(select);
            for (Sources sources : lst2) {
                System.out.println(sources);
            }
            if (lst2.size()==0) {
                System.out.println(Constants.noepisode);
            }
            if (Constants.lvl_temp>1) {
                MovieBL.update_mov_info(select);
            }
            System.out.print(Constants.Continue);
            sc.nextLine();
        }
        if (n == 0) {
            System.out.println(Constants.noname);
            System.out.println(Constants.Decorate4);
            System.out.print(Constants.Continue);
            sc.nextLine();
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
