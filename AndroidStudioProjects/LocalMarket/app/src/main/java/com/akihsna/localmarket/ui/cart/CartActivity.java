package com.akihsna.localmarket.ui.cart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;
import com.akihsna.localmarket.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartitemrecyclerview;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Cart");

        cartitemrecyclerview=findViewById(R.id.cartreciclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartitemrecyclerview.setLayoutManager(layoutManager);


        List<CartitemModel> cartitemModelList=new ArrayList<>();
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(1,"Rs 8734/-","Rs 454/-","5","Rs 40/-","Rs 4598/-"));

        CartAdaptor cartAdaptor=new CartAdaptor(cartitemModelList);
        cartitemrecyclerview.setAdapter(cartAdaptor);
        cartAdaptor.notifyDataSetChanged();
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
