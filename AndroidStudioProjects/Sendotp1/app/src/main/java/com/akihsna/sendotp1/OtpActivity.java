package com.akihsna.sendotp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    private String phoneNumber;
    String otpid;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        phoneNumber=getIntent().getStringExtra("mobile");
        editText=findViewById(R.id.editTextNumber);
        button=findViewById(R.id.button2);
        mAuth=FirebaseAuth.getInstance();
        initiateotp();
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(editText.getText().toString().isEmpty())
                   Toast.makeText(getApplicationContext(),"blank field can not field",Toast.LENGTH_SHORT).show();
               else if(editText.getText().toString().length()!=6)
                   Toast.makeText(getApplicationContext(),"invalid otp",Toast.LENGTH_SHORT).show();
               else {
                   PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpid,editText.getText().toString());
                   signInWithPhoneAuthCredential(credential);
               }
           }
       });
    }

    private void initiateotp() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
                mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otpid=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                };        // OnVerificationStateChangedCallbacks


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(OtpActivity.this, MainActivity.class));
                            finish();
                        } else {
                            // The verification code entered was invalid
                            Toast.makeText(getApplicationContext(), "code error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
