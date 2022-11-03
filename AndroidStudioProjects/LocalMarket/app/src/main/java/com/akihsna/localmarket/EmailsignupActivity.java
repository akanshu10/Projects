package com.akihsna.localmarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;

public class EmailsignupActivity extends AppCompatActivity {
    TextView signup,signin1;
    EditText email,password,rpassword,phone;
    ProgressBar progressBar;
    //FirebaseAuth mAuth;
    private String TAG="EmailsignupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailsignup);
        signin1=findViewById(R.id.signin);
        signup=findViewById(R.id.btn);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        rpassword=findViewById(R.id.repassword);
        phone=findViewById(R.id.phone);
        progressBar=findViewById(R.id.progressbar);
        //mAuth= FirebaseAuth.getInstance();
        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(com.akihsna.localmarket.EmailsignupActivity.this,EmailloginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String email1=email.getText().toString().trim();
                final String pass = password.getText().toString().trim();
                final String cpass = rpassword.getText().toString().trim();
                final String phone1=phone.getText().toString().trim();
                if (TextUtils.isEmpty(email1))  {
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    password.setError("Password is required");
                    return;
                }

                if (TextUtils.isEmpty(cpass)) {
                    rpassword.setError("Re-password is required");
                    return;
                }
                if (TextUtils.isEmpty(phone1)) {
                    phone.setError("Phone number is required");
                    return;
                }
                if(pass.length()<6){
                    password.setError("Password must be greaer than six charecters");
                    return;
                }
                if(!pass.equals(cpass)){
                    password.setError("Password Not match");
                    rpassword.setError("Password Not match");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                /*mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if(!task.isSuccessful()){
                            Intent intent=new Intent(EmailsignupActivity.this,emaillinkverificationActivity.class);
                            intent.putExtra("email",email1);
                            startActivity(intent);
                            if(mAuth.getCurrentUser().isEmailVerified()){
                                mAuth.createUserWithEmailAndPassword(email1,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                    }
                                });
                            }
                        }
                    }
                });*/
                /*mAuth.createUserWithEmailAndPassword(email1,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Intent intent=new Intent(com.akihsna.chandokmarket.EmailsignupActivity.this,emaillinkverificationActivity.class);
                                    intent.putExtra("email",email1);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                        }
                    }
                });*/
            }
        });
    }
}