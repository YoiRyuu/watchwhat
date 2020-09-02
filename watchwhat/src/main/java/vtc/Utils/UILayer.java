package vtc.Utils;

import static java.lang.System.out;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import vtc.BL.MovieBL;
import vtc.BL.NationBL;
import vtc.BL.RequestBL;
import vtc.BL.SourcesBL;
import vtc.BL.UserBL;
import vtc.DAL.RequestDAL;
import vtc.Persistance.Movie;
import vtc.Persistance.Nation;
import vtc.Persistance.Sources;

public class UILayer {
    static Scanner sc = new Scanner(System.in);

    // Header Constanst
    public static void headerUI() {
        Process.clrscr();
        out.println(Constants.Decorate2);
        out.println(Constants.Welcome1);
        out.println(Constants.Welcome2);
        out.println(Constants.showver);
        out.println(Constants.Decorate2);
    }

    public static void welcomeUI() throws SQLException, ParseException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            out.println(Constants.UIwelcome);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonregister);
            out.println(Constants.buttonlogin);
            out.println(Constants.buttonabout);
            out.println(Constants.buttonexit);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    registerUI();
                    break;
                case "2":
                    memberloginUI();
                    break;
                case "3":
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

    // Use case register
    public static void registerUI() throws SQLException, ParseException {
        headerUI();
        out.println(Constants.UIregister);
        out.println(Constants.Decorate2);
        String userString, passString, nameString, emailString;
        /* Check username exist */
        System.out.println(Constants.username);
        userString = new Process().checkAcc();

        System.out.print(Constants.password);
        passString = new Process().check_string_empty();

        System.out.print(Constants.fullname);
        nameString = sc.nextLine();

        System.out.print(Constants.email);
        emailString = new Process().check_string_empty();

        Date birthdate = new Process().check_Date(Constants.birthdate);
        UserBL.regiter_member(userString, passString, nameString, emailString, birthdate);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    // Use case login
    public static void memberloginUI() throws SQLException {
        headerUI();
        out.println(Constants.UIlogin);
        out.println(Constants.Decorate2);
        while (true) {
            System.out.print(Constants.username);
            String userString = new Process().check_string_empty();
            System.out.print(Constants.password);
            String passString = new Process().check_string_empty();
            if (UserBL.login_into(userString, passString) == 1) {
                break;
            } else {
                continue;
            }
        }
    }

    public static void login_success() {
        out.printf("| " + Constants.logString + "[ %-29s ] |", Constants.name_temp);
        out.println();
        out.println(Constants.Decorate2);
        out.print("| [ " + Constants.namelever + " ]    ");
        if (Constants.lvl_temp == 1) {
            System.out.println("                       |");
        } else {
            System.out.println("   [ New request: " + Constants.inbox_temp + " ]  |");
        }
        out.println(Constants.Decorate2);
    }

    public static void memberloginUI_success() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            login_success();
            out.println(Constants.UImenu);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonprofile);
            out.println(Constants.buttonchangepass);
            out.println(Constants.buttonfavourite);
            if (Constants.lvl_temp == 1) {
                out.println(Constants.buttonsearchmovie);
                out.println(Constants.buttonrequest);
            }

            if (Constants.lvl_temp > 1) {
                out.println(Constants.buttonsearchmovie2);
                out.println(Constants.buttonmngrequest);
                out.println(Constants.buttonmngmember);
            }
            out.println(Constants.buttonlogout);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    profileUI();
                    break;
                case "2":
                    changepasswordUI();
                    break;
                case "3":
                    favourite_main();
                    break;
                case "4":
                    movieUI();
                    break;
                case "5":
                    if (Constants.lvl_temp == 1) {
                        requestUI();
                        ;
                    }
                    if (Constants.lvl_temp > 1) {
                        manageRequestUI();
                    }
                    break;
                case "6":
                    if (Constants.lvl_temp == 1) {
                        out.println(Constants.Wrongchoice);
                    }
                    if (Constants.lvl_temp > 1) {
                        Manage_memberUI();
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

    // Use case profile
    public static void profileUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            login_success();
            out.println(Constants.UIprofile);
            out.println(Constants.Decorate2);
            out.println(Constants.buttonviewpro);
            out.println(Constants.buttonupdatepro);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    view_profileUI();
                    break;
                case "2":
                    update_profileUI();
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

    public static void view_profileUI() {
        Process.clrscr();
        System.out.println(Constants.UIviewprofile);
        System.out.println(Constants.Decorate3);
        System.out.println(Constants.profileinfo1 + Constants.id_temp);
        System.out.println(Constants.profileinfo2 + Constants.name_temp);
        System.out.println(Constants.profileinfo3 + Constants.user_temp);
        System.out.println(Constants.profileinfo4);
        System.out.println(Constants.profileinfo5 + Constants.email_temp);
        System.out.println(Constants.profileinfo6 + Constants.bd_temp);
        System.out.print(Constants.profileinfo7);
        if (Constants.lvl_temp == 1) {
            System.out.println(Constants.profileinfo7_1);
        } else {
            System.out.println(Constants.profileinfo7_2);
        }
        System.out.println(Constants.profileinfo8 + Constants.since_temp);
        System.out.println(Constants.Decorate3);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void update_profileUI() throws SQLException {
        Process.clrscr();
        System.out.println(Constants.UIupdateprofile);
        System.out.println(Constants.Decorate2);
        System.out.print(Constants.newname);
        String name = new Process().check_string_empty();
        System.out.print(Constants.newemail);
        String email = new Process().check_string_empty();
        Date birthdate = new Process().check_Date(Constants.newbirthdate);
        UserBL.update_profile(name, email, birthdate);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    // Use case change password
    public static void changepasswordUI() throws SQLException {
        headerUI();
        login_success();
        System.out.println(Constants.UIchangepassword);
        System.out.println(Constants.Decorate2);
        while (true) {
            System.out.print(Constants.oldpassString);
            String oldpass = new Process().check_string_empty();
            if (UserBL.change_pass(oldpass) == 1) {
                break;
            } else {
                continue;
            }
        }
        out.println(Constants.Decorate2);
        out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void input_newpass() {
        while (true) {
            System.out.print(Constants.newpassString);
            String newpass = new Process().check_string_empty();
            System.out.print(Constants.repassString);
            String newpass2 = new Process().check_string_empty();
            if (newpass.equals(newpass2)) {
                Constants.pass_temp = newpass;
                break;
            } else {
                System.out.println(Constants.wrongnewpass);
            }
        }
    }

    // Use case favourite
    public static void favourite_main() throws SQLException {
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
                    favourite_view();
                    break;
                case "2":
                    favourite_update(Constants.id_temp);
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
    }

    public static void favourite_update(int ctm) throws SQLException {
        headerUI();
        login_success();
        out.print("| [1] Remove ID movie: ");
        int mov = new Process().check_number_empty();
        MovieBL.removefavou(ctm, mov);
    }

    // Use case Search & View Movie
    public static void movieUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            login_success();
            System.out.println(Constants.UImovie);
            out.println(Constants.buttonsearchmovname);
            out.println(Constants.buttonsearchmovnation);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    searchMovieName();
                    break;
                case "2":
                    searchMovieNation();
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

    public static void searchMovieName() throws SQLException {
        Process.clrscr();
        System.out.print(Constants.mov_name);
        String movname = new Process().check_string_empty();
        MovieBL.searchMovieName(movname);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void searchMovieNation() throws SQLException {
        Process.clrscr();
        List<Nation> lst = new NationBL().showAllNations();
        for (Nation nation : lst) {
            System.out.println(nation);
        }
        System.out.print(Constants.mov_nation);
        int id = sc.nextInt();
        sc.nextLine();
        MovieBL.searchMovieNation(id);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void show_mov_info(Movie mov) {
        String a = "" + mov.getMovieID();
        String b = mov.getMovieNAME();
        String c = mov.getMovieDIC();
        String d = "" + mov.getMovieYEAR();
        String e = mov.getmovieCOVER();
        System.out.printf("[ %-10s | %-43s | %-28s | %-8s | %-70s ]\n", a, b, c, d, e);
        System.out.println(Constants.Decorate4);
    }

    public static void show_mov_list(List<Movie> lst) throws SQLException {
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
            if (lst2.size() == 0) {
                System.out.println(Constants.noepisode);
            }
            if (Constants.lvl_temp > 1) {
                MovieBL.update_mov_info(select);
            }
        }
        if (n == 0) {
            System.out.println(Constants.noname);
            System.out.println(Constants.Decorate4);
        }
    }

    /* Use case request */
    public static void requestUI() throws SQLException {
        Boolean is_continue = true;
        while (is_continue) {
            Process.clrscr();
            System.out.println(Constants.Decorate2);
            System.out.println(Constants.UIrequest);
            System.out.println(Constants.Decorate2);
            System.out.println(Constants.buttonsendreq);
            System.out.println(Constants.buttonviewreq);
            System.out.println(Constants.buttonback);
            System.out.println(Constants.Decorate2);
            System.out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            System.out.println(Constants.Decorate1);
            switch (choice) {
                case "1":
                    sendRequestUI();
                    break;
                case "2":
                    viewRequestSentUI();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    System.out.print("You choose wrong! Reselect: ");
                    break;
            }
        }
    }

    public static void sendRequestUI() {
        Process.clrscr();
        System.out.println(Constants.Decorate1);
        System.out.print("+ Enter the text you need to send: ");
        String Content = sc.nextLine();
        RequestBL.SendReqUI1(Content);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void viewRequestSentUI() throws SQLException {
        Process.clrscr();
        System.out.println(Constants.Decorate1);
        System.out.println("|               News sent              |");
        System.out.println(Constants.Decorate1);
        System.out.println(Constants.Decorate7);
        System.out.printf("| %-50s | %-10s | %-50s |\n", "Request", "Process", "Answer");
        System.out.println(Constants.Decorate7);
        RequestBL.viewUI1();
        System.out.println(Constants.Decorate7);
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void ShowContentRequest(String request, String xuly, String answer) {
        System.out.printf("| %-50s | %-10s | %-50s |\n", request, xuly, answer);
    }

    /* Use case Manage request */
    public static void manageRequestUI() throws SQLException {
        Boolean is_continue = true;
        while (is_continue) {
            Process.clrscr();
            System.out.println(Constants.Decorate);
            System.out.println("|          REQUEST ADMIN               |");
            System.out.println(Constants.Decorate);
            System.out.println("| 1. See incoming mail                 |");
            System.out.println("| 2. Reply to the request              |");
            System.out.println("| 0. Exit                              |");
            System.out.println(Constants.Decorate);
            System.out.print(" Please choose one of options above: ");
            String choice = sc.nextLine();
            System.out.println(Constants.Decorate1);
            switch (choice) {
                case "1":
                    ViewMailUI();
                    break;
                case "2":
                    ReplyUI();
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    System.out.print("You choose wrong! Reselect: ");
                    break;
            }
        }
    }

    public static void ViewMailUI() throws SQLException {
        Process.clrscr();
        System.out.println(Constants.Decorate1);
        System.out.println("Request sent");
        System.out.println(Constants.Decorate1);
        System.out.printf("| %-30s | %-10s | %-30s | %-15s |\n", "Name", "User ID", "Request", "Process");
        System.out.println(Constants.Decorate1);
        RequestBL.SeeReqUI2();
        System.out.println(Constants.Decorate1);
        System.out.print("Press enter to exit........");
        sc.nextLine();
    }

    public static void ContentMail(String name, String request, int id, String xuly) {
        System.out.printf("| %-30s | %-10s | %-30s | %-15s |\n", name, id, request, xuly);
    }

    public static void ReplyUI() throws SQLException {
        System.out.println(Constants.Decorate1);
        System.out.println("Request sent");
        System.out.println(Constants.Decorate1);
        RequestDAL.ListReqNoReply();
        System.out.println(Constants.Decorate1);
        System.out.print("Import ID_req want to reply: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your reply: ");
        String content = sc.nextLine();
        RequestBL.Reply(id, content);
        System.out.print("Press enter to exit........");
        sc.nextLine();
    }

    public static void ContentMail2(int id, String request, int UserID) {
        System.out.printf("[ Id_req: %-5s ] [ %-50s ] [ User ID: %-5s]\n", id, request, UserID);
    }

    /* Use case Manage Members - Quản lý thành viên */
    public static void Manage_memberUI() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            headerUI();
            login_success();
            out.println(Constants.UImanagemember);
            out.println(Constants.Decorate2);
            out.println(Constants.button_mngmem1);
            out.println(Constants.button_mngmem2);
            out.println(Constants.buttonback);
            out.println(Constants.Decorate2);
            out.print(Constants.pleasechoiceString);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    search_member_bynameUI();
                    break;
                case "2":
                    select_member_byidUI();
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

    public static void search_member_bynameUI() throws SQLException {
        System.out.print(Constants.username);
        String name = new Process().check_string_empty();
        UserBL.search_byname(name);
    }

    public static void select_member_byidUI() throws SQLException {
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.id_select);
        int id = new Process().check_number_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_name);
        String name = new Process().check_string_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_email);
        String email = new Process().check_string_empty();
        System.out.println(Constants.Decorate6);
        Date bd = new Process().check_Date(Constants.change_bd);
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_stt);
        int stt = new Process().check_number_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.change_lvl);
        int lvl = new Process().check_number_empty();
        System.out.println(Constants.Decorate6);
        System.out.print(Constants.WantUpdate);
        int key = new Process().Yes_No_int();
        if (key == 0) {
            UserBL.Update_byID(id, name, email, bd, stt, lvl);
        }
        System.out.print(Constants.Continue);
        sc.nextLine();
    }

    public static void show_mem_byname(CallableStatement call) throws SQLException {
        ResultSet rs = call.executeQuery();
        int count = 0;
        out.println(Constants.Decorate5);
        out.println(
                "| ID    | Name     -         -         - | Email     -         -         -         -          | Birthday    | Since       | Status     | Role   | Account   -         -          |");
        String stt = null, role = null;
        out.println(Constants.Decorate5);
        while (rs.next()) {
            if (rs.getInt(6) == 1) {
                stt = "Actived   ";
            } else {
                stt = "non-Active";
            }
            if (rs.getInt(7) == 1) {
                role = "Member";
            } else {
                role = "Admin ";
            }
            out.printf("| %-5s | %-30s | %-50s | %-11s | %-11s | %-6s | %-6s | %-30s |\n", rs.getInt(1),
                    rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), stt, role, rs.getString(8));
            out.println(Constants.Decorate5);
            count++;
        }
        out.println("  [!] " + count + " member(s) to found");
        if (count > 0) {
            select_member_byidUI();
        } else {
            System.out.print(Constants.Continue);
            sc.nextLine();
        }
    }

    /* About me - Giới thiệu phần mềm */
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
