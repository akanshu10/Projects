package com.akihsna.mysmartpump;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView1;
    ImageView imageView;
    Button btn;
    int output;
    SwitchCompat switchCompat;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference,databaseReference1,databaseReference2,databaseReference3;
    private  int current_image;
    private CountDownTimer countDownTimer;
    private  long timeleftInMilliseconds=5000;
    int[] images={R.drawable.pumpoff,R.drawable.pumpon};
    String connection;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.pump);
        textView1=findViewById(R.id.connection);
        switchCompat=findViewById(R.id.pressBtnn);
        imageView=findViewById(R.id.image);
        btn=findViewById(R.id.refreshbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });/*countDownTimer=new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView1.setText("Connection Check...");
            }

            @Override
            public void onFinish() {

            }
        }.start();*/
       databaseReference3=FirebaseDatabase.getInstance().getReference("Data/MK3dOdcwSH9tolDmvtM/Data");
       databaseReference3.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               String o=snapshot.child("data").getValue().toString();
               textView.setText(o);
               String out=snapshot.child("output").getValue().toString();
               int i=Integer.parseInt(out);
               if(i==1){
                   switchCompat.setChecked(true);
                   switchCompat.setBackgroundColor(0xD59E0909);
                   imageView.setImageDrawable(getResources().getDrawable(R.drawable.pumpon));
               }
               if(i==0){
                   switchCompat.setChecked(false);
                   switchCompat.setBackgroundColor(0xD5619814);
                   imageView.setImageDrawable(getResources().getDrawable(R.drawable.pumpoff));
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

        databaseReference2 = FirebaseDatabase.getInstance().getReference("Data/connection");
        databaseReference2.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String wifi = snapshot.child("wifi").getValue().toString();
                int inum = Integer.parseInt(wifi);
                if (inum == 0) {
                    textView1.setText("Disconnected...");
                }
                if (inum == 1) {
                    textView1.setText("Connected to wifi...");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference=db.getReference("Data");

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCompat.isChecked()){
                    textView.setText("Water Pump is ON");
                    switchCompat.setBackgroundColor(0xD59E0909);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.pumpon));
                    sendData();
                }
                else{
                    textView.setText("Water Pump is OFF");
                    switchCompat.setBackgroundColor(0xD5619814);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.pumpoff));
                    sendData();
                }
            }
        });
    }
    public void sendData(){
       String switchcompect=textView.getText().toString();
       String id=databaseReference.push().getKey();
       if(switchCompat.isChecked()){
           output=1;
           Data data=new Data(id,switchcompect,output);
           HashMap hashMap=new HashMap();
           hashMap.put("Data",data);
           databaseReference.child("MK3dOdcwSH9tolDmvtM").setValue(hashMap);
           Toast.makeText(this,"Pump is ON",Toast.LENGTH_SHORT).show();
       }
       else{
           output=0;
           Data data=new Data(id,switchcompect,output);
           HashMap hashMap=new HashMap();
           hashMap.put("Data",data);
           databaseReference.child("MK3dOdcwSH9tolDmvtM").setValue(hashMap);
           Toast.makeText(this,"Pump is OFF",Toast.LENGTH_SHORT).show();
       }
    }
    public void refresh(){
       databaseReference1=databaseReference.child("connection");
        Map<String,Object>map=new HashMap<>();
        map.put("wifi",0);
        databaseReference1.updateChildren(map);

    }

}