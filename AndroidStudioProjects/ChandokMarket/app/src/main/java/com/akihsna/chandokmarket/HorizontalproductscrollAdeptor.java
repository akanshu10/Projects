package com.akihsna.chandokmarket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalproductscrollAdeptor extends RecyclerView.Adapter<HorizontalproductscrollAdeptor.ViewHolder> {
    private List<horizontalproductmodel>horizontalproductmodels;

    public HorizontalproductscrollAdeptor(List<horizontalproductmodel> horizontalproductmodels) {
        this.horizontalproductmodels = horizontalproductmodels;
    }


    @NonNull
    @Override
    public HorizontalproductscrollAdeptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_screen_itemlayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalproductscrollAdeptor.ViewHolder holder, int position) {
        int resource=horizontalproductmodels.get(position).getProductimage();
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
        return horizontalproductmodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView prductimage;
        private TextView productname;
        private TextView productdes;
        private TextView productprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            prductimage=itemView.findViewById(R.id.imageView2);
            productname=itemView.findViewById(R.id.textView);
            productdes=itemView.findViewById(R.id.textView2);
            productprice=itemView.findViewById(R.id.textView3);
        }
        private  void setPrductimage(int resources){
            prductimage.setImageResource(resources);
        }
        private  void setProductname(String name){
            productname.setText(name);
        }
        private  void setProductdes(String dec){
            productname.setText(dec);
        }
        private  void setProductprice(String price){
            productname.setText(price);
        }


    }
}
