package com.akihsna.all_login.college;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.akihsna.all_login.R;

import com.google.firebase.firestore.FirebaseFirestore;

public class AddstudentActivity extends AppCompatActivity {
    Button nxtbtn;
    EditText fname,fathername,mothername,dob,gendar,catagory,religion,village,post,city,pin,state,mmobile,email;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        nxtbtn=findViewById(R.id.nxtbtn);
        fname=findViewById(R.id.fullnameedit);
        fathername=findViewById(R.id.fathernameedit);
        mothername=findViewById(R.id.mothernameedit);
        dob=findViewById(R.id.dobedit);
        gendar=findViewById(R.id.genderedit);
        catagory=findViewById(R.id.categoryedit);
        religion=findViewById(R.id.religionedit);
        village=findViewById(R.id.villageedit);
        post=findViewById(R.id.postedit);
        city=findViewById(R.id.cityedit);
        pin=findViewById(R.id.pinedit);
        state=findViewById(R.id.stateedit);
        mmobile=findViewById(R.id.Mobileedit);
        email=findViewById(R.id.emailedit);


        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                firebaseDatabase=FirebaseDatabase.getInstance();
//                reference=firebaseDatabase.getReference();
//
//                final String name=fname.getText().toString();
//                final String mobile=mmobile.getText().toString();
//                final String fatername=fathername.getText().toString();
//                final String mname=mothername.getText().toString();
//                final String dofb=dob.getText().toString();
//                final String gndr=gendar.getText().toString();
//                final String catgry=catagory.getText().toString();
//                final String relign=religion.getText().toString();
//
//                final String email1 =email.getText().toString().trim();
//                final String vill=village.getText().toString();
//                final String pst=post.getText().toString();
//                final String cit= city.getText().toString().trim();
//                final String pinc = pin.getText().toString().trim();
//                final String stat = state.getText().toString().trim();
//
//               /* if(TextUtils.isEmpty(name)){
//                    mfullname.setError("Name is reqiured");
//                    return;
//                }
//                if (TextUtils.isEmpty(email))  {
//                    muserEmailId.setError("Email is required");
//                    return;
//                }
//                if (TextUtils.isEmpty(pass)) {
//                    mpassword.setError("Password is required");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(cpass)) {
//                    mconfirmpassword.setError("Re-password is required");
//                    return;
//                }
//
//                if(pass.length()<6){
//                    mpassword.setError("Password must be greaer than six charecters");
//                    return;
//                }
//                //if(pass != cpass){
//                //  mconfirmpassword.setError("Re-password must be same as password");
//                //return;
//                //}*/
//                //progressBar.setVisibility(View.VISIBLE);
//                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(collegeloginActivity.this, "UserCreate success", Toast.LENGTH_SHORT).show();
//
//                            // Create a new user with a first and last name
//                            Map<String, Object> user = new HashMap<>();
//                            user.put("Name",name);
//                            user.put("Email",email);
//                            user.put("Mobile",mobile);
//                            user.put("Adress",adss);
//                            user.put("password",pass);
//
//// Add a new document with a generated ID
//                            firebaseDatabase.collection("users")
//                                    .add(user)
//                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                        @Override
//                                        public void onSuccess(DocumentReference documentReference) {
//                                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                        }
//                                    })
//                                    .addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            Log.w(TAG, "Error adding document", e);
//                                        }
//                                    });
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        } else {
//                            Toast.makeText(register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
//
//                });
//            }
//        });
//
//    }
//

    startActivity(new Intent(getApplicationContext(),addstudentnextActivity.class));

            }
        });
    }
}
