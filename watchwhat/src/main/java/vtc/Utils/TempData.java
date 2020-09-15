package vtc.Utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TempData {
    public static String ver = "0.6.1";
    public static String warning = "~d(^.^)b~";

    public static int id_temp;
    public static String name_temp = "Guest";
    public static String name_temp2 = "";
    public static String email_temp = "";
    public static Date bd_temp = Date.valueOf("2000-1-1");
    public static int stt_temp = 0;
    public static String user_temp = "";
    public static String pass_temp = "";
    public static String level_temp = "";
    public static Timestamp since_temp = Timestamp.valueOf("2019-01-01 00:00:00");
    public static String pass_masking = "";
    public static int inbox_temp = 0;

    public static String oldpass = "";
    public static String newname = " ";
    public static String newemail = " ";
    public static Date newbd;

    public static String notepatch;
    

    public static List<Integer> listmovies = new ArrayList<>();
    public static List<Integer> listnations = new ArrayList<>();
}
