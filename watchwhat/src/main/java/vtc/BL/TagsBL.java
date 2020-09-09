package vtc.BL;

import java.util.List;

import vtc.DAL.TagsDAL;
import vtc.Persistance.Tags;

public class TagsBL {
    private TagsDAL dal = new TagsDAL();

    public List<Tags> showAllTags() {
        return dal.showTags();
    }
}
