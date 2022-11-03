
package com.akihsna.skart.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akihsna.skart.R;
import com.akihsna.skart.college.ui.home.HomeFragment;

public class studentActivity extends AppCompatActivity {
    Button addstn,totalstn,blockstudent,nstdnt,lstdnt,psdnt,passtudent,rstdnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_collegeprofilestudent);
        addstn=findViewById(R.id.btnaddstudent);
        totalstn=findViewById(R.id.btntotalstudent);
        blockstudent=findViewById(R.id.btnblockedstudent);
        nstdnt=findViewById(R.id.btnnewstudent);
        lstdnt=findViewById(R.id.btnleftstudent);
        psdnt=findViewById(R.id.btnprasant);
        passtudent=findViewById(R.id.btnpassedstudent);
        rstdnt=findViewById(R.id.btnrestricted);


        addstn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddstudentActivity.class));
            }
        });
        totalstn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),totalstudentActivity.class));
            }
        });
        blockstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),blockedstudentActivity.class));
            }
        });
        nstdnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),newadmittedstudentActivity.class));
            }
        });
        lstdnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),leftstudentActivity.class));
            }
        });
        psdnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),totalpresentstudentActivity.class));
            }
        });
        passtudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),paasoutstudentActivity.class));
            }
        });
        rstdnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),restrictedstudentActivity.class));
            }
        });
    }
}
