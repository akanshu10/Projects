package com.mbm.myapplication.ui.termsofservices;

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

public class TermsofservicesFragment extends Fragment {

    private TermsofservicesViewModel termsofservicesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        termsofservicesViewModel =
                ViewModelProviders.of(this).get(TermsofservicesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_termsofservices, container, false);
        final TextView textView = root.findViewById(R.id.text_termsofservices);
        termsofservicesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
