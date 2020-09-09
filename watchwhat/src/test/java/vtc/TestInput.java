// package vtc;

// import static org.junit.Assert.assertTrue;

// import org.junit.Test;

// import vtc.Utils.Process;

// public class TestInput {
//     static String msg = "input failed";

//     /* Enable Process Line 108*/
//     @Test
//     public void TestInput_Account_OK() {
//         try {
//             new Process().Authentication_Acc("testinput");
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     /* Enable Process Line 81*/
//     @Test
//     public void TestInput_Account_failed1() {
//         try {
//             new Process().Authentication_Acc(""); //input < 3 character
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
//     /* Enable Process Line 81*/
//     @Test
//     public void TestInput_Account_failed2() {
//         try {
//             new Process().Authentication_Acc("a23456789b123456789c123"); //input > 32 character
//         } catch (Exception e) {
//             assertTrue("Not ok", e.getMessage().toString().equals(msg));
//         }
//     }
// }
