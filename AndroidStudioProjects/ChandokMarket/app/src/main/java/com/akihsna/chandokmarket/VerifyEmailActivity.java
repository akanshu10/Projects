package com.akihsna.chandokmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerifyEmailActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);
        text=findViewById(R.id.emailverify);

    }
}