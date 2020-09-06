package vtc.UI;

import static java.lang.System.out;

import vtc.Utils.Constants;
import vtc.Utils.Process;

public class HeaderUI {
    public static void headerUI() {
        Process.clrscr();
        out.println(Constants.Decorate2);
        out.println(Constants.Welcome1);
        out.println(Constants.Welcome2);
        out.println(Constants.showver);
        out.println(Constants.Decorate2);
        // Process.DecorateLine(100);
        // Process.DecorateContent(Constants.Welcome1);
        // Process.DecorateContent(Constants.Welcome2);
        // Process.DecorateContent(Constants.showver);
        // Process.DecorateLine(100);
    }

    public static void login_success() {
        String inbox = "[ New Inbox:   " + Constants.inbox_temp + " ]";
        out.printf("[ " + Constants.logString + "%-33s ]\n", Constants.name_temp);
        out.println(Constants.Decorate2);
        out.print("| [ " + Constants.namelever + " ]    ");
        System.out.printf("%-22s |\n", inbox);
        out.println(Constants.Decorate2);
    }
}
