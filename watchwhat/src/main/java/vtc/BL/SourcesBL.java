package vtc.BL;

import java.util.List;

import vtc.DAL.SourcesDAL;
import vtc.Persistance.Sources;

public class SourcesBL {
    private SourcesDAL dal2 = new SourcesDAL();
    public List<Sources> getLinkMovies(int select) {
        return dal2.getSourcesByID(select);
    }
}