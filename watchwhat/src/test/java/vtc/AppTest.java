package vtc;

import java.sql.Date;

import vtc.DAL.UserDAL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void voidRegister1() {
        try {
            Date db = Date.valueOf("2000-01-01");
            UserDAL.insert_mem("test1", "test1", "test1", "test1", db);
        } catch (final Exception e) {
            // TODO: handle exception
        }
    }
}
