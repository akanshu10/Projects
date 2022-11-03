package com.akihsna.kisaanhelpusmlt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tokenentryActivity2 extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tokenentry2);
        button=findViewById(R.id.next);
        editText=findViewById(R.id.tokenno);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tokennumber=editText.getText().toString();
                if(!tokennumber.isEmpty()){
                Intent intent=new Intent(tokenentryActivity2.this,TracterActivity2.class);
                intent.putExtra("tokenkey",tokennumber);
                startActivity(intent);
                finish();
            }else {
                    editText.setError("Please enter token number");
                }
                }
        });
    }
}