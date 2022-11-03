package com.mbm.introviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class introActivity extends AppCompatActivity {

    private ViewPager screenPager;
    introviewpageradaptor Introviewpageradaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        List<screenitem> mList=new ArrayList<>();
        mList.add(new screenitem("Dream","",R.drawable.frontfirstview));
        mList.add(new screenitem("Attaindance","",R.drawable.frontsecondviews));
        mList.add(new screenitem("Dream","",R.drawable.frontthirdviews));
        mList.add(new screenitem("Dream","",R.drawable.frontfourthview));


        screenPager=findViewById(R.id.screen_viewpager);
        Introviewpageradaptor=new introviewpageradaptor(this,mList);
        screenPager.setAdapter(Introviewpageradaptor);
    }
}
