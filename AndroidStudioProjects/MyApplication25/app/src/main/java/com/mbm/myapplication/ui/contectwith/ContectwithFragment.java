package com.mbm.myapplication.ui.contectwith;

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

public class ContectwithFragment extends Fragment {

    private ContectwithViewModel contectwithViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        contectwithViewModel =
                ViewModelProviders.of(this).get(ContectwithViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contectwith, container, false);
        final TextView textView = root.findViewById(R.id.text_contectwith);
        contectwithViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
