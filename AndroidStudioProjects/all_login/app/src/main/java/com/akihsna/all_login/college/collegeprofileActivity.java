package com.akihsna.all_login.college;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.akihsna.all_login.R;

public class collegeprofileActivity extends AppCompatActivity {
    TextView viewstdnt,viewteacher,viewclass,viewguardian,viewattendance,viewresult,viewexam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collegeprofiles);
        viewstdnt=findViewById(R.id.viewstudentdetails);
        viewattendance=findViewById(R.id.viewattendancedetails);
        viewclass=findViewById(R.id.viewclassesdetails);
        viewexam=findViewById(R.id.viewexamdetails);
        viewguardian=findViewById(R.id.viewguardiandetails);
        viewresult=findViewById(R.id.viewresultdetails);
        viewteacher=findViewById(R.id.viewteacherdetails);

        viewteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),collegeteacherActivity.class));
            }
        });
        viewresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),resultActivity.class));
            }
        });
        viewstdnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),studentActivity.class));
            }
        });
        viewguardian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),guardiansActivity.class));
            }
        });
        viewexam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ExamActivity.class));
            }
        });
        viewclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),classesActivity.class));
            }
        });
        viewattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AttendanceActivity.class));
            }
        });
    }
}
