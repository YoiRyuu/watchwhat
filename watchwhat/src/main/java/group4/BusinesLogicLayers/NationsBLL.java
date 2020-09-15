package group4.BusinesLogicLayers;

import java.util.List;

import group4.DataAccessLayers.NationsDAL;
import group4.PresentationLayers.Nations;

public class NationsBLL {
    private NationsDAL dal = new NationsDAL();

    public List<Nations> showAllNations() {
        return dal.showNation();
    }
}
