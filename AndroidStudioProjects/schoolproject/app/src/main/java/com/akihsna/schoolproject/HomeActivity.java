package com.akihsna.schoolproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


//    EditText memail, mpass, lpass;
//    Button mloginbtn;
//    ProgressBar progressBar;
//    TextView mcreateaccount, forgettextlink;
//    CheckBox showbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        mcreateaccount = findViewById(R.id.createAccount);
//        mloginbtn = findViewById(R.id.loginBtn);
//        forgettextlink = findViewById(R.id.forgot_password);
//        showbox = findViewById(R.id.show_hide_password);
//        lpass = findViewById(R.id.login_password);
//
//        Spinner spinner = findViewById(R.id.spinner2);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        //spinner.setOnItemSelectedListener(this);
//
//
//        showbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    lpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                } else {
//                    lpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });
//
//        forgettextlink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final EditText resetmail = new EditText(v.getContext());
//                AlertDialog.Builder passwordreset = new AlertDialog.Builder(v.getContext());
//                passwordreset.setTitle("Reset password");
//                passwordreset.setMessage("Enter Your Email To Received Reset Link");
//                passwordreset.setView(resetmail);
//
//            }
//        });
//    }
}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}