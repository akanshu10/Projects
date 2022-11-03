package com.akihsna.all_login;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Locale;

import static android.provider.Settings.System.getString;

public class PageAdapter extends FragmentPagerAdapter {
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
