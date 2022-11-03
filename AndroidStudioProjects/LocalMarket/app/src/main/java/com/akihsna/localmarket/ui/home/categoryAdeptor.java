package com.akihsna.localmarket.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class categoryAdeptor extends RecyclerView.Adapter<com.akihsna.localmarket.ui.home.categoryAdeptor.ViewHolder>  {
    private List<category_model>categoryModelList;

    public categoryAdeptor(List<category_model> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public com.akihsna.localmarket.ui.home.categoryAdeptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categoty_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.akihsna.localmarket.ui.home.categoryAdeptor.ViewHolder holder, int position) {
        String icon=categoryModelList.get(position).getCatagoryiconlink();
        String name=categoryModelList.get(position).getCategoryname();
        holder.setCategoryname(name);
        holder.setCatagoryicon(icon);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView catagoryicon;
        private TextView categoryname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryicon=itemView.findViewById(R.id.categoryicon);
            categoryname=itemView.findViewById(R.id.categorytext);
        }
        private void setCatagoryicon(String iconurl){
            if(!iconurl.equals(null)){
            Glide.with(itemView.getContext()).load(iconurl).apply(new RequestOptions().placeholder(R.drawable.category)).into(catagoryicon);
        }
        }
        private void setCategoryname(String name){
            categoryname.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent categoryIntent = new Intent(itemView.getContext(), CategoryActivity.class);
                        categoryIntent.putExtra("categoryname", name);
                        itemView.getContext().startActivity(categoryIntent);

                }
            });

        }
    }
}
