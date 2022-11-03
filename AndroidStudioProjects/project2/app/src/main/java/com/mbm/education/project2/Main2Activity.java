package com.mbm.education.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Main2Activity extends PagerAdapter {
    private Context context;
    private  List<Main4Activity>mlist;
    private LayoutInflater layoutInflater;

    public Main2Activity(Context context, List<Main4Activity> mlist, LayoutInflater layoutInflater) {
        this.context = context;
        this.mlist = mlist;
        this.layoutInflater = layoutInflater;
    }


    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);

    }
}

