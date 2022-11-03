package com.akihsna.market;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.api.Context;

import java.util.List;

import static java.security.AccessController.getContext;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    List<CategoryModel>categoryModelList;

    public CategoryAdaptor(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String cindex=categoryModelList.get(position).getCIndex();
        String cname=categoryModelList.get(position).getCName();
        String cImage=categoryModelList.get(position).getCImage();
        holder.setData(cindex,cname,cImage);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView CIndex;
        private TextView Cname;
        private ImageView Cimage;
        private ImageView Cedit;
        private ImageView Cdel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            CIndex=itemView.findViewById(R.id.category_no);
            Cname=itemView.findViewById(R.id.category_name);
            Cimage=itemView.findViewById(R.id.category_Icon);
            Cedit=itemView.findViewById(R.id.category_edit);
            Cdel=itemView.findViewById(R.id.delete_category);
            Cedit.setClickable(true);
            Cedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(),CategoryEditActivity.class);
                    intent.putExtra("index",CIndex.getText());
                    intent.putExtra("name",Cname.getText());
                    Cimage.buildDrawingCache();
                    Bitmap imagemap = Cimage.getDrawingCache();
                    intent.putExtra("BitmapImage", imagemap);
                    v.getContext().startActivity(intent);

                }
            });
            Cdel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1= new Intent(v.getContext(),DeleteCategoryActivity.class);
                    intent1.putExtra("index",CIndex.getText());
                    intent1.putExtra("name",Cname.getText());
                    Cimage.buildDrawingCache();
                    Bitmap imagemap = Cimage.getDrawingCache();
                    intent1.putExtra("BitmapImage", imagemap);
                    v.getContext().startActivity(intent1);
                    ((Activity)v.getContext()).finish();
                }
            });

        }

        public void setData(String cindex, String cname, String cImage) {
            if(cImage.equals("null")){
                Cedit.setVisibility(View.INVISIBLE);
                Cdel.setVisibility(View.INVISIBLE);
                Cimage.setImageResource(R.drawable.logo);
            }
            else {
                Glide.with(itemView.getContext()).load(cImage).apply(new RequestOptions().placeholder(R.drawable.logo)).into(Cimage);
            }Cname.setText(cname);
            CIndex.setText(cindex);
        }
    }
}
