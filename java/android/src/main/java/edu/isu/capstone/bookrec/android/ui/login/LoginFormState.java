package edu.isu.capstone.bookrec.android.ui.login;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    @StringRes
    @Nullable
    private Integer usernameError;
    @StringRes
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    LoginFormState(@StringRes @Nullable Integer usernameError, @StringRes @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}
