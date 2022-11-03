package com.akihsna.localmarket.ui.list;

public class wishlistModel {
    private int ProductImage;
    private String ProductTitle;
    private String ProductPrice;

    public wishlistModel(int productImage, String productTitle, String productPrice) {
        ProductImage = productImage;
        ProductTitle = productTitle;
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
