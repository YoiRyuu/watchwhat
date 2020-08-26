package vtc.Persistance;

public class Request {
    private int req_ID;
    private String req_Content;
    private int req_status;
    private int userID;
    private String ASN;

    public void setReqID(int req_ID) {
        this.req_ID = req_ID;
    }
    public int getReqID() {
        return req_ID;
    }

    public void setReqContent(String req_Content) {
        this.req_Content = req_Content;
    }
    public String getReqContent() {
        return req_Content;
    }

    public void setReqStatus(int req_status) {
        this.req_status = req_status;
    }
    public int getReqStatus() {
        return req_status;
    }

    public void setUserID(int userId) {
        this.userID = userId;
    }
    public int getUserID() {
        return userID;
    }

    public void setReqASN(String ASN) {
        this.ASN = ASN;
    }
    public String getReqASN() {
        return ASN;
    }

    @Override
    public String toString() {
        return this.req_Content + "_" + this.req_status + "_" + this.userID;
    }
}