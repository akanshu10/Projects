package com.mbm.myapplication.ui.privacypolicy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrivacypolicyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PrivacypolicyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is privacy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}