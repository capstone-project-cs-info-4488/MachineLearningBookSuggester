package edu.isu.capstone.bookrec.android.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.datasources.DummyLoginDataSource;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
@Singleton
public class DefaultLoginRepository implements LoginRepository {
    private DummyLoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    @Inject
    DefaultLoginRepository(DummyLoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isLoggedIn() {
        return user != null;
    }

    @Override
    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    @Override
    public LiveData<Result<LoggedInUser>> login(String username, String password) {
        // handle login
        MutableLiveData<Result<LoggedInUser>> liveData = new MutableLiveData<>();
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        liveData.setValue(result);
        return liveData;
    }
}
