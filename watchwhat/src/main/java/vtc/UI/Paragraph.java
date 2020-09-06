package vtc.UI;

import vtc.Utils.Constants;

public class Paragraph {
    public static void DecorateLine(int number) {
        System.out.printf("+%-" + number + "s+\n", Constants.line.substring(0, number));
    }

    public static void DecorateContent(String content) {
        int center = (172 - content.length()) / 2;
        System.out.printf("| %-" + center + "s %-" + content.length() + "s %-" + center + "s |\n", Constants.space,
                content, Constants.space);
    }

    public static void DecorateContent(int value, String content) {
        int center = (value - content.length()) / 2;
        System.out.printf("%-" + center + "s %-" + content.length() + "s %-" + center + "s", Constants.space,
                content, Constants.space);
    }
}
