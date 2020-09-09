package vtc.BL;

import java.util.List;

import vtc.DAL.NationDAL;
import vtc.Persistance.Nation;

public class NationBL {
    private NationDAL dal = new NationDAL();

    public List<Nation> showAllNations() {
        return dal.showNation();
    }

    
}