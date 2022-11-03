package com.akihsna.localmarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;

public class forgetpasswordActivity extends AppCompatActivity {
    EditText email;
    TextView sentlink,back;
    //FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        email=findViewById(R.id.email);
        sentlink=findViewById(R.id.btn);
        back=findViewById(R.id.cancelbtn);
        //mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressbar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.akihsna.localmarket.forgetpasswordActivity.this,EmailloginActivity.class));
                finish();
            }
        });
        sentlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Please Insert correct email address");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                Intent intent=new Intent(com.akihsna.localmarket.forgetpasswordActivity.this,emaillinkverificationActivity.class);
                intent.putExtra("email",email.getText().toString());
                startActivity(intent);
                finish();
               /* mAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(com.akihsna.chandokmarket.forgetpasswordActivity.this,"Password Reset link sent on your mail",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(com.akihsna.chandokmarket.forgetpasswordActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

            }
        });
    }
}