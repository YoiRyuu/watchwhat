// package vtc;

// import static org.junit.Assert.assertTrue;

// import java.sql.Date;
// import java.sql.SQLException;

// import org.junit.Test;

// import vtc.DAL.UserDAL;

// public class TestRegister {
//     /* Enable UserDAL Line 65 & Line 68*/

//     static String msg = "insert failed";

//     @Test
//     public void Register_OK() throws SQLException {
//         try {
//             String testuser = "admin1";
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = "testemail@test.com";
//             Date testbd = Date.valueOf("2000-01-01");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//         } catch (SQLException e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void Register_fail1() {
//         try {
//             String testuser = "admin1";
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = "testemail@test.com";
//             Date testbd = null; // <- Wrong Format Date
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//         } catch (SQLException e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void Register_fail2() {
//         try {
//             String testuser = null;
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = "testemail@test.com";
//             Date testbd = Date.valueOf("2000-01-01");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//         } catch (SQLException e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void Register_fail3() {
//         try {
//             String testuser = "admin1";
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = null; // <- Wrong format
//             Date testbd = Date.valueOf("2000-01-01");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//         } catch (SQLException e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void Register_fail4() {
//         try {
//             String testuser = "admin1";
//             String testpass = null; // <- Wrong format
//             String testname = "testname";
//             String testemail = "testemail@test.com";
//             Date testbd = Date.valueOf("2000-01-01");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//         } catch (SQLException e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
// }
