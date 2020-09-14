package vtc.BusinesLogicLayers;

import java.util.List;

import vtc.DataAccessLayers.TagsDAL;
import vtc.PresentationLayers.Tags;

public class TagsBLL {
    private TagsDAL dal = new TagsDAL();

    public List<Tags> showAllTags() {
        return dal.showTags();
    }
}
