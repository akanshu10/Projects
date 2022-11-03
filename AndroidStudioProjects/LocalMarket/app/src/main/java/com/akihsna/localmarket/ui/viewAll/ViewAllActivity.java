package com.akihsna.localmarket.ui.viewAll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;
import com.akihsna.localmarket.ui.home.GridproductAdaptor;
import com.akihsna.localmarket.ui.home.horizontalproductmodel;
import com.akihsna.localmarket.ui.list.wishlistAdaptor;
import com.akihsna.localmarket.ui.list.wishlistModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    private RecyclerView viewallrecycler;
    private GridView viewallgrid;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewallrecycler=findViewById(R.id.viewallrecycler);
        viewallgrid.findViewById(R.id.viewallgrid);

        viewallrecycler.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewallrecycler.setLayoutManager(linearLayoutManager);

        List<wishlistModel> wishlistModelList=new ArrayList<>();
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));

        wishlistAdaptor wishlistAdaptor1=new wishlistAdaptor(wishlistModelList);
        viewallrecycler.setAdapter(wishlistAdaptor1);
        wishlistAdaptor1.notifyDataSetChanged();


        viewallgrid.setVisibility(View.VISIBLE);;
        List<horizontalproductmodel>horizontalproductmodelList=new ArrayList<>();
        horizontalproductmodelList.add(new horizontalproductmodel("R.drawable.pic","","redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel("R.drawable.pic","","redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel("R.drawable.pic","","redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel("R.drawable.pic","","redmi 5a","hello","5000"));

        GridproductAdaptor gridproductAdaptor=new GridproductAdaptor(horizontalproductmodelList);
        viewallgrid.setAdapter(gridproductAdaptor);



    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            Toast.makeText(ViewAllActivity.this, "hello notification", Toast.LENGTH_SHORT).show();
            return true;
        }
        else  if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}