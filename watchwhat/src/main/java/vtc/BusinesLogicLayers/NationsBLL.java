package vtc.BusinesLogicLayers;

import java.util.List;

import vtc.DataAccessLayers.NationsDAL;
import vtc.PresentationLayers.Nations;

public class NationsBLL {
    private NationsDAL dal = new NationsDAL();

    public List<Nations> showAllNations() {
        return dal.showNation();
    }
}
