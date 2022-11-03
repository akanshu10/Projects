package com.akihsna.localmarket.ui.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;
import com.akihsna.localmarket.ui.order.MyorderAdaptor;
import com.akihsna.localmarket.ui.order.MyorderModel;

import java.util.ArrayList;
import java.util.List;

public class wishlistActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView wishlistrecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wishlistrecycler=findViewById(R.id.wishlistrecycler1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistrecycler.setLayoutManager(layoutManager);

        List<wishlistModel> wishlistModelList=new ArrayList<>();
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));
        wishlistModelList.add(new wishlistModel(R.drawable.beauty,"hello","delivered"));

        wishlistAdaptor wishlistAdaptor1=new wishlistAdaptor(wishlistModelList);
        wishlistrecycler.setAdapter(wishlistAdaptor1);
        wishlistAdaptor1.notifyDataSetChanged();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            Toast.makeText(wishlistActivity.this, "hello notification", Toast.LENGTH_SHORT).show();
            return true;
        }
        else  if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}