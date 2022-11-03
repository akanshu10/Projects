package com.akihsna.localmarket.ui.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;

import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter {
    public CartAdaptor(List<CartitemModel> cartitemModelList) {
        this.cartitemModelList = cartitemModelList;
    }

    private List<CartitemModel> cartitemModelList;


    @Override
    public int getItemViewType(int position) {
        switch (cartitemModelList.get(position).getType()) {
            case 0:
                return CartitemModel.CART_ITME;
            case 1:
                return CartitemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       switch (viewType){
           case CartitemModel.CART_ITME:
               View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
               return new cartItemViewHolder(view);
           case CartitemModel.TOTAL_AMOUNT:
               View amountview= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout,parent,false);
               return new CartTotalAmountViewHolder(amountview);
           default:
               return null;
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartitemModelList.get(position).getType()){
            case CartitemModel.CART_ITME:
                int resoucse=cartitemModelList.get(position).getProductimage();
                String title=cartitemModelList.get(position).getProductname();
                String price=cartitemModelList.get(position).getProductprice();
                String Mrp=cartitemModelList.get(position).getProductmrp();

                ((cartItemViewHolder)holder).setCartItemDetails(resoucse,title,price,Mrp);
                break;

            case CartitemModel.TOTAL_AMOUNT:

                String totalitem=cartitemModelList.get(position).getTotalitem();
                String totalprice=cartitemModelList.get(position).getTotalprice();
                String totalamount=cartitemModelList.get(position).getTotalamount();
                String deliveryprice=cartitemModelList.get(position).getDeliveryprice();
                String saveamount=cartitemModelList.get(position).getSaveamount();

                ((CartTotalAmountViewHolder)holder).setTotalpriceDetails(totalitem,totalprice,totalamount,deliveryprice,saveamount);
                break;


            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return cartitemModelList.size();
    }

    public class cartItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView ProductTitle;
        private TextView Productprice;
        private TextView ProductMRP;
        private TextView ProductQuantity;

        public cartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.cart_product_image);
            ProductTitle=itemView.findViewById(R.id.cart_product_title);
            ProductMRP=itemView.findViewById(R.id.cart_mrp);
            Productprice=itemView.findViewById(R.id.cart_product_price);
            ProductQuantity=itemView.findViewById(R.id.product_quantity);
        }
        private void setCartItemDetails(int resource, String title, String productprice1, String mrp){
            productImage.setImageResource(resource);
            ProductTitle.setText(title);
            Productprice.setText(productprice1);
            ProductMRP.setText(mrp);

        }
    }
    private class CartTotalAmountViewHolder extends RecyclerView.ViewHolder {
        private TextView totalItem;
        private TextView totalItemprice;
        private TextView deliveryprice;
        private TextView totalItemAmount;
        private TextView savedAmount;
        public CartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItem=itemView.findViewById(R.id.total_items);
            totalItemprice=itemView.findViewById(R.id.total_items_price);
            totalItemAmount=itemView.findViewById(R.id.total_amount);
            deliveryprice=itemView.findViewById(R.id.delivery_details);
            savedAmount=itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalpriceDetails(String totalItem1,String totalItemprice1,String totalItemAmount1,String deliveryprice1,String savedAmount1){
            totalItem.setText(totalItem1);
            totalItemprice.setText(totalItemprice1);
            totalItemAmount.setText(totalItemAmount1);
            deliveryprice.setText(deliveryprice1);
            savedAmount.setText(savedAmount1);
        }
    }
}
