package com.example.myclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.EasyEditSpan;

public class MainActivity extends AppCompatActivity {
    private static String API_KEY="46704122";
    private static String  SESSION_ID="2_MX40NjcwNDEyMn5-MTU4ODA2Njc4OTg0NH4zQVBxQU94ZVdKRUNTQmxId2F5dnFtaER-fg";
    private static String  TOKEN="T1==cGFydG5lcl9pZD00NjcwNDEyMiZzaWc9MjYwOTIxYjIxOTQ2ZWNhOWExMjQ3YWVmYzNhYjEzNmNmMzNmMmQ3ZTpzZXNzaW9uX2lkPTJfTVg0ME5qY3dOREV5TW41LU1UVTRPREEyTmpjNE9UZzBOSDR6UVZCeFFVOTRaVmRLUlVOVFFteElkMkY1ZG5GdGFFUi1mZyZjcmVhdGVfdGltZT0xNTg4MDY2ODk0Jm5vbmNlPTAuMjIwMzg3MzQ4OTA1NjgyJnJvbGU9cHVibGlzaGVyJmV4cGlyZV90aW1lPTE1ODgwODg0OTMmaW5pdGlhbF9sYXlvdXRfY2xhc3NfbGlzdD0=";
    private static  String LOG_TAG=MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }
}
