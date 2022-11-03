package com.mbm.myapplication.ui.contectwith;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContectwithViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContectwithViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is contect fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}