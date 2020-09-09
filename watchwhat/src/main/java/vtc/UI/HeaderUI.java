package vtc.UI;

import vtc.Utils.Constants;
import vtc.Utils.Process;

public class HeaderUI {
    public static void headerUI() {
        Process.clrscr();
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", Constants.Welcome1);
        Process.AlignCenter(100, "|", "|", Constants.Welcome2);
        Process.AlignCenter(100, "|", "|", Constants.showver);
        Process.DecorateLine(100, "+", "+");
    }

    public static void login_success() {
        String inbox = "[ " + Constants.namelever + " ] [ New Inbox:   " + Constants.inbox_temp + " ]";
        String welcome = Constants.logString + "    " + Constants.name_temp;
        Process.AlignCenter(100, "|", "|", welcome);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", inbox);
        Process.DecorateLine(100, "+", "+");
    }
}
