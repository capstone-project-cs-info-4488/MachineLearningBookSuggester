package edu.isu.capstone.bookrec.android.data.repositories;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public interface LoginRepository {
    boolean isLoggedIn();

    void logout();

    Result<LoggedInUser> login(String username, String password);
}
