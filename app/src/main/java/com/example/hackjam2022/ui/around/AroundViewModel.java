package com.example.hackjam2022.ui.around;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AroundViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AroundViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is around fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}