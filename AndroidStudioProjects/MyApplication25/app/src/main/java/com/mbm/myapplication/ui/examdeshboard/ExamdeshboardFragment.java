package com.mbm.myapplication.ui.examdeshboard;

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

public class ExamdeshboardFragment extends Fragment {

    private ExamdeshboardViewModel examdeshboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        examdeshboardViewModel =
                ViewModelProviders.of(this).get(ExamdeshboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_examdeshboard, container, false);
        final TextView textView = root.findViewById(R.id.text_exam_deshboard);
        examdeshboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
