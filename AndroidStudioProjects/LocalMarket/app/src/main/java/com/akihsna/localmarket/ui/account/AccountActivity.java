package com.akihsna.localmarket.ui.account;

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

public class AccountActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView layoutrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Account");

        layoutrecyclerview=findViewById(R.id.orderlayoutrecyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutrecyclerview.setLayoutManager(layoutManager);

        List<AccountModel>accountModelList=new ArrayList<>();
        accountModelList.add(new AccountModel("View More","My Order"));
        accountModelList.add(new AccountModel("View More","My Order"));
        accountModelList.add(new AccountModel("View More","My Order"));
        accountModelList.add(new AccountModel("View More","My Order"));
        AccountAdeptor accountAdeptor=new AccountAdeptor(accountModelList);
        layoutrecyclerview.setAdapter(accountAdeptor);
        accountAdeptor.notifyDataSetChanged();
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