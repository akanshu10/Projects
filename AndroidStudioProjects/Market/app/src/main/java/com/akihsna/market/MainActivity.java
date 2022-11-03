package com.akihsna.market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText userid1;
    EditText userpass;
     TextView forgotpassword;
     TextView loginbtn;
     CheckBox showpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid1=findViewById(R.id.userid123);
        userpass=findViewById(R.id.userpassword);
        forgotpassword=findViewById(R.id.forgotpass);
        loginbtn=findViewById(R.id.logintext);
        showpassword=findViewById(R.id.checkBox);

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    userpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });


    }
}