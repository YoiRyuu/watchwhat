package group4.BusinesLogicLayers;

import java.util.List;

import group4.DataAccessLayers.SourcesDAL;
import group4.PresentationLayers.Sources;

public class SourcesBLL {
    private SourcesDAL dal = new SourcesDAL();

    public List<Sources> getLinkMovies(int select) {
        return dal.getSourcesByID(select);
    }
}
