package com.akihsna.localmarket.ui.home;

import java.util.List;

public class category_model {
    private String catagoryiconlink;
    private String categoryname;

    public category_model(String catagoryiconlink, String categoryname) {
        this.catagoryiconlink = catagoryiconlink;
        this.categoryname = categoryname;
    }


    public String getCatagoryiconlink() {
        return catagoryiconlink;
    }

    public void setCatagoryiconlink(String catagoryiconlink) {
        this.catagoryiconlink = catagoryiconlink;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}

