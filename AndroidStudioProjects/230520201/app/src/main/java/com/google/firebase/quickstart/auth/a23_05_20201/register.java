package com.google.firebase.quickstart.auth.a23_05_20201;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mfullname, muserEmailId, mmobilenumber, mlocation, mpassword, mconfirmpassword;
    Button msignup, malreadyuser;
    TextView mtext;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfullname=findViewById(R.id.fullName);
        muserEmailId=findViewById(R.id.userEmailId);
        mmobilenumber=findViewById(R.id.mobileNumber);
        mlocation=findViewById(R.id.location);
        mpassword=findViewById(R.id.password);
        mconfirmpassword=findViewById(R.id.confirmPassword);

        msignup=findViewById(R.id.signUpBtn);
        malreadyuser=findViewById(R.id.already_user);

        mtext=findViewById(R.id.text);

        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);

        //if(mAuth.getCurrentUser() !=null) {
          //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
            //finish();

        //}
        malreadyuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        msignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name=mfullname.getText().toString();
                String mobile=mmobilenumber.getText().toString();
                String adss=mlocation.getText().toString();
                String email = muserEmailId.getText().toString().trim();

                String pass = mpassword.getText().toString().trim();
                String cpass = mconfirmpassword.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    mfullname.setError("Name is reqiured");
                    return;
                }
                if (TextUtils.isEmpty(email))  {
                    muserEmailId.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    mpassword.setError("Password is required");
                    return;
                }
                if (TextUtils.isEmpty(cpass)) {
                    mconfirmpassword.setError("Re-password is required");
                    return;
                }
                if(pass.length()<6){
                    mpassword.setError("Password must be greaer than six charecters");
                    return;
                }
                //if(pass != cpass){
                  //  mconfirmpassword.setError("Re-password must be same as password");
                    //return;
                //}
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "UserCreate success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });
            }
        });

    }
}

