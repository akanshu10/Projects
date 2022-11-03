package com.akihsna.localmarket.ui.allcategories;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.home.category_model;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CategoryGridAdeptor extends BaseAdapter {
    List<category_model>categoryModelList;

    public CategoryGridAdeptor(List<category_model> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @Override
    public int getCount() {
        return categoryModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoty_item, null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            ImageView productimage = view.findViewById(R.id.categoryicon);
            TextView producttitle = view.findViewById(R.id.categorytext);
            //productimage.setImageResource((categoryModelList.get(position).getCatagoryiconlink()));
            Glide.with(parent.getContext()).load(categoryModelList.get(position).getCatagoryiconlink()).apply(new RequestOptions().placeholder(R.drawable.category)).into(productimage);
            producttitle.setText(categoryModelList.get(position).getCategoryname());

        }else {
            view=convertView;
        }
        return view;
    }
}
