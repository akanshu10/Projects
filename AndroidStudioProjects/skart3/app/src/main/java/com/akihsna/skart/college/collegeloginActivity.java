package com.akihsna.skart.college;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.akihsna.skart.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class collegeloginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegelogin);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        /*profilebtn=findViewById(R.id.btnprofile);
        studentbtn=findViewById(R.id.btnstudent);
        teacherbtn=findViewById(R.id.btnteacher);
        guardianbtn=findViewById(R.id.btnguardian);
        classbtn=findViewById(R.id.btnclass);
        exambtn=findViewById(R.id.btnexam);
        attendancebtn=findViewById(R.id.btnattendance);
        scholarshipbtn=findViewById(R.id.btnscholarship);
        holidaysbtn=findViewById(R.id.btnholidays);
        eventsbtn=findViewById(R.id.btnevents);

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(collegeloginActivity.this,"profilecheack",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), collegeprofileActivity.class));
            }
        });

        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), studentActivity.class));
            }
        });
        teacherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),collegeteacherActivity.class));
            }
        });
        classbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),classesActivity.class));
            }
        });
        guardianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),guardiansActivity.class));
            }
        });
        exambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ExamActivity.class));
            }
        });
        attendancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AttendanceActivity.class));
            }
        });
    }*/

    }
}