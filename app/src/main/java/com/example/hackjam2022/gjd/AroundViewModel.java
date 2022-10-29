package com.example.hackjam2022.gjd;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AroundViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AroundViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is around fragment");
    }

    private TextView view;

    public TextView getView(){
        return view;
    }

    public LiveData<String> getText() {
        return mText;
    }
}