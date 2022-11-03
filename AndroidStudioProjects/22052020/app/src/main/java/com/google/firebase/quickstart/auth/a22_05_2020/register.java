package com.google.firebase.quickstart.auth.a22_05_2020;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mfullname, muserEmailId, mmobilenumber, mlocation, mpassword, mconfirmpassword,codeenter;
    Button msignup,meotp,mmotp;
    TextView mtext,malreadyuser,mTotp,eTotp,seotp,smotp;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    CountryCodePicker countryCodePicker;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String varificationId;
    PhoneAuthProvider.ForceResendingToken Token;
    Boolean varificationInprogress=false;





    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfullname=findViewById(R.id.fullName);
        muserEmailId=findViewById(R.id.userEmailId);
        meotp=findViewById(R.id.sentotp1);
        mTotp=findViewById(R.id.phoneotp);
        eTotp=findViewById(R.id.emailotp);
        countryCodePicker=findViewById(R.id.ccp);
        mmobilenumber=findViewById(R.id.mobileNumber);
        mmotp=findViewById(R.id.sentotp);
        seotp=findViewById(R.id.emailotpT);
        smotp=findViewById(R.id.phoneotpT);
        mlocation=findViewById(R.id.location);
        mpassword=findViewById(R.id.password);
        codeenter=findViewById(R.id.phoneotp);
        mconfirmpassword=findViewById(R.id.confirmPassword);

        msignup=findViewById(R.id.signUpBtn);
        malreadyuser=findViewById(R.id.already_user);

        mtext=findViewById(R.id.text);
        countryCodePicker=findViewById(R.id.ccp);


        mAuth=FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressBar);

        //if(mAuth.getCurrentUser() !=null) {
        //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
        //finish();

        //}
        malreadyuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        mmotp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!varificationInprogress){
                    if(!mmobilenumber.getText().toString().isEmpty() && mmobilenumber.getText().toString().length()==10){
                        String mnum="+"+countryCodePicker.getSelectedCountryCode()+mmobilenumber.getText().toString();
                        Log.d(TAG,"Onclick: Phone no->"+mnum);
                        progressBar.setVisibility(View.VISIBLE);
                        smotp.setText("Sending OTP...");

                        mmotp.setEnabled(false);
                        smotp.setVisibility(View.VISIBLE);
                        requestOTP(mnum);

                    }else{
                        mmobilenumber.setError("Phone number is not valid");
                    }

                }else {
                    String userOTP=codeenter.getText().toString();
                    if(!userOTP.isEmpty()&& userOTP.length()==6){
                        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(varificationId,userOTP);
                        verifyAuth(credential);

                    }else{
                        codeenter.setError("Valid OTP is required");
                    }
                }
            }
        });
        msignup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final String name=mfullname.getText().toString();
                final String mobile=mmobilenumber.getText().toString();
                final String adss=mlocation.getText().toString();
                final String email = muserEmailId.getText().toString().trim();
                final String motp=mTotp.getText().toString();
                final String eotp=eTotp.getText().toString();
                final String pass = mpassword.getText().toString().trim();
                final String cpass = mconfirmpassword.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    mfullname.setError("Name is reqiured");
                    return;
                }
                if (TextUtils.isEmpty(email))  {
                    muserEmailId.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    mpassword.setError("Password is required");
                    return;
                }

                if (TextUtils.isEmpty(cpass)) {
                    mconfirmpassword.setError("Re-password is required");
                    return;
                }

                if(pass.length()<6){
                    mpassword.setError("Password must be greaer than six charecters");
                    return;
                }
                //if(pass != cpass){
                //  mconfirmpassword.setError("Re-password must be same as password");
                //return;
                //}
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "UserCreate success", Toast.LENGTH_SHORT).show();

                            // Create a new user with a first and last name
                            Map<String, Object> user = new HashMap<>();
                            user.put("Name",name);
                            user.put("Email",email);
                            user.put("Mobile",mobile);
                            user.put("Adress",adss);
                            user.put("password",pass);

// Add a new document with a generated ID
                            db.collection("users")
                                    .add(user)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error adding document", e);
                                        }
                                    });
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });
            }
        });

    }

    private void verifyAuth(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(register.this, "Authentication is successful", Toast.LENGTH_SHORT).show();
                    mmotp.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(register.this, "Authentication is failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//otp verification
    private void requestOTP(String mnum) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mnum, 60L, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                progressBar.setVisibility(View.GONE);
                smotp.setVisibility(View.GONE);
                codeenter.setVisibility(View.VISIBLE);
                        varificationId = s;
                Token = forceResendingToken;
                mmotp.setText("Verify OTP");
                varificationInprogress=true;
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(register.this, "Cannot Create account" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

