package vtc.BusinesLogicLayers;

import java.util.List;

import vtc.DataAccessLayers.SourcesDAL;
import vtc.PresentationLayers.Sources;

public class SourcesBLL {
    private SourcesDAL dal = new SourcesDAL();

    public List<Sources> getLinkMovies(int select) {
        return dal.getSourcesByID(select);
    }
}
