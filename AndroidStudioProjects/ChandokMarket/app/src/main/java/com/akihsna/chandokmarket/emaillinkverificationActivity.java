package com.akihsna.chandokmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class emaillinkverificationActivity extends AppCompatActivity {
    TextView edit,signin,emailverify,home;
    String email;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emaillinkverification);
        edit=findViewById(R.id.editemail);
        signin=findViewById(R.id.signinbtn);
        emailverify=findViewById(R.id.emailverify);
        email=getIntent().getStringExtra("email");
        emailverify.setText(email);
        home=findViewById(R.id.homebtn);
        mauth=FirebaseAuth.getInstance();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(emaillinkverificationActivity.this,MainActivity.class));
                finish();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(emaillinkverificationActivity.this,EmailsignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(emaillinkverificationActivity.this,EmailloginActivity.class));
                finish();
            }
        });
    }
}