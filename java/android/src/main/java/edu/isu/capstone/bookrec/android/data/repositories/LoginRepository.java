package edu.isu.capstone.bookrec.android.data.repositories;

import androidx.lifecycle.LiveData;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public interface LoginRepository {
    boolean isLoggedIn();

    void logout();

    LiveData<Result<LoggedInUser>> login(String username, String password);
}
