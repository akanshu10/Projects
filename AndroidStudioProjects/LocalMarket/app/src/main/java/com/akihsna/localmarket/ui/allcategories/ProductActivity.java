package com.akihsna.localmarket.ui.allcategories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.akihsna.localmarket.Loginhomepage;
import com.akihsna.localmarket.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ViewPager productviewpager;
    private TabLayout productdetailtab;
    private static boolean addedTOwishlist=false;
    private ViewPager productimagesviewpager1;
    private TabLayout viewpagerindicator;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        toolbar = findViewById(R.id.prducttoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productdetailtab=findViewById(R.id.productdetailtablayout);
        productviewpager=findViewById(R.id.productdetailviewpager);


        productimagesviewpager1=findViewById(R.id.productimagesviewpager);
        viewpagerindicator=findViewById(R.id.productviewpagerindicator);
        viewpagerindicator.setupWithViewPager(productimagesviewpager1,true);

        List<Integer>productimage=new ArrayList<>();
        productimage.add(R.drawable.home);
        productimage.add(R.drawable.beauty);
        productimage.add(R.drawable.welcome);
        productimage.add(R.drawable.beauty);

        productimagesAdeptor productimagesAdeptor1=new productimagesAdeptor(productimage);
        productimagesviewpager1.setAdapter(productimagesAdeptor1);

        floatingActionButton=findViewById(R.id.floatingActionButton11);
        floatingActionButton.setColorFilter(Color.GRAY);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addedTOwishlist){
                    addedTOwishlist=false;
                    floatingActionButton.setColorFilter(Color.GRAY);
                }else{
                    addedTOwishlist=true;
                    floatingActionButton.setColorFilter((Color.RED));
                }
            }
        });
        productviewpager.setAdapter(new ProductdetailsAdaptor(getSupportFragmentManager(),productdetailtab.getTabCount()));
        productviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productdetailtab));
        productdetailtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_cart_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if(id==R.id.productsearch){
            Toast.makeText(ProductActivity.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id==R.id.productcart) {
            return  true;
        }
        else if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}