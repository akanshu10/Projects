package com.akihsna.chandokmarket;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ProgressBar ksjdhn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ksjdhn=findViewById(R.id.uygvst);
        SystemClock.sleep(3000);
        startActivity(new Intent(com.akihsna.chandokmarket.SplashActivity.this, MainActivity.class));
        finish();
    }
}