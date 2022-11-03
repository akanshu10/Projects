package com.akihsna.smartpump2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class registerActivity extends AppCompatActivity {
    EditText phone;
    TextView btn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        phone=findViewById(R.id.phone);
        btn=findViewById(R.id.btn);
        progressBar=findViewById(R.id.progressbar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=phone.getText().toString();
                if(phone.getText().toString().isEmpty()){
                    phone.setError("Please enter Phone number");
                }
                if(phone.getText().toString().length()==10){
                    progressBar.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+91"+number,
                            60,
                            TimeUnit.SECONDS,
                            registerActivity.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    btn.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    btn.setVisibility(View.VISIBLE);
                                    Toast.makeText(registerActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    progressBar.setVisibility(View.GONE);
                                    btn.setVisibility(View.VISIBLE);
                                    Intent intent=new Intent(registerActivity.this,otpverificationActivity.class);
                                    intent.putExtra("number",number);
                                    intent.putExtra("verificationId",verificationId);
                                    startActivity(intent);
                                }
                            }
                    );

                }
                else{
                    phone.setError("Please enter Correct Phone number");
                }

            }
        });
    }
}