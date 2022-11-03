package com.akihsna.kisaanhelpusmlt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.net.URL;

public class TokenEnquiryActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    TextView totalbuggi,totaltrolly,totaltruck,appowner;
    private DatabaseReference mDatabase1,mDatabase2,mDatabase3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_enquiry);
        btn1=findViewById(R.id.buggidetail);
        btn2=findViewById(R.id.trollydetail);
        btn3=findViewById(R.id.truckdetail);
        totalbuggi=findViewById(R.id.totalbuggieditno);
        totaltrolly=findViewById(R.id.totaltrollyeditno);
        totaltruck=findViewById(R.id.totaltruckedit);
        appowner=findViewById(R.id.owner);
        mDatabase1 = FirebaseDatabase.getInstance().getReference("Token-number/Buggi");
        mDatabase1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("weightedtoken").getValue().toString();
                int inum = Integer.parseInt(name);//current weighted token number
                String current_issue=snapshot.child("issuetoken").getValue().toString();
                int inum2 = Integer.parseInt(current_issue);//issue token number
                int total=inum2-inum;   //total trolly on plateform
                String s=String.valueOf(total);
                totalbuggi.setText(s);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        final String token_no1=getIntent().getStringExtra("tokenkey");
        mDatabase2 = FirebaseDatabase.getInstance().getReference("Token-number/Trolly");
        mDatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("weightedtoken").getValue().toString();
                int inum = Integer.parseInt(name);//current weighted token number
                String current_issue=snapshot.child("issuetoken").getValue().toString();
                int inum2 = Integer.parseInt(current_issue);//issue token number
                int total=inum2-inum;   //total trolly on plateform
                String s=String.valueOf(total);
                totaltrolly.setText(s);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        mDatabase3 = FirebaseDatabase.getInstance().getReference("Token-number/Truck");
        mDatabase3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("weightedtoken").getValue().toString();
                int inum = Integer.parseInt(name);//current weighted token number
                String current_issue=snapshot.child("issuetoken").getValue().toString();
                int inum2 = Integer.parseInt(current_issue);//issue token number
                int total=inum2-inum;   //total trolly on plateform
                String s=String.valueOf(total);
                totaltruck.setText(s);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TokenEnquiryActivity.this,tokenentryActivity1.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TokenEnquiryActivity.this,tokenentryActivity2.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TokenEnquiryActivity.this,tokenentryActivity3.class);
                startActivity(intent);
            }
        });
        appowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotofacebook();
            }
        });
    }

    public void signout(View view) {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(TokenEnquiryActivity.this,"user sign out",Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });
    }
    private  void gotofacebook(){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/r.rajput.526438"));
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Contact) {
            Intent intent = new Intent(TokenEnquiryActivity.this, ContactActivity.class);
            startActivity(intent);
        }
        if(id==R.id.privacypolicy){
            Intent intent = new Intent(TokenEnquiryActivity.this, PolicyActivity.class);
            startActivity(intent);
        }
        if(id==R.id.help){
            Intent intent = new Intent(TokenEnquiryActivity.this, HelpActivity.class);
            startActivity(intent);
        }
        return  true;
    }
}