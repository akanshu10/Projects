package com.akihsna.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar ksjdhn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SystemClock.sleep(3000);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}