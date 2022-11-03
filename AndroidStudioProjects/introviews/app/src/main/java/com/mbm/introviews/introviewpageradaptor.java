package com.mbm.introviews;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class introviewpageradaptor extends PagerAdapter {

    Context mContext;
    List<screenitem> mListscreen;

    public introviewpageradaptor(Context mContext, List<screenitem> mListscreen) {
        this.mContext = mContext;
        this.mListscreen = mListscreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen=inflater.inflate(R.layout.layout_screen,null);

        ImageView imgslide=layoutScreen.findViewById(R.id.intro_img);
        TextView title=layoutScreen.findViewById(R.id.intro_title);
        TextView description=layoutScreen.findViewById(R.id.intro_description);

        title.setText(mListscreen.get(position).getTitle());
        description.setText(mListscreen.get(position).getDescription());
        imgslide.setImageResource(mListscreen.get(position).getScreenImg());

        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return mListscreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
