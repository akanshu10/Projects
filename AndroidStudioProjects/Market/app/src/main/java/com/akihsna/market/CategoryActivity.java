package com.akihsna.market;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class CategoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    private TextView textView;
    private RecyclerView categoryrecyclorview;
    private FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Categories");


        categoryrecyclorview=findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryrecyclorview.setLayoutManager(layoutManager);
        List<CategoryModel>categoryModelList=new ArrayList<>();
        CategoryAdaptor categoryAdaptor=new CategoryAdaptor(categoryModelList);
        categoryrecyclorview.setAdapter(categoryAdaptor);
        textView=findViewById(R.id.total_category);
        progressBar=findViewById(R.id.category_progressbar);
        progressBar.setVisibility(View.VISIBLE);
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Categories").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            progressBar.setVisibility(View.INVISIBLE);
                        for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {

                            categoryModelList.add(new CategoryModel(queryDocumentSnapshot.get("icon").toString(), queryDocumentSnapshot.get("title").toString(),
                                    queryDocumentSnapshot.get("index").toString()));
                        }
                        textView.setText(String.valueOf(categoryModelList.size()));
                        categoryAdaptor.notifyDataSetChanged();
                    }else{
                            String error=task.getException().getMessage();
                            Toast.makeText(CategoryActivity.this,error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home){
            finish();
            return true;
        }
        else if (id==R.id.action_add_activity){
            Intent intent=new Intent(CategoryActivity.this,AddActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);

    }
}