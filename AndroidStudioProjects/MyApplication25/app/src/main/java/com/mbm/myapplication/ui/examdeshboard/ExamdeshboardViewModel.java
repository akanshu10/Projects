package com.mbm.myapplication.ui.examdeshboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExamdeshboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExamdeshboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}