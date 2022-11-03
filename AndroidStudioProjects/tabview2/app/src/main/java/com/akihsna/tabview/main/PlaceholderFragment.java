package com.akihsna.tabview.main;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//
//import com.akihsna.all_login.R;
//
///**
// * A placeholder fragment containing a simple view.
// */
//public class PlaceholderFragment extends Fragment {
//
//    private static final String ARG_SECTION_NUMBER = "section_number";
//
//    private PageViewModel pageViewModel;
//
//    public static PlaceholderFragment newInstance(int index) {
//        PlaceholderFragment fragment = new PlaceholderFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(ARG_SECTION_NUMBER, index);
//        fragment.setArguments(bundle);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
//        int index = 1;
//        if (getArguments() != null) {
//            index = getArguments().getInt(ARG_SECTION_NUMBER);
//        }
//        pageViewModel.setIndex(index);
//    }
//
//    @Override
//    public View onCreateView(
//            @NonNull LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState) {
//
//        View root = inflater.inflate(R.layout.fragment_school, container, false);
//        final TextView textView = root.findViewById(R.id.section_label);
//        //pageViewModel.getText().observe(this, new Observer<String>() {
//          //  @Override
//            //public void onChanged(@Nullable String s) {
//              //  textView.setText(s);
//            //}
//        //});
//        return root;
//    }
//}


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.akihsna.all_login.ParentsTab;
import com.akihsna.all_login.Schooltab;
import com.akihsna.all_login.StudentTab;
import com.akihsna.all_login.Teachertab;
import com.akihsna.all_login.VisitorTab;

class PageAdapter extends FragmentPagerAdapter {
    private int NoOfTabs;

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Schooltab();
            case 1:
                return new StudentTab();
            case 2:
                return new Teachertab();
            case 3:
                return new ParentsTab();
            case 4:
                return new VisitorTab();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }



}
