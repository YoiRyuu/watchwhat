package vtc;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestConnect {
    @Test
    public void Connect_OK(){
        String msg = "Test connect OK";
        try {
            String[] a = new String[10];
            App.main(a);
        } catch (Exception e) {
            assertTrue("Not ok", e.getMessage().toString().equals(msg));
        }
    }

    @Test
    public void Connect_fail(){
        //change password to wrong password
        String msg = "Test connect failed";
        try {
            String[] a = new String[10];
            App.main(a);
        } catch (Exception e) {
            assertTrue("Not ok", e.getMessage().toString().equals(msg));
        }
    }
}