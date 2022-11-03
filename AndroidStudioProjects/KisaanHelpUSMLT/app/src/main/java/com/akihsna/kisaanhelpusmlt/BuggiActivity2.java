package com.akihsna.kisaanhelpusmlt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BuggiActivity2 extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Button button,button1;
    MediaPlayer player;
    EditText trolly;
    TextView current_weighted,current_issued,total_buggi,token_no,token_noo,between_buggi,text,text1,text2;
    int btw_trolly,i;
    //String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buggi2);
        //createnotification();
        current_weighted=findViewById(R.id.current_weighted_trolley);
        current_issued=findViewById(R.id.current_issue_token_number);
        total_buggi=findViewById(R.id.total_troli_on);
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
                text1.setText(alarm);
                    Toast.makeText(BuggiActivity2.this,"Alarm set",Toast.LENGTH_SHORT).show();
                    //Intent intent=new Intent(BuggiActivity2.this,RemainderActivity2.class);
                    //PendingIntent pendingIntent=PendingIntent.getBroadcast(BuggiActivity2.this,0,intent,0);

                    //AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                    //long timeAtButtonclick=System.currentTimeMillis();
                    //long secondinmills=1000*1;
                    //alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonclick + secondinmills,pendingIntent);

                //createnotification();
                //String message="आपके बीच में "+alarm+" बुग्गी/ट्राली/ट्रक/ट्राला होने पर अलार्म सक्रिय होगा ";
                    //NotificationCompat.Builder builder=new NotificationCompat.Builder(BuggiActivity2.this)
                      //      .setSmallIcon(R.drawable.ic_baseline_notifications)
                        //    .setContentTitle("Alarm set")
                          //  .setContentText(message)
                            //.setAutoCancel(true);

                    //Intent intent2=new Intent(BuggiActivity2.this,RemainderActivity2.class);
                    //intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //intent2.putExtra("message",message);
                    //PendingIntent pendingIntent=PendingIntent.getActivity(BuggiActivity2.this,0,intent2
                      //      ,PendingIntent.FLAG_UPDATE_CURRENT);
                    //builder.setContentIntent(pendingIntent);
                    //NotificationManager notificationManager=(NotificationManager)getSystemService(
                      //      Context.NOTIFICATION_SERVICE
                    //);
                }else {
                    trolly.setError("Please enter number for alarm");

            }


            }
        });
        final String token_no1=getIntent().getStringExtra("tokenkey");
        mDatabase = FirebaseDatabase.getInstance().getReference("Token-number/Buggi");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("weightedtoken").getValue().toString();
                //a=name;//send value to reminder activity
                current_weighted.setText(name);
                int inum = Integer.parseInt(name);//current weighted token number
                String current_issue = snapshot.child("issuetoken").getValue().toString();
                //b=current_issue;//send valu
                current_issued.setText(current_issue);
                int inum2 = Integer.parseInt(current_issue);//issue token number
                int total = inum2 - inum;   //total trolly on plateform
                String s = String.valueOf(total);
                total_buggi.setText(s);
                token_no.setText(token_no1);//your token number
                token_noo.setText(token_no1);
                int inum3 = Integer.parseInt(token_no1);
                btw_trolly = inum3 - inum - 1;
                String s1 = String.valueOf(btw_trolly);
                between_buggi.setText(s1);
                String p = trolly.getText().toString();
                if (s1.equals(p)) {
                    play();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

}

    private  void play() {
        player=MediaPlayer.create(this,R.raw.sound);
        player.setLooping(true);
        player.start();

}
    /*private void createnotification(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="kisaanhelpreminder";
            String description="reminder for help";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notify",name,importance);
            channel.setDescription(description);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }*/

}


