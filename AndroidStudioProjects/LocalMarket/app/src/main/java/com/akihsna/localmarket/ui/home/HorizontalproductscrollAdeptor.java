package com.akihsna.localmarket.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.ProductActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HorizontalproductscrollAdeptor extends RecyclerView.Adapter<com.akihsna.localmarket.ui.home.HorizontalproductscrollAdeptor.ViewHolder> {
    private List<horizontalproductmodel>horizontalproductmodels;

    public HorizontalproductscrollAdeptor(List<horizontalproductmodel> horizontalproductmodels) {
        this.horizontalproductmodels = horizontalproductmodels;
    }


    @NonNull
    @Override
    public com.akihsna.localmarket.ui.home.HorizontalproductscrollAdeptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_screen_itemlayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.akihsna.localmarket.ui.home.HorizontalproductscrollAdeptor.ViewHolder holder, int position) {
        String resource=horizontalproductmodels.get(position).getProductimage();
        String name=horizontalproductmodels.get(position).getProductname();
        String dec=horizontalproductmodels.get(position).getProductdes();
        String price=horizontalproductmodels.get(position).getProductprice();

        holder.setPrductimage(resource);
        holder.setProductname(name);
        holder.setProductdes(dec);
        holder.setProductprice(price);
    }

    @Override
    public int getItemCount() {
        if(horizontalproductmodels.size()>8){
            return 8;
        }
        else {
        return horizontalproductmodels.size();
    }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView prductimage;
        private TextView productname;
        private TextView productdes;
        private TextView productprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prductimage=itemView.findViewById(R.id.horizontalimage);
            productname=itemView.findViewById(R.id.horizontaltitle);
            productdes=itemView.findViewById(R.id.horizontaldec);
            productprice=itemView.findViewById(R.id.horizontalprice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailintent=new Intent(itemView.getContext(), ProductActivity.class);
                    itemView.getContext().startActivity(productdetailintent);
                }
            });
        }
        private  void setPrductimage(String resources){
            Glide.with(itemView.getContext()).load(resources).apply(new RequestOptions().placeholder(R.drawable.category)).into(prductimage);

            //prductimage.setImageResource(resources);
        }
        private  void setProductname(String name){
            productname.setText(name);
        }
        private  void setProductdes(String dec){
            productdes.setText(dec);
        }
        private  void setProductprice(String price){
            productprice.setText(price);
        }


    }
}
