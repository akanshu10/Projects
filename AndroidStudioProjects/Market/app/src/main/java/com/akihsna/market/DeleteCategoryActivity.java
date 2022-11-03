package com.akihsna.market;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class DeleteCategoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    private TextView choose, cindext,cnamet,cimaget;
    private EditText categryno;
    private EditText categoryname;
    ImageView categotryimage;
    private Button Addcategory;
    private Uri filePath, filepath1;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    int listsize;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Delete Category");
        categryno = findViewById(R.id.edituserno);
        categoryname = findViewById(R.id.editcategoryname);
        categotryimage = findViewById(R.id.uploadcategoryicon);
        cindext=findViewById(R.id.index);
        cnamet=findViewById(R.id.name);
        cimaget=findViewById(R.id.CIUtext);
        Addcategory = findViewById(R.id.addbtn);

        Addcategory.setText("Delete Category");
        choose = findViewById(R.id.chooseimage);
        categoryname.setVisibility(View.INVISIBLE);
        categryno.setVisibility(View.INVISIBLE);
        cnamet.setVisibility(View.VISIBLE);
        cindext.setVisibility(View.VISIBLE);
        choose.setVisibility(View.INVISIBLE);
        cindext.setText(getIntent().getStringExtra("index"));
        int m=Integer.parseInt(cindext.getText().toString());


        Addcategory.setOnClickListener(new View.OnClickListener() {
            int c=0;
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Categories").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    int n=m;
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot queryDocumentSnapshot=task.getResult();
                        listsize=queryDocumentSnapshot.size();
                        for (c = m+1; c<listsize; c++) {
                            Addcategory.setVisibility(View.INVISIBLE);
                            int d=c-1;
                            n++;
                            moveFirestoreDocument(d,c);
                         if(n==listsize-1){
                            moveFirestoreDocument(listsize-1,listsize);
                            n++;
                        }
                        }if (n==listsize){
                        Deletecategory(n-1);
                        }
                    }
                }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        startActivity(new Intent(DeleteCategoryActivity.this,CategoryActivity.class));
                        finish();
                    }
                });
                //int b=listsize("Categories");
                    //System.out.println(b);

            }
        });

        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Categories")
                .document("e-s-m-"+Integer.parseInt(cindext.getText().toString()))
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                cnamet.setText(documentSnapshot.get("title").toString());
                String image=documentSnapshot.get("icon").toString();
                Glide.with(getApplicationContext()).load(image).apply(new RequestOptions().placeholder(R.drawable.logo)).into(categotryimage);
            }
        });
    }

//    private int listsize(String a){
//        firebaseFirestore.collection(a).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                QuerySnapshot queryDocumentSnapshot=task.getResult();
//                listsize=queryDocumentSnapshot.size();
//            }
//        });
//        return listsize;
//}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void Deletecategory(int c){
           firebaseFirestore.collection("Categories").document("e-s-m-"+c)
                   .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
               @Override
               public void onSuccess(Void aVoid) {
                   Addcategory.setVisibility(View.INVISIBLE);
                   Toast.makeText(DeleteCategoryActivity.this,"Category Deletion Successfully",Toast.LENGTH_SHORT).show();
                   //startActivity(new Intent(DeleteCategoryActivity.this,CategoryActivity.class));
                   //finish();
               }
           }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {
                   Toast.makeText(DeleteCategoryActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
               }
           });
    }

    public void moveFirestoreDocument(int c,int d) {
        firebaseFirestore.collection("Categories").document("e-s-m-"+d).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String title=documentSnapshot.get("title").toString();
                        String iocn=documentSnapshot.get("icon").toString();
                        Map<String,Object>categorymap=new HashMap<>();
                        categorymap.put("title", title);
                        categorymap.put("icon",iocn);
                        categorymap.put("index",c);
                        firebaseFirestore.collection("Categories")
                                .document("e-s-m-" +c).update(categorymap)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(DeleteCategoryActivity.this, "success", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
//                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    Addcategory.setVisibility(View.INVISIBLE);
//                    DocumentSnapshot document = task.getResult();
//                    if (document != null) {
//                        String title = document.get("title").toString();
//                        String icon = document.get("icon").toString();
//                        Map<String, Object> categorymap = new HashMap<>();
//                        categorymap.put("title", title);
//                        categorymap.put("icon", icon);
//                        categorymap.put("index",c);
//
//                        firebaseFirestore.collection("Categories")
//                                .document("e-s-m-" +c).update(categorymap)
//                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Void> task) {
//                                        Toast.makeText(DeleteCategoryActivity.this, "success", Toast.LENGTH_SHORT).show();
//
//                                    }
//                                }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(DeleteCategoryActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//                    }
//                }
//            }
//                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Addcategory.setVisibility(View.INVISIBLE);
//                String icon = documentSnapshot.get("icon").toString();
//                String title = documentSnapshot.get("title").toString();
//                Map<String, Object> categorymap = new HashMap<>();
//                categorymap.put("title", title);
//                categorymap.put("icon", icon);
//                categorymap.put("index",c);
//                firebaseFirestore.collection("Categories")
//                        .document("e-s-m-" +c)              .update(categorymap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Addcategory.setVisibility(View.VISIBLE);
//                        //startActivity(new Intent(DeleteCategoryActivity.this, CategoryActivity.class));
//                    }
//                });
//

        //}
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(DeleteCategoryActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        fromPath.getData.addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document != null) {
//                        toPath.set(document.getData())
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void aVoid) {
//                                        Log.d(TAG, "DocumentSnapshot successfully written!");
//                                        fromPath.delete()
//                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                                    @Override
//                                                    public void onSuccess(Void aVoid) {
//                                                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
//                                                    }
//                                                })
//                                                .addOnFailureListener(new OnFailureListener() {
//                                                    @Override
//                                                    public void onFailure(@NonNull Exception e) {
//                                                        Log.w(TAG, "Error deleting document", e);
//                                                    }
//                                                });
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Log.w(TAG, "Error writing document", e);
//                                    }
//                                });
//                    } else {
//                        Log.d(TAG, "No such document");
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });


    }

}
