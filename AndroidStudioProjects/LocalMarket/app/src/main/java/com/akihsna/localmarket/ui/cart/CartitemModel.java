package com.akihsna.localmarket.ui.cart;

public class CartitemModel {
    public static final int CART_ITME=0;
    public static final int TOTAL_AMOUNT=1;

    private  int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
//
    private int Productimage;
    private String Productname;
    private String ProductMRP;
    private String Productprice;
    private int ProductQuantity;


    public CartitemModel(int type, int productimage, String productname, String productprice, int productQuantity,String productmrp) {
        this.type = type;
        Productimage = productimage;
        Productname = productname;
        Productprice = productprice;
        ProductQuantity = productQuantity;
        ProductMRP=productmrp;
    }
    public String getProductmrp() {
        return ProductMRP;
    }

    public void setProductMRP(String productMRP) {
        ProductMRP = productMRP;
    }

    public int getProductimage() {
        return Productimage;
    }

    public void setProductimage(int productimage) {
        Productimage = productimage;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getProductprice() {
        return Productprice;
    }

    public void setProductprice(String productprice) {
        Productprice = productprice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    private String totalitem;
    private String totalprice;
    private String totalamount;
    private String deliveryprice;
    private String Saveamount;

    public CartitemModel(int type,String totalamount, String totalitem, String totalprice, String deliveryprice, String saveamount) {
        this.type = type;
        this.totalamount=totalamount;
        this.totalitem = totalitem;
        this.totalprice = totalprice;
        this.deliveryprice = deliveryprice;
        Saveamount = saveamount;
    }
    public String getTotalamount() {
        return totalitem;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getTotalitem() {
        return totalitem;
    }

    public void setTotalitem(String totalitem) {
        this.totalitem = totalitem;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDeliveryprice() {
        return deliveryprice;
    }

    public void setDeliveryprice(String deliveryprice) {
        this.deliveryprice = deliveryprice;
    }

    public String getSaveamount() {
        return Saveamount;
    }

    public void setSaveamount(String saveamount) {
        Saveamount = saveamount;
    }
}
