package com.akihsna.localmarket;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;*/

import java.util.concurrent.TimeUnit;

public class verifyotpActivity extends AppCompatActivity {
    TextView textView,textView1,resend,edit,timer;
    EditText editText,editText1,editText2,editText3,editText4,editText5;
    String number,id,vid;
    ProgressBar progressBar;
    //private FirebaseAuth mAuth;
    private String TAG="verifyotpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyotp);
        textView=findViewById(R.id.phone);
        textView1=findViewById(R.id.btn);
        editText=findViewById(R.id.otp1);
        editText1=findViewById(R.id.otp2);
        editText2=findViewById(R.id.otp3);
        editText3=findViewById(R.id.otp4);
        editText4=findViewById(R.id.otp5);
        editText5=findViewById(R.id.otp6);
        resend=findViewById(R.id.resendotp);
        edit=findViewById(R.id.editphone);
        timer=findViewById(R.id.timer);
        progressBar=findViewById(R.id.progressbar);
        setupotp();
        number=getIntent().getStringExtra("number");
        vid=getIntent().getStringExtra("verificationId");
        textView.setText("+91"+number);
        //mAuth=FirebaseAuth.getInstance();
        CountDownTimer countDownTimer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("Resend OTP in 00:" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                resend.setVisibility(View.VISIBLE);
            }
        };
        countDownTimer.start();
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().isEmpty()
                ||editText1.getText().toString().trim().isEmpty()
                        ||editText2.getText().toString().trim().isEmpty()
                        ||editText3.getText().toString().trim().isEmpty()
                        ||editText4.getText().toString().trim().isEmpty()
                        ||editText5.getText().toString().trim().isEmpty()
                ){
                    Toast.makeText(com.akihsna.localmarket.verifyotpActivity.this,"Please enter OTP",Toast.LENGTH_SHORT).show();
                    return;
                }
                String code=editText.getText().toString()+
                        editText1.getText().toString()+
                        editText2.getText().toString()+
                        editText3.getText().toString()+
                        editText4.getText().toString()+
                        editText5.getText().toString();
                if(vid !=null){
                    progressBar.setVisibility(View.VISIBLE);
                    textView1.setVisibility(View.INVISIBLE);
                    //PhoneAuthCredential credential = PhoneAuthProvider.getCredential(vid, code);
                    //signInWithPhoneAuthCredential(credential);
                }

            }

        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(com.akihsna.localmarket.verifyotpActivity.this,phoneloginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                /*PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+getIntent().getStringExtra("number"),
                        60,
                        TimeUnit.SECONDS,
                        com.akihsna.localmarket.verifyotpActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(com.akihsna.chandokmarket.verifyotpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newverificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                vid=newverificationId;
                                Toast.makeText(com.akihsna.chandokmarket.verifyotpActivity.this,"OTP sent ",Toast.LENGTH_LONG).show();
                            }
                        }
                );*/

            }
        });
    }
    private void setupotp(){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    editText1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    editText2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    editText3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    editText4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    editText5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }      // OnVerificationStateChangedCallbacks

    /*private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        textView1.setVisibility(View.VISIBLE);
                        if (task.isSuccessful()) {
                            startActivity(new Intent(com.akihsna.chandokmarket.verifyotpActivity.this,MainActivity.class));
                            finish();
                            FirebaseUser user = task.getResult().getUser();
                            // ...
                        } else {
                            editText.setText("");
                            editText1.setText("");
                            editText2.setText("");
                            editText3.setText("");
                            editText4.setText("");
                            editText5.setText("");
                            Intent intent=new Intent(com.akihsna.chandokmarket.verifyotpActivity.this, com.akihsna.chandokmarket.verifyotpActivity.class);
                            startActivity(intent);
                            Toast.makeText(com.akihsna.chandokmarket.verifyotpActivity.this,"Invalid otp",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/
}