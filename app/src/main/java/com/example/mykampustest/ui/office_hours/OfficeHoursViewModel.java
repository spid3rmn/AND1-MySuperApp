package com.example.mykampustest.ui.office_hours;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OfficeHoursViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OfficeHoursViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is office hours fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
