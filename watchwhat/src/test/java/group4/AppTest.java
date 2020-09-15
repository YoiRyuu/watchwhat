// package group4;

// import static org.junit.Assert.assertTrue;

// import java.sql.SQLException;

// import org.junit.Test;

// import group4.BusinesLogicLayers.ProcessInput;
// import group4.BusinesLogicLayers.UserBLL;
// import group4.Utils.ConnectUtil;

// /**
//  * Unit test for simple App.
//  */
// public class AppTest {
//     /**
//      * Rigorous Test :-)
//      * 
//      * @throws SQLException
//      */
//     @Test
//     public void Connect_OK() {
//         String msg = "Test connect OK";
//         String url2 = "jdbc:mysql://localhost:3306/wwdb";
//         String user2 = "root";
//         String password2 = "123456";
//         try {
//             ConnectUtil.TestConnect(url2, user2, password2);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void Connect_fail() {
//         String msg = "Test connect failed";
//         String url2 = "jdbc:mysql://localhost:3306/wwdb";
//         String user2 = "root";
//         String password2 = "123456789"; // <- Wrong password
//         try {
//             ConnectUtil.TestConnect(url2, user2, password2);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestLogin_OK() {
//         String msg = "Login OK";
//         String userString = "testusername";
//         String passString = "testpassword";
//         try {
//             UserBLL.login_into_test(userString, passString, 1);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestLogin_failed1() {
//         String msg = "Login failed";
//         String userString = "testusername";
//         String passString = "testpassword1"; // Wrong password
//         try {
//             UserBLL.login_into_test(userString, passString, 1);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestLogin_failed2() {
//         String msg = "Login failed";
//         String userString = "testuser"; // Wrong username
//         String passString = "testpassword";
//         try {
//             UserBLL.login_into_test(userString, passString, 1);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestInputUsername_OK() {
//         String msg = "input OK";
//         String userString = "abcdefgh";
//         try {
//             new ProcessInput().checkAccTest(userString);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestInputUsername_fail1() {
//         String msg = "input failed";
//         String userString = "1testusername"; // wrong format
//         try {
//             new ProcessInput().checkAccTest(userString);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestInputUsername_fail2() {
//         String msg = "input failed";
//         String userString = "test user name"; // wrong format
//         try {
//             new ProcessInput().checkAccTest(userString);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestInputUsername_fail3() {
//         String msg = "input failed";
//         String userString = "test"; // username < 6 characters
//         try {
//             new ProcessInput().checkAccTest(userString);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestInputUsername_fail4() {
//         String msg = "input failed";
//         String userString = "test56789012345678901234567890123"; // username > 32 characters
//         try {
//             new ProcessInput().checkAccTest(userString);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }

//     @Test
//     public void TestInputPass_OK() {
//         String msg = "input OK";
//         String password = "test5678901234567890123456789012";
//         try {
//             new ProcessInput().checkPassTest(password);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputPass_failed1() {
//         String msg = "input failed";
//         String password = "test56789012345678901234567890123"; // password > 32 characters
//         try {
//             new ProcessInput().checkPassTest(password);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputPass_failed2() {
//         String msg = "input failed";
//         String password = "test5"; // password < 6 characters
//         try {
//             new ProcessInput().checkPassTest(password);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputPass_failed3() {
//         String msg = "input failed";
//         String password = "test5 6789012345678901234567890"; // username have space
//         try {
//             new ProcessInput().checkPassTest(password);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputEmail_format_OK() {
//         String msg = "input OK";
//         String email = "email@mail.com";
//         try {
//             new ProcessInput().checkEmailTest(email);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputEmail_format_failed1() {
//         String msg = "input failed";
//         String email = "email@mailcom";
//         try {
//             new ProcessInput().checkEmailTest(email);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputEmail_format_failed2() {
//         String msg = "input failed";
//         String email = "emailmail.com";
//         try {
//             new ProcessInput().checkEmailTest(email);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputEmail_format_failed3() {
//         String msg = "input failed";
//         String email = "emailmailcom";
//         try {
//             new ProcessInput().checkEmailTest(email);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     @Test
//     public void TestInputEmail_format_failed4() {
//         String msg = "input failed";
//         String email = "email@abc@mail.com";
//         try {
//             new ProcessInput().checkEmailTest(email);
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
// }
