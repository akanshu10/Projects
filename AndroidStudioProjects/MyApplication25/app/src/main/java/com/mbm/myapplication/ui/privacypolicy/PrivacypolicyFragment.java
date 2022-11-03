package com.mbm.myapplication.ui.privacypolicy;

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

public class PrivacypolicyFragment extends Fragment {

    private PrivacypolicyViewModel privacypolicyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        privacypolicyViewModel =
                ViewModelProviders.of(this).get(PrivacypolicyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_privacypolicy, container, false);
        final TextView textView = root.findViewById(R.id.text_privacypolicy);
        privacypolicyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
