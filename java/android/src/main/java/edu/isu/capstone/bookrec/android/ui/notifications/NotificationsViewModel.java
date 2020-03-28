package edu.isu.capstone.bookrec.android.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.isu.capstone.bookrec.android.R;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Recommendations");
    }

    public LiveData<String> getText() {
        return mText;
    }
}