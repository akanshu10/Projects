package com.mbm.myapplication.ui.syllabus;

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

public class SyllabusFragment extends Fragment {

    private SyllabusViewModel syllabusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        syllabusViewModel =
                ViewModelProviders.of(this).get(SyllabusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_syllabus, container, false);
        final TextView textView = root.findViewById(R.id.text_syllabus);
        syllabusViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
