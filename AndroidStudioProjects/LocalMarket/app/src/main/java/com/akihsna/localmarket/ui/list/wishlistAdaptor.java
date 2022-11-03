package com.akihsna.localmarket.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;

import java.util.List;

public class wishlistAdaptor extends RecyclerView.Adapter<wishlistAdaptor.ViewHolder> {

    List<wishlistModel>wishlistModelList;

    public wishlistAdaptor(List<wishlistModel> wishlistModelList) {
        this.wishlistModelList = wishlistModelList;
    }

    @NonNull
    @Override
    public wishlistAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wishlistAdaptor.ViewHolder holder, int position) {
        int resource=wishlistModelList.get(position).getProductImage();
        String name=wishlistModelList.get(position).getProductTitle();
        String price=wishlistModelList.get(position).getProductPrice();
        holder.setData(resource,name,price);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView Prductimage;
        private TextView producttitle;
        private TextView productprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productprice=itemView.findViewById(R.id.wishlist_item_price);
            producttitle=itemView.findViewById(R.id.wishlist_item_title);
            Prductimage=itemView.findViewById(R.id.wishlist_item_image);
        }
        private void setData(int resource, String title, String price) {
            Prductimage.setImageResource(resource);
            producttitle.setText(title);
            productprice.setText(price);
        }
    }
}
