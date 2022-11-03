package com.akihsna.all_login;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.akihsna.all_login.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.akihsna.all_login.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {


    AppBarLayout appBarLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem School;
    TabItem Student;
    TabItem Parents;
    TabItem Teacher;
    PagerAdapter pagerAdapter;
    TabItem Visitor;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        appBarLayout=findViewById(R.id.appbar);
        tabLayout=findViewById(R.id.tabs);
        Student=findViewById(R.id.Student);
        School=findViewById(R.id.School);
        Parents=findViewById(R.id.Parents);
        Teacher=findViewById(R.id.Teacher);
        Visitor=findViewById(R.id.Visitor);
        viewPager=findViewById(R.id.view_pager);


        pagerAdapter=new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    appBarLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                    }
                }
               else if(tab.getPosition()==1){
                    appBarLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorlayout));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorlayout));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colorlayout));
                    }
                }
                else if(tab.getPosition()==2){
                    appBarLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                    }
                }
                else if(tab.getPosition()==3){
                    appBarLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colortab3));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colortab3));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colortab3));
                    }
                }
                else if(tab.getPosition()==4){
                   appBarLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colortab4));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colortab4));
                   if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.colortab4));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
       viewPager.setAdapter(sectionsPagerAdapter);
////        TabLayout tabs = findViewById(R.id.tabs);
////        tabs.setupWithViewPager(viewPager);
////        FloatingActionButton fab = findViewById(R.id.fab);
////
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });
  }


}