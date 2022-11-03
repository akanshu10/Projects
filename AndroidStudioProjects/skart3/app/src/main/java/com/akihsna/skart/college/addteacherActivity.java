package com.akihsna.skart.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akihsna.skart.R;

public class addteacherActivity extends AppCompatActivity {
    Button nxtbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addteacher);
        nxtbtn=findViewById(R.id.tnxtbtn);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),addtaechernxtActivity.class));
            }
        });
    }
}
