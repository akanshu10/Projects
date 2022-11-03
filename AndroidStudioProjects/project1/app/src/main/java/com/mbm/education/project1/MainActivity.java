package com.mbm.education.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    frontpage Frontpage;
    List<frontmodel>models;
    Integer[] color=null;
    ArgbEvaluator argbEvaluator =new ArgbEvaluator();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models=new ArrayList<>();
        models.add(new frontmodel(R.drawable.first,"Know our future","here you get school"));
        models.add(new frontmodel(R.drawable.second,"Kno your future","here you get school"));
        models.add(new frontmodel(R.drawable.fourth,"Know  future","here you get school"));
        models.add(new frontmodel(R.drawable.five,"your future","here you get school"));

        viewPager=findViewById(R.id.viewPager);
        Frontpage=new frontpage(models);

    }
}
