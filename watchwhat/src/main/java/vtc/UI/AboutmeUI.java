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
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", Constants.aboutme1);
        Process.AlignCenter(100, "|", "|", Constants.aboutme2);
        Process.AlignCenter(100, "|", "|", Constants.aboutme3);
        Process.AlignCenter(100, "|", "|", Constants.aboutme4);
        Process.AlignCenter(100, "|", "|", Constants.aboutme5);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", Constants.aboutme6);
        Process.AlignCenter(100, "|", "|", Constants.aboutme7);
        Process.DecorateLine(100, "+", "+");
        Aboutme.getAbout();
        Process.DecorateLine(100, "+", "+");
        out.print(Constants.Continue);
        sc.nextLine();
    }
}
