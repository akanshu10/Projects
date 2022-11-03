package com.akihsna.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =findViewById(R.id.next);
        editText=findViewById(R.id.mobno);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText.getText().toString().trim();
                String phonenumber= number;
                Intent intent=new Intent(MainActivity.this,otpActivity.class);
                //intent.putExtra("number",phonenumber);
                startActivity(intent);
            }
        });
    }
}