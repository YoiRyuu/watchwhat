package vtc.Persistance;

public class Tags {
    private int tagID;
    private String tagNAME;

    public void setTagID(int id) {
        this.tagID = id;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagNAME(String name) {
        this.tagNAME = name;
    }

    public String getTagNAME() {
        return tagNAME;
    }

    @Override
    public String toString() {
        return "[" + this.tagID + "] " + this.tagNAME;
    }
}
