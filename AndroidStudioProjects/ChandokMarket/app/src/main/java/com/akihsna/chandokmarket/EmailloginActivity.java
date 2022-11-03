package com.akihsna.chandokmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EmailloginActivity extends AppCompatActivity{
    EditText email,lpass;
    TextView text3,text1,text2,text;
    ProgressBar progressBar;
    private String TAG="EmailloginActivity";
    CheckBox showbox;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emaillogin);
        email=findViewById(R.id.email);
        lpass=findViewById(R.id.password);
        text3=findViewById(R.id.newaccount);
        text1=findViewById(R.id.sentotptext);
        text2=findViewById(R.id.fpassword);
        text=findViewById(R.id.btn);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Please enter email");
                    return;
                }
                if (TextUtils.isEmpty(lpass.getText().toString())) {
                    lpass.setError("Please enter valid password");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                mauth.signInWithEmailAndPassword(email.getText().toString(),lpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                        if(mauth.getCurrentUser().isEmailVerified()){
                            startActivity(new Intent(EmailloginActivity.this,loginhomepageActivity.class));
                            finish();
                        }else{
                            Toast.makeText(EmailloginActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                        }else{
                            Toast.makeText(EmailloginActivity.this,"Please enter correct email or password",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        mauth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressbar);
        showbox = findViewById(R.id.show_hide_password);
        showbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    lpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmailloginActivity.this,forgetpasswordActivity.class));
                /*final EditText resetmail = new EditText(v.getContext());
                AlertDialog.Builder passwordreset = new AlertDialog.Builder(v.getContext());
                passwordreset.setTitle("Reset password");
                passwordreset.setMessage("Enter Your Email To Received Reset Link");
                passwordreset.setView(resetmail);
                if(!resetmail.getText().toString().isEmpty()) {
                    passwordreset.setPositiveButton("Sent link", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String mail = resetmail.getText().toString();
                            mauth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(EmailloginActivity.this, "Reset link sent to your email", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(EmailloginActivity.this, "Error! reset link is not sent to your email", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    });
                }
                else{
                    resetmail.setError("Please enter email Address");
                }
                passwordreset.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordreset.create().show();*/
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EmailsignupActivity.class));
            }
        });
        /*text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EmailloginActivity.this,EmailsignupActivity.class);
                startActivity(intent);
            }
        });*/
    }
    /*public void sendPasswordReset() {
        // [START send_password_reset]
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email.getText().toString();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
        // [END send_password_reset]
    }*/

}