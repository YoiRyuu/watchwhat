package vtc.Persistance;

public class Nation {
    private int nationID;
    private String nationNAME;

    public void setNationID(int nationID) {
        this.nationID = nationID;
    }

    public int getNationID() {
        return nationID;
    }

    public void setNationNAME(String nationNAME) {
        this.nationNAME = nationNAME;
    }

    public String getNationeNAME() {
        return nationNAME;
    }

    @Override
    public String toString() {
        return "| " + this.nationID + " | " + this.nationNAME;
    }
}