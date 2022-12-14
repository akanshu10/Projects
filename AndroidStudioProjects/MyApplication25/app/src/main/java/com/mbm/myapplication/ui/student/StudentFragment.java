package com.mbm.myapplication.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mbm.myapplication.R;
import com.mbm.myapplication.ui.Teacher.TeacherViewModel;

public class StudentFragment extends Fragment {

    private StudentViewModel studentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        studentViewModel =
                ViewModelProviders.of(this).get(StudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_student, container, false);
        final TextView textView = root.findViewById(R.id.text_student);
        studentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
