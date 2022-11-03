package com.mbm.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.mbm.myapplication.notificationclass.CHANNEL_ID;

public class MainActivity extends AppCompatActivity {

    private EditText currentwht,currentisu,yrtoken,TROLLEYNUMBER;
    private TextView ttrolly,ttrolly2,yrtoken1;
    private Button btn;
    private NotificationManagerCompat notificationmanager;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationmanager=NotificationManagerCompat.from(this);


        currentwht=findViewById(R.id.current_weighted_trolley);
        currentisu=findViewById(R.id.current_issue_token_number);
        ttrolly=findViewById(R.id.total_troli_on);
        ttrolly2= findViewById(R.id.trolly_btwn);
        yrtoken=findViewById(R.id.my_token_number);
        yrtoken1=findViewById(R.id.yr_token_number);
        btn=findViewById(R.id.btn);
        TROLLEYNUMBER=findViewById(R.id.total_troli_number);
        mediaPlayer=MediaPlayer.create(this,R.raw.alarm);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String whttoken=(currentwht.getText().toString());
                final String isutoken=currentisu.getText().toString();
                final String mytoken=(yrtoken.getText().toString());
                final String ttrolley=TROLLEYNUMBER.getText().toString();

                if(! TextUtils.isEmpty(mytoken)){

                    int mytkn=Integer.parseInt(mytoken);
                    int whtkn = Integer.parseInt(whttoken);
                    int ttrly=Integer.parseInt(ttrolley);

                    int Btrolly=mytkn-whtkn;

                    yrtoken1.setText(String.valueOf(mytkn));
                    ttrolly2.setText(String.valueOf(Btrolly));

                    if(Btrolly==ttrly){
                        mediaPlayer.start();
                    }

                }else {
                    int mytkn=0;
                    int Btrolly=0;
                    yrtoken1.setText(String.valueOf(mytkn));
                    ttrolly2.setText(String.valueOf(Btrolly));
                }
                if(!TextUtils.isEmpty(whttoken) && !TextUtils.isEmpty(isutoken)) {
                    int whtkn = Integer.parseInt(whttoken);
                    int istkn = Integer.parseInt(isutoken);


                    int Ttrolly= istkn-whtkn;
                    ttrolly.setText(String.valueOf(Ttrolly));

                }



                           }
        });
    }
    public void reminder(View v){

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID).setSmallIcon(R.drawable.ic_adb_black_24dp)
                .setContentTitle("title")
                .setContentText("messages")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationmanager.notify(1,notification);
    }
}
