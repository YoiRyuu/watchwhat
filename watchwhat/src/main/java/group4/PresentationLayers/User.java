package group4.PresentationLayers;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private int userID;
    private String userACC;
    private String userPASS;
    private int userStt;
    private Timestamp createDate;
    private Date userBirthday;
    private String userEmail;
    private String userNAME;

    public void setUserID(int userId) {
        this.userID = userId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserAcc(String userAcc) {
        this.userACC = userAcc;
    }

    public String getUserAcc() {
        return userACC;
    }

    public void setUserPass(String userPass) {
        this.userPASS = userPass;
    }

    public String getUserPass() {
        return userPASS;
    }

    public void setUserStt(int userStatus) {
        this.userStt = userStatus;
    }

    public int getUserStt() {
        return userStt;
    }

    public void setCreateDate(Timestamp cdate) {
        this.createDate = cdate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setBirthday(Date date) {
        this.userBirthday = date;
    }

    public Date getBirthday() {
        return userBirthday;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserName(String userName) {
        this.userNAME = userName;
    }

    public String getUserName() {
        return userNAME;
    }
}
