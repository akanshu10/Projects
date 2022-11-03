package com.akihsna.localmarket.ui.temp;

import com.akihsna.localmarket.ui.home.horizontalproductmodel;
import com.akihsna.localmarket.ui.home.slider_model;

import java.security.PrivateKey;
import java.util.List;

public class TempModels {
    public static final int BANNER_SLIDER=0;
    public static final int STRIP_AD_BANNER=1;
    public static final int HORIZONTAL_PRODUCT_VIEW=2;
    public static final int GRID_LAYOUT_VIEW=3;


    private  int type;
    //////////////////////
    private List<slider_model> sliderModelList;
    public TempModels(int type, List<slider_model> sliderModelList) {
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

    /////////////////////
    private int resource;
    private String backgroundcolor;

    public TempModels(int type, int resource, String backgroundcolor) {
        this.type = type;
        this.resource = resource;
        this.backgroundcolor = backgroundcolor;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    public String getBackgroundcolor() {
        return backgroundcolor;
    }
    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }
    /////////////////

    private String title;
    private List<horizontalproductmodel>horizontalproductmodelList;
    public TempModels(int type, String title, List<horizontalproductmodel> horizontalproductmodelList) {
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
    /////////////////




    //////////////////
}
