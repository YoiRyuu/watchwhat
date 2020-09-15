package group4.PresentationLayers.ConsoleUserInterface;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import group4.BusinesLogicLayers.MovieBLL;
import group4.BusinesLogicLayers.ProcessInput;
import group4.Utils.Constants;
import group4.Utils.Process;
import group4.Utils.TempData;

public class ManageMoviesCUI {
    static Scanner sc = new Scanner(System.in);
    final static int ManageMoviesCUI = 3;

    public static void mngMovieHeader() {
        HeaderCUI.headerCUI();
        Process.AlignCenter(100, "|", "|", Constants.UImanagemovies);
        Process.DecorateLine(100, "+", "+");
    }

    public static void mngMovideMain() throws SQLException {
        boolean is_continue = true;
        while (is_continue) {
            mngMovieHeader();
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovname);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovdire);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovcast);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovnation);
            Process.AlignCenter(100, "|", "|", Constants.buttonsearchmovtag);
            Process.AlignCenter(100, "|", "|", Constants.buttonback);
            Process.DecorateLine(100, "+", "+");
            Process.AlignCenter(100, "!", "!", TempData.warning);
            Process.AlignCenterInput(100, Constants.pleasechoiceInt);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    MoviesCUI.searchMovieName(ManageMoviesCUI);
                    break;
                case "2":
                    MoviesCUI.searchMovieDirector(ManageMoviesCUI);
                    break;
                case "3":
                    MoviesCUI.searchMovieCast(ManageMoviesCUI);
                    break;
                case "4":
                    MoviesCUI.searchMovieNation(ManageMoviesCUI);
                    break;
                case "5":
                    MoviesCUI.searchMovieTags(ManageMoviesCUI);
                    break;
                case "0":
                    is_continue = false;
                    break;
                default:
                    TempData.warning = Constants.Wrongchoice;
                    break;
            }
        }
    }

    // For Admin
    public static void update_mov_info(int select) throws SQLException {
        Process.AlignCenter(100, "|", "|", Constants.update_informovie);
        Process.AlignCenter(100, "|", "|", Constants.update_informovie2);
        System.out.print(Constants.changenamemov);
        String name = sc.nextLine();

        System.out.print(Constants.changedirmov);
        String dir = sc.nextLine();

        System.out.print(Constants.changecastmov);
        String cast = sc.nextLine();

        System.out.print(Constants.changeyearmov);
        int year = sc.nextInt();
        sc.nextLine();

        Date predate = new ProcessInput().check_Date(ManageMoviesCUI);

        System.out.print(Constants.changeurlmov);
        String cover = sc.nextLine();

        System.out.print(Constants.changecermov);
        String certificate = sc.nextLine();

        System.out.print(Constants.changedescription);
        String Description = sc.nextLine();

        System.out.print(Constants.WantUpdate);
        int ys = new ProcessInput().Yes_No_int();
        if (ys == 0) {
            MovieBLL.checkInput(select, name, dir, cast, year, predate, cover, certificate, Description);
        }
        System.out.print(Constants.Continue);
        sc.nextLine();
    }
}
