package com.mbm.myapplication.ui.helpcenter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpcenterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelpcenterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is help fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}