package com.akihsna.kisaanhelpusmlt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TruckActivity2 extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Button button,button1;
    EditText trolly;
    MediaPlayer player;
    TextView current_weighted,current_issued,total_trolly,token_no,token_noo,between_buggi,text,text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck2);
        current_weighted=findViewById(R.id.current_weighted_trolley);
        current_issued=findViewById(R.id.current_issue_token_number);
        total_trolly=findViewById(R.id.total_troli_on);
        token_no=findViewById(R.id.buggitokenno);
        token_noo=findViewById(R.id.yr_token_number);
        between_buggi=findViewById(R.id.trolly_btwn);
        button=findViewById(R.id.btn);
        button1=findViewById(R.id.btn11);
        text=findViewById(R.id.total_troli11);
        trolly=findViewById(R.id.total_troli_number);
        text1=findViewById(R.id.total_troli_number11);
        text2=findViewById(R.id.total_troli);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player!=null)
                {player.pause();}
                text.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                trolly.setVisibility(View.VISIBLE);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alarm=trolly.getText().toString();
                if(!alarm.isEmpty()){
                button.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                trolly.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                text1.setVisibility(View.VISIBLE);
                text1.setText(trolly.getText());
            }else{
                    trolly.setError("Please enter number for alarm");
                }
            }
        });
        final String token_no1=getIntent().getStringExtra("tokenkey");
        mDatabase = FirebaseDatabase.getInstance().getReference("Token-number/Truck");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("weightedtoken").getValue().toString();
                current_weighted.setText(name);
                current_weighted.setText(name);
                int inum = Integer.parseInt(name);
                String current_issue=snapshot.child("issuetoken").getValue().toString();
                current_issued.setText(current_issue);
                current_issued.setText(current_issue);
                int inum2 = Integer.parseInt(current_issue);
                int total=inum2-inum;
                String s=String.valueOf(total);
                total_trolly.setText(s);
                token_no.setText(token_no1);
                token_noo.setText(token_no1);
                int inum3= Integer.parseInt(token_no1);
                int btw_trolly=inum3-inum-1;
                String s1=String.valueOf(btw_trolly);
                between_buggi.setText(s1);
                String p=trolly.getText().toString();
                if(s1.equals(p)){
                    play();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void play() {
        player=MediaPlayer.create(this,R.raw.sound);
        player.setLooping(true);
        player.start();
    }
}