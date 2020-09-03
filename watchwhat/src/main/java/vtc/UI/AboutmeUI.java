package vtc.UI;

import static java.lang.System.out;

import java.sql.SQLException;
import java.util.Scanner;

import vtc.Persistance.Aboutme;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class AboutmeUI {
    static Scanner sc = new Scanner(System.in);

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
