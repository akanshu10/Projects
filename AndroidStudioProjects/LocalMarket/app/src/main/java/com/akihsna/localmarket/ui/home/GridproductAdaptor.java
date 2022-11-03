package com.akihsna.localmarket.ui.home;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.akihsna.localmarket.R;

import java.util.List;

public class GridproductAdaptor extends BaseAdapter {

    List<horizontalproductmodel>horizontalproductmodelList;

    public GridproductAdaptor(List<horizontalproductmodel> horizontalproductmodelList) {
        this.horizontalproductmodelList = horizontalproductmodelList;
    }

    @Override
    public int getCount() {
        return 4;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_screen_itemlayout, null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            ImageView productimage = view.findViewById(R.id.horizontalimage);
            TextView producttitle = view.findViewById(R.id.horizontaltitle);
            TextView productdec = view.findViewById(R.id.horizontaldec);
            TextView productprice = view.findViewById(R.id.horizontalprice);


            //productimage.setImageResource(horizontalproductmodelList.get(position).getProductimage());
            producttitle.setText(horizontalproductmodelList.get(position).getProductname());
            productdec.setText(horizontalproductmodelList.get(position).getProductdes());
            productprice.setText(horizontalproductmodelList.get(position).getProductprice());
        } else {
            view = convertView;
        }
        return view;
    }
}
