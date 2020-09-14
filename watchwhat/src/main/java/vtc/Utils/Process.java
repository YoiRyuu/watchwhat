package vtc.Utils;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

public class Process {
    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void AlignCenter(int value, String deco, String deco2, String content) {
        int space = (value - content.length()) / 2;
        System.out.printf(deco + "%-" + space + "s%-" + (value - space * 2) + "s%-" + space + "s" + deco2 + "\n", "",
                content, "");
    }

    public static void AlignLeft(int value, String deco, String deco2, String content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignLeft(int value, String deco, String deco2, int content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignLeft(int value, String deco, String deco2, Date content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignLeft(int value, String deco, String deco2, Timestamp content) {
        System.out.printf(deco + " %-" + (value - 2) + "s " + deco2, content);
    }

    public static void AlignCenterInput(int value, String content) {
        int space = (value - content.length()) / 2;
        System.out.printf("%-" + space + "s" + "%-" + (value - space * 2) + "s", "", content);
    }

    public static void DecorateLine(int value, String deco1, String deco2) {
        String line = "";
        for (int i = 0; i < value; i++) {
            line = line + "-";
        }
        System.out.printf(deco1 + "%" + value + "s" + deco2 + "\n", line);
    }

    public static void DecorateLine2Column(int value, String deco1, String deco2, String deco3) {
        String line = "";
        int value_after = (value / 2) - 1;
        for (int i = 0; i < value_after; i++) {
            line = line + "-";
        }
        System.out.printf(deco1 + "%-" + value_after + "s" + deco2 + deco2 + "%-" + value_after + "s" + deco3 + "\n",
                line, line);
    }

    public static void resetWarning() {
        TempData.warning = Constants.warning;
    }
}
