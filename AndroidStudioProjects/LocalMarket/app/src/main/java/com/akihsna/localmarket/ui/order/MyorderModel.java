package com.akihsna.localmarket.ui.order;

public class MyorderModel {
    private int productimage;
    private String ProductTitle;
    private String deliverystatus;

    public MyorderModel(int productimage, String productTitle, String deliverystatus) {
        this.productimage = productimage;
        ProductTitle = productTitle;
        this.deliverystatus = deliverystatus;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }
}
