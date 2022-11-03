package com.akihsna.tabview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.akihsna.all_login.college.collegeloginActivity;
import com.google.firebase.firestore.FirebaseFirestore;

public class Schooltab extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public final static String TAG="School/Colleges";

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school, container, false);
        final Button guardianbtn=view.findViewById(R.id.loginBtnn);
        guardianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), collegeloginActivity.class));
            }
        });
        return view;
    }


}
