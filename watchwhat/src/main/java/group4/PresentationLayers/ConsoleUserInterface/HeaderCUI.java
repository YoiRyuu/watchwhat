package group4.PresentationLayers.ConsoleUserInterface;

import group4.Utils.Constants;
import group4.Utils.Process;
import group4.Utils.TempData;

public class HeaderCUI {
    public static void headerCUI() {
        Process.clrscr();
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", Constants.Welcome1);
        Process.AlignCenter(100, "|", "|", Constants.Welcome2);
        Process.AlignCenter(100, "|", "|", Constants.showver);
        Process.DecorateLine(100, "+", "+");
        String inbox = "[ " + TempData.level_temp + " ]";
        String welcome = Constants.logString + "    " + TempData.name_temp;
        Process.AlignCenter(100, "|", "|", welcome);
        Process.DecorateLine(100, "+", "+");
        Process.AlignCenter(100, "|", "|", inbox);
        Process.DecorateLine(100, "+", "+");
    }
}
