package com.example.hackjam2022;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TicketViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TicketViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ticket fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}