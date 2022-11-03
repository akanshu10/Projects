package com.akihsna.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;




import java.util.ArrayList;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;



    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    Button lbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbtn = findViewById(R.id.loginBtn);
        spinner=findViewById(R.id.spinner2);


        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, list);

    }




        }

    
