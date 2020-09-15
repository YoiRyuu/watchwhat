package group4.BusinesLogicLayers;

import java.util.List;

import group4.DataAccessLayers.TagsDAL;
import group4.PresentationLayers.Tags;

public class TagsBLL {
    private TagsDAL dal = new TagsDAL();

    public List<Tags> showAllTags() {
        return dal.showTags();
    }
}
