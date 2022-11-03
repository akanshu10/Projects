package com.akihsna.localmarket.ui.allcategories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.home.GridproductAdaptor;
import com.akihsna.localmarket.ui.home.categoryAdeptor;
import com.akihsna.localmarket.ui.home.category_model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllcategoryActivityActivity extends AppCompatActivity {
    Toolbar toolbar;
    private GridView gridView;
    private Object categoryAdeptor;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcategory_activity);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Activity");
        gridView=findViewById(R.id.gridview);
        List<category_model> categoryModelList=new ArrayList<>();
//        categoryModelList.add(new category_model("link","All categories"));
//        categoryModelList.add(new category_model("link","Home"));
//        categoryModelList.add(new category_model("link","Fashion"));
//        categoryModelList.add(new category_model("link","Beauty"));
//        categoryModelList.add(new category_model("link","Mobiles"));
//        categoryModelList.add(new category_model("link","Appliences"));
//        categoryModelList.add(new category_model("link","Toys"));
//        categoryModelList.add(new category_model("link","Food&sweets"));
//        categoryModelList.add(new category_model("link","sports"));
//        categoryModelList.add(new category_model("link","Clothes"));
        CategoryGridAdeptor categoryAdeptor =new CategoryGridAdeptor(categoryModelList);
        gridView.setAdapter(categoryAdeptor);

        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Categories").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult()){
                                categoryModelList.add(new category_model(queryDocumentSnapshot.get("icon").toString(),queryDocumentSnapshot.get("title").toString()));
                            }
                            categoryAdeptor.notifyDataSetChanged();
                        }else
                        {
                            String error=task.getException().getMessage();
                            Toast.makeText(AllcategoryActivityActivity.this,error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        
        
        //categoryAdeptor.notifyDataSetChanged();
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