package com.akihsna.market;

public class CategoryModel {
    private String CImage;
    private String CName;
    private String CIndex;

    public CategoryModel(String cImage, String cName, String cIndex) {
        CImage = cImage;
        CName = cName;
        CIndex = cIndex;
    }

    public String getCImage() {
        return CImage;
    }

    public void setCImage(String CImage) {
        this.CImage = CImage;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCIndex() {
        return CIndex;
    }

    public void setCIndex(String CIndex) {
        this.CIndex = CIndex;
    }
}
