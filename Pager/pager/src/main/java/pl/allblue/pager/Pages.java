package pl.allblue.pager;

import java.util.HashMap;
import java.util.Map;

public class Pages
{

    String pagerTag = null;

    private Map<String, PageInfo> pages = new HashMap<>();

    private String defaultPage_Name = null;


    public Pages(String pagerTag)
    {
        this.pagerTag = pagerTag;
    }

    public Pages add(String page_name, Page page_instance)
    {
        PageInfo page = new PageInfo(this.pagerTag, page_name, page_instance);

        this.pages.put(page_name, page);

        return this;
    }

//    public PageInfo getActivePage()
//    {
//        return this.activePage_Name == null ?
//                null : this.get(this.activePage_Name);
//    }

    public PageInfo getDefault()
    {
        if (this.defaultPage_Name == null)
            return null;

//        if (this.defaultPage_Name == null) {
//            if (this.pages.size() == 0)
//                throw new AssertionError("No pages added.");
//
//            return this.pages.get(this.firstPage_Name);
//        }

        return this.pages.get(this.defaultPage_Name);
    }

    public PageInfo get(String pageName)
    {
        if (!this.pages.containsKey(pageName))
            throw new AssertionError("PageInfo `" + pageName + "` does not exist.");

        return this.pages.get(pageName);
    }

    public void setDefault(String page_name)
    {
        this.defaultPage_Name = page_name;
    }

}
