// package vtc;

// import static org.junit.Assert.assertTrue;

// import java.sql.Date;
// import java.sql.SQLException;

// import org.junit.Assert;
// import org.junit.Test;

// import vtc.DAL.UserDAL;
// import vtc.Utils.Constants;

// public class TestRegister {
//     @Test
//     public void Register_OK() throws SQLException {
//         try {
//             String testuser = "admin1";
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = "testemail";
//             Date testbd = Date.valueOf("2000-01-01");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//             Assert.assertEquals(Constants.RegisterSuccess, Constants.RegisterSuccess);
//         } catch (Exception e) {
//             // Assert.assertEquals(Constants.RegisterFailed, Constants.RegisterFailed);
//         }
//     }

//     @Test
//     public void Register_fail1() {
//         try {
//             String testuser = "admin1";
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = "testemail";
//             Date testbd = Date.valueOf("2000");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//         } catch (Exception e) {
//             Assert.assertEquals(Constants.RegisterFailed, Constants.RegisterFailed);
//         }
//     }
//     @Test
//     public void Register_fail2() {
//         try {
//             String testuser = null;
//             String testpass = "testpass";
//             String testname = "testname";
//             String testemail = "testemail";
//             Date testbd = Date.valueOf("2000-01-01");
//             UserDAL.insert_mem(testuser, testpass, testname, testemail, testbd);
//             // Assert.assertEquals(Constants.RegisterFailed,);
//         } catch (Exception e) {
//             Assert.assertEquals(Constants.RegisterFailed, Constants.RegisterFailed);
//         }
//     }
// }
