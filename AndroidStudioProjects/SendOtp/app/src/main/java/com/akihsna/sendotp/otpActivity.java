package com.akihsna.sendotp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otpActivity  extends AppCompatActivity {
    private String varificationid;
    private FirebaseAuth auth;
    private EditText editText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        auth= FirebaseAuth.getInstance();
        editText=findViewById(R.id.editView);
        String number="+917055215341";
        sendVerificationcode(number);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code =editText.getText().toString().trim();
                Intent intent = new Intent(otpActivity.this, MainActivity.class);
                startActivity(intent);
                verifycode(code);
            }
        });

}
private void verifycode(String code){
    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(varificationid,code);
    signInWithcredential(credential);
}
private void signInWithcredential(PhoneAuthCredential credential) {
    auth.signInWithCredential(credential).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                Intent intent = new Intent(otpActivity.this, MainActivity.class);
                Toast.makeText(otpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Toast.makeText(otpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
}
private void sendVerificationcode(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,mcallback);
}
private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mcallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
    @Override
    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        //super.onCodeSent(s, forceResendingToken);
        varificationid=s;
    }

    //public void onCodeSent(String s,PhoneAuthProvider.ForceResendingToken forceResendingToken){
          //  super.onCodeSent(s,forceResendingToken);
            ///varificationid=s;
        //}
    @Override
    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
        signInWithcredential(phoneAuthCredential);
            String code=phoneAuthCredential.getSmsCode();
            if(code!=null){
                verifycode(code);
            }
    }

    @Override
    public void onVerificationFailed(@NonNull FirebaseException e) {

    }
};
}
