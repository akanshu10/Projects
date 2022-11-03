package com.mbm.myapplication.ui.scholarship;

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

public class ScholarshipFragment extends Fragment {

    private ScholarshipViewModel scholarshipViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        scholarshipViewModel =
                ViewModelProviders.of(this).get(ScholarshipViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scholarship, container, false);
        final TextView textView = root.findViewById(R.id.text_scholarship);
        scholarshipViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
