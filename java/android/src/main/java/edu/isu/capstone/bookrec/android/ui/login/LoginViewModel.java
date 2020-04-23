package edu.isu.capstone.bookrec.android.ui.login;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;
import edu.isu.capstone.bookrec.android.data.repositories.LoginRepository;

import static androidx.lifecycle.Transformations.map;
import static androidx.lifecycle.Transformations.switchMap;
import static edu.isu.capstone.bookrec.android.util.LiveDataUtil.combine2;
import static edu.isu.capstone.bookrec.android.util.LiveDataUtil.mapMutable;
import static edu.isu.capstone.bookrec.android.util.LiveDataUtil.mergeFirstInto;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<String> username = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final LiveData<Boolean> usernameError = map(username, u -> !isUserNameValid(u));
    private final LiveData<Boolean> passwordError = map(password, p -> !isPasswordValid(p));
    private final LiveData<Boolean> isValid = combine2(usernameError, passwordError, (u, p) -> !u && !p);
    private final MediatorLiveData<Result<LoggedInUser>> loginResult = new MediatorLiveData<>();
    private final MutableLiveData<Boolean> loggingInUser = mapMutable(loginResult, result -> false);
    private final LiveData<Boolean> loginError = map(loginResult, result -> result instanceof Result.Error);
    private final LiveData<LoggedInUser> loggedIn = switchMap(loginResult, Result::successLiveData);

    private LoginRepository loginRepository;

    @Inject
    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
        username.setValue("");
        password.setValue("");
    }

    LiveData<Boolean> getUsernameError() {
        return usernameError;
    }

    LiveData<Boolean> getPasswordError() {
        return passwordError;
    }

    LiveData<Boolean> getLoginError() {
        return loginError;
    }

    public LiveData<Boolean> getIsValid() {
        return isValid;
    }

    public LiveData<Boolean> getLoggingInUser() {
        return loggingInUser;
    }

    LiveData<LoggedInUser> getLoggedIn() {
        return loggedIn;
    }

    public void login() {
        loggingInUser.setValue(true);
        LiveData<Result<LoggedInUser>> result = loginRepository.login(username.getValue(), password.getValue());
        mergeFirstInto(loginResult, result);
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }
}
