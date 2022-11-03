package com.akihsna.kisaanhelpusmlt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView textView1,textView2,textView3;
    ImageView imageView1,imageView2,imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        /*textView1=findViewById(R.id.you_tube1);
        imageView1=findViewById(R.id.you_tube2);
        textView2=findViewById(R.id.instagram1);
        imageView2=findViewById(R.id.instagram2);
        textView3=findViewById(R.id.facebook2);
        imageView3=findViewById(R.id.facebook1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/channel/UClBNEpyNXvpo6wHsb9OdChg"));
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"));
                    startActivity(intent);
                }
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/channel/UCIZLhkJXqqxIsTJrGp5nDxg"));
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"));
                    startActivity(intent);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/akanshu.rajput41?igshid=1u2nrpbzpjaqo"));
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com"));
                    startActivity(intent);
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/__akihsna__?igshid=fpkwir49u2hh"));
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com"));
                    startActivity(intent);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/r.rajput.526438"));
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                    startActivity(intent);
                }
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/111926247379877"));
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                    startActivity(intent);
                }
            }
        });*/
    }


}