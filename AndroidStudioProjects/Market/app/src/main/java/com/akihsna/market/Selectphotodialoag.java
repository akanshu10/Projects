package com.akihsna.market;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Selectphotodialoag extends DialogFragment {
    private static final String TAG="SelectPhotoDialog";
    private static final int PICKFILE_REQUEST_CODE = 1234;
    private static final int CAMERA_REQUEST_CODE =4321 ;




    public interface OnPhotoselectedListner{
        void getImagePath(Uri imagePath);
        void getImageBitmap(Bitmap bitmap);
    }
    OnPhotoselectedListner onPhotoselectedListner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.upload_image_layout,container,false);

        TextView selectphoto=(TextView)view.findViewById(R.id.chooseimageg);
        selectphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onclick:accessing phone memory");
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,PICKFILE_REQUEST_CODE);
            }
        });
        TextView takephoto=(TextView)view.findViewById(R.id.opencamera);
        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onclick:starting camera");
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST_CODE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICKFILE_REQUEST_CODE && resultCode== Activity.RESULT_OK){
            Uri selectedimguri=data.getData();
            Log.d(TAG,"onActivityResult:image uri"+selectedimguri);

            onPhotoselectedListner.getImagePath(selectedimguri);
            getDialog().dismiss();
        }
        else if(requestCode==CAMERA_REQUEST_CODE && resultCode== Activity.RESULT_OK){
            Log.d(TAG,"onActivityResult:done taking new photo");
            Bitmap bitmap;
            bitmap=(Bitmap)data.getExtras().get("data");
            onPhotoselectedListner.getImageBitmap(bitmap);
            getDialog().dismiss();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        try{
            onPhotoselectedListner=(OnPhotoselectedListner)getActivity();
        }catch (ClassCastException e){
            Log.e(TAG,"onAttach:ClassCastExeption"+e.getMessage());
        }
        super.onAttach(context);
    }
}
