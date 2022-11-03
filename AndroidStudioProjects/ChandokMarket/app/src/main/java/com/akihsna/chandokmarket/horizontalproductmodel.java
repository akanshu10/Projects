package com.akihsna.chandokmarket;

public class horizontalproductmodel {
    private int productimage;
    private  String productname;
    private String productdes;
    private String productprice;

    public horizontalproductmodel(int productimage, String productname, String productdes, String productprice) {
        this.productimage = productimage;
        this.productname = productname;
        this.productdes = productdes;
        this.productprice = productprice;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdes() {
        return productdes;
    }

    public void setProductdes(String productdes) {
        this.productdes = productdes;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
