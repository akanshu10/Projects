package com.mbm.myapplication.ui.termsofservices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TermsofservicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TermsofservicesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Terms fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}