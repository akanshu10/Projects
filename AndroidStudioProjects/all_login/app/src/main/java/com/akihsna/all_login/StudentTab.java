package com.akihsna.all_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.akihsna.all_login.college.AttendanceActivity;
import com.akihsna.all_login.college.collegeloginActivity;

public class StudentTab extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_student, container, false);
        final Button guardianbtn=root.findViewById(R.id.loginBtnst);
        guardianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AttendanceActivity.class));
            }
        });
        return root;
    }
}
