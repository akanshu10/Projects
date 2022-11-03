package com.akihsna.all_login;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.all_login.college.collegeloginActivity;
import com.akihsna.all_login.college.guardiansActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.remote.Stream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

public class Schooltab extends Fragment {

    FirebaseFirestore firebaseFirestore ;
    DocumentReference documentReference;
    DatabaseReference databaseReference;
    EditText username;
    EditText pass;
    String name,pass1;
    public final static String TAG="School/Colleges";
    //private ValueEventListener listener;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        databaseReference= FirebaseDatabase.getInstance().getReference();

        View view = inflater.inflate(R.layout.fragment_school, container, false);
        final Button Lbtn = view.findViewById(R.id.loginBtnn);
        final EditText username = view.findViewById(R.id.login_emailidss);
        final EditText pass = view.findViewById(R.id.login_passwordss);




        Lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=username.getText().toString();
                pass1=pass.getText().toString();
                databaseReference.child("STUDENT").child(name).addListenerForSingleValueEvent(listener);

                //startActivity(new Intent(getContext(), collegeloginActivity.class));
            }
            ValueEventListener listener=new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String passw=snapshot.child("pass").getValue(String.class);
                        if (passw.equals(pass1)){
                            startActivity(new Intent(getContext(), collegeloginActivity.class));
                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    //Toast.makeText(Schooltab.this, error.toString(), Toast.LENGTH_SHORT).show();
              //      Toast.makeText(Schooltab.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            };

        });
        return view;

//        DocumentReference documentReference = firebaseFirestore.collection("STATE").document("Dist");
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                if()
//            }
//        })
//    }
    }


    //        @Override
//        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//            if (task.isSuccessful()) {
//                DocumentSnapshot document = task.getResult();
//                if (document.exists()) {
//                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                } else {
//                    Log.d(TAG, "No such document");
//                }
//            } else {
//                Log.d(TAG, "get failed with ", task.getException());
//            }
//        }
//    });




}
