package vtc.Persistance;

import java.sql.Date;

public class User {
    private int userID;
    private String userNAME;
    private String userEmail;
    private Date userBirthday;
    private Date createDate;
    private int userStt;
    private int userLvl;
    private String userACC;
    private String userPASS;
    
    public void setUserID(int userId) {
        this.userID = userId;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserStt(int userStatus) {
        this.userStt = userStatus;
    }

    public int getUserStt() {
        return userStt;
    }
    public void setUserlvl(int userlvl) {
        this.userLvl = userlvl;
    }

    public int getUserlvl() {
        return userLvl;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
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

    public void setUserName(String userName) {
        this.userNAME = userName;
    }

    public String getUserName() {
        return userNAME;
    }

    public void setBirthday(Date date) {
        this.userBirthday = date;
    }

    public Date getBirthday() {
        return userBirthday;
    }

    public void setCreateDate(Date cdate) {
        this.createDate = cdate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return this.userID + " - " + this.userACC + " - " + this.userPASS + " - " + this.userNAME;
    }
}