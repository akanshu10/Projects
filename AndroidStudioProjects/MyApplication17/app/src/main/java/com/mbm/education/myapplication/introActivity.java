package com.mbm.education.myapplication.;

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

        setContentView(R.layout.activity_info);

        List<com.mbm.education.myapplication.introActivity> mList=new ArrayList<>();
        mList.add(new com.mbm.education.myapplication.introActivity("Dream","find your dream college hare and get your child future brightly to click here",R.drawable.dream));
        mList.add(new com.mbm.education.myapplication.introActivity("Attaindance","check your attaindanceher",R.drawable.logo));


        screenPager=findViewById(R.id.screen_viewpager);
        Introviewpageradaptor=new introviewpageradaptor(this,);
        screenPager.setAdapter(Introviewpageradaptor);
    }
}
