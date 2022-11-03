package com.akihsna.localmarket.ui.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.cart.CartAdaptor;

import java.util.ArrayList;
import java.util.List;

public class MyorderActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView myorderrecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Order");

        myorderrecyclerview=findViewById(R.id.myorderrecyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myorderrecyclerview.setLayoutManager(layoutManager);

        List<MyorderModel> myorderModelList=new ArrayList<>();
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","delivered"));
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","delivered"));
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","delivered"));
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","delivered"));
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","Cancel"));
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","delivered"));
        myorderModelList.add(new MyorderModel(R.drawable.beauty,"hello","delivered"));

        MyorderAdaptor myorderAdaptor=new MyorderAdaptor(myorderModelList);
        myorderrecyclerview.setAdapter(myorderAdaptor);
        myorderAdaptor.notifyDataSetChanged();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}