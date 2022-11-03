package com.akihsna.localmarket.ui.home;

public class horizontalproductmodel {
    private  String productId;
    private String productimage;
    private  String productname;
    private String productdes;
    private String productprice;

    public horizontalproductmodel(String productId,String productimage, String productname, String productdes, String productprice) {
        this.productimage = productimage;
        this.productname = productname;
        this.productId=productId;
        this.productdes = productdes;
        this.productprice = productprice;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String  productId) {
        this.productId = productId;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String  productimage) {
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
