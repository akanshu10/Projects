package com.akihsna.market;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import id.zelory.compressor.Compressor;

public class AddActivity extends AppCompatActivity {
    Toolbar toolbar;
    private TextView choose, upload;
    private EditText categryno;
    private EditText categoryname;
    ImageView categotryimage;
    private Button Addcategory;
    private Uri filePath, filepath1;
    private final int PICK_IMAGE_REQUEST = 71;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FileOutputStream fos;
    private static final String TAG = "PostFragment";
    File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        toolbar = findViewById(R.id.toolbar009);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Category");
        categryno = findViewById(R.id.edituserno);
        categoryname = findViewById(R.id.editcategoryname);
        categotryimage = findViewById(R.id.uploadcategoryicon);
        Addcategory = findViewById(R.id.addbtn);
        firebaseFirestore = FirebaseFirestore.getInstance();
        choose = findViewById(R.id.chooseimage);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });
        categotryimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        Addcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
//
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            CropImage.activity(filePath).setGuidelines(CropImageView.Guidelines.ON)
                    .start(AddActivity.this);

//                try {
//
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
//                   // categotryimage.setImageBitmap(bitmap);
//
//                } catch (IOException e) {
//                    Toast.makeText(AddActivity.this, "error", Toast.LENGTH_SHORT).show();
//                    e.printStackTrace();
//                }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            filepath1 = result.getUri();
            categotryimage.setImageURI(filepath1);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    private boolean categoryExists(int username) {
        FirebaseFirestore fdbRefer = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Categories").document("e-s-m-"+username).get();
        return (fdbRefer != null);
    }


    private void uploadImage() {

        if (filepath1 != null) {
            String categoryno1 = categryno.getText().toString();
            String categoryname1 = categoryname.getText().toString();
            //int no = Integer.parseInt((categryno.getText().toString()));
            //String cname = categoryname.getText().toString();
            if (TextUtils.isEmpty(categoryno1)) {
                categryno.setError("Please fill it");

            }else if (TextUtils.isEmpty(categoryname1)) {
                categoryname.setError("Please fill it");

            }else if(categotryimage.getDrawable()==null){
                Toast.makeText(AddActivity.this, "Something went wrong, please select image once again photos", Toast.LENGTH_SHORT).show();

            }

            else {
                if (categoryExists(Integer.parseInt(categoryno1))) {
                    final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setTitle("Uploading...");
                    progressDialog.show();
                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    StorageReference storageReference = storage.getReference();
                    StorageReference mountainsRef = storageReference.child("categories1/" + categoryno1 + "/" + categoryname1);

                    file = new File(filepath1.getPath());
                    try {
                        Bitmap compressedImage = new Compressor(this)
                                .setMaxHeight(250)
                                .setMaxWidth(250)
                                .setQuality(50)
                                .compressToBitmap(file);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        compressedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        byte[] data1 = baos.toByteArray();
                        UploadTask uploadTask = mountainsRef.putBytes(data1);
                        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            String generatedFilePath = "";

                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                progressDialog.dismiss();
                                StorageReference str = storage.getReference().child("categories1/" + categoryno1 + "/" + categoryname1);
                                str.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        generatedFilePath = uri.toString();
                                        Toast.makeText(AddActivity.this, "Icon Uploaded", Toast.LENGTH_SHORT).show();
                                        if (uploadTask.isSuccessful()) {

                                            Map<String, Object> categorymap = new HashMap<>();
                                            categorymap.put("title", categoryname1);
                                            categorymap.put("index", Integer.parseInt(categoryno1));
                                            categorymap.put("icon", generatedFilePath);


                                            firebaseFirestore.collection("Categories").document("e-s-m-" + categoryno1).set(categorymap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(AddActivity.this, "Category added successfully", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(AddActivity.this, CategoryActivity.class));
                                                    finish();
                                                }

                                            });
                                        }


                                    }
                                });

                                //generatedFilePath=taskSnapshot.toString();
                                //  Uri duri=(Uri)taskSnapshot.toString();
                                //generatedFilePath=duri.toString();
                                // generatedFilePath=storageReference.child("categories1/"+categoryno1+"/"+categoryname1).getDownloadUrl().getResult().toString();


                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(AddActivity.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                        double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                                .getTotalByteCount());
                                        progressDialog.setMessage("Uploaded " + (int) progress + "%");
                                    }

                                });

                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(), "Something went wrong while choosing photos", Toast.LENGTH_SHORT).show();

                    }


                    // Bitmap bitmap = ((BitmapDrawable) categotryimage.getDrawable()).getBitmap();


//            storageReference = storageReference.child("images/"+ UUID.randomUUID().toString());
//            storageReference.putFile(filePath)
                }else {
                    Toast.makeText(AddActivity.this," Index Available",Toast.LENGTH_SHORT).show();
                }
            }

        }
        else{
            Toast.makeText(AddActivity.this,"Please select image once again",Toast.LENGTH_SHORT).show();
        }
    }
}