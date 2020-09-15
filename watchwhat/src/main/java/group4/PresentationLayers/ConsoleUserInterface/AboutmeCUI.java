package group4.PresentationLayers.ConsoleUserInterface;

import java.util.Scanner;

import group4.PresentationLayers.Aboutme;
import group4.Utils.Constants;
import group4.Utils.Process;

public class AboutmeCUI {
    static Scanner sc = new Scanner(System.in);
    /* About me - Giới thiệu phần mềm */
    public static void aboutme(){
        HeaderCUI.headerCUI();
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
        System.out.print(Constants.Continue);
        sc.nextLine();
    }
}
