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

public class StudentTab extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_student, container, false);
        final Intent intent = new Intent(getContext(), collegeloginActivity.class);
        final Button guardianbtn=root.findViewById(R.id.loginBtnst);
        guardianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        return root;
    }
}
