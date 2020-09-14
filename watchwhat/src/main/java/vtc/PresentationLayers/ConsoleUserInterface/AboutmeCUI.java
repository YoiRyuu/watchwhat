package vtc.PresentationLayers.ConsoleUserInterface;

import java.util.Scanner;

import vtc.PresentationLayers.Aboutme;
import vtc.Utils.Constants;
import vtc.Utils.Process;

public class AboutmeCUI {

    /* About me - Giới thiệu phần mềm */
    public static void aboutme(){
        Scanner sc = new Scanner(System.in);
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
        sc.close();
    }
}
