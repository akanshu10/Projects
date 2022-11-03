package com.akihsna.localmarket.ui.allcategories;

public class ProductSpecificationModel {
    public static final int SPECIFICATION_TITLE = 0;
    public static final int SPECIFICATION_BODY=1;
    private String featurename;
    private String featurevalue;

    private int type;
    private String title;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ProductSpecificationModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductSpecificationModel(String featurename, String featurevalue, int type) {
        this.featurename = featurename;
        this.featurevalue = featurevalue;
        this.type = type;
    }

    public String getFeaturename() {
        return featurename;
    }

    public void setFeaturename(String featurename) {
        this.featurename = featurename;
    }

    public String getFeaturevalue() {
        return featurevalue;
    }

    public void setFeaturevalue(String featurevalue) {
        this.featurevalue = featurevalue;
    }
}
