package com.akihsna.localmarket.ui.home;

import java.util.List;

public class HomeModel {
    public static final int BANNER_SLIDER=0;
    public static final int STRIP_AD_BANNER=1;
    public static final int HORIZONTAL_PRODUCT_VIEW=2;
    public static final int GRID_LAYOUT_VIEW=3;
    public static final int CATEGORY_VIEW=4;

    private  int type;
    private List<slider_model> sliderModelList;

    public HomeModel(int type, List<slider_model> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<slider_model> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<slider_model> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }

    private String resource;
    private String backgroundcolor;

    public HomeModel(int type, String resource, String backgroundcolor) {
        this.type = type;
        this.resource = resource;
        this.backgroundcolor = backgroundcolor;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }
    private String title;
    private List<horizontalproductmodel>horizontalproductmodelList;

    public HomeModel(int type, String title, List<horizontalproductmodel> horizontalproductmodelList) {
        this.type = type;
        this.title = title;
        this.horizontalproductmodelList = horizontalproductmodelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<horizontalproductmodel> getHorizontalproductmodelList() {
        return horizontalproductmodelList;
    }

    public void setHorizontalproductmodelList(List<horizontalproductmodel> horizontalproductmodelList) {
        this.horizontalproductmodelList = horizontalproductmodelList;
    }
    private String catagoryiconlink;
    private String categoryname;
    private List<category_model>categoryModelList;

    public HomeModel(int type, String catagoryiconlink, String categoryname, List<category_model> categoryModelList) {
        this.type = type;
        this.catagoryiconlink = catagoryiconlink;
        this.categoryname = categoryname;
        this.categoryModelList = categoryModelList;
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

    public List<category_model> getCategoryModelList() {
        return categoryModelList;
    }

    public void setCategoryModelList(List<category_model> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }
}
