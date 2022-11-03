package com.mbm.myapplication.ui.holidays;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HolidayViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HolidayViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}