package com.google.firebase.quickstart.auth.a22_05_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText memail, mpass, lpass;
    Button mloginbtn;
    ProgressBar progressBar;
    FirebaseAuth mauth;
    TextView mcreateaccount, forgettextlink;
    CheckBox showbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        mcreateaccount = findViewById(R.id.createAccount);
        memail = findViewById(R.id.userEmailId);
        mpass = findViewById(R.id.password);
        mloginbtn = findViewById(R.id.loginBtn);
        progressBar = findViewById(R.id.progressBar);
        mauth = FirebaseAuth.getInstance();
        forgettextlink = findViewById(R.id.forgot_password);
        showbox = findViewById(R.id.show_hide_password);
        lpass = findViewById(R.id.login_password);

        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.usertype,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




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

        forgettextlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetmail = new EditText(v.getContext());
                AlertDialog.Builder passwordreset = new AlertDialog.Builder(v.getContext());
                passwordreset.setTitle("Reset password");
                passwordreset.setMessage("Enter Your Email To Received Reset Link");
                passwordreset.setView(resetmail);

                passwordreset.setPositiveButton("Sent link", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mail = resetmail.getText().toString();
                        mauth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Reset link sent to your email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Error! reset link is not sent to your email", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                passwordreset.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordreset.create().show();
            }
        });
        //some code write here



        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), VisitorNevigation.class));
                /*String email = memail.getText().toString();
                String pass = mpass.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    memail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    mpass.setError("Password is required");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mauth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), VisitorNevigation.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }


                });*/
            }
        });

        mcreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
