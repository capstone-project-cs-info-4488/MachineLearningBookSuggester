package edu.isu.capstone.bookrec.android.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;
import edu.isu.capstone.bookrec.android.databinding.ActivityLoginBinding;
import edu.isu.capstone.bookrec.android.ui.MainActivity;

public class LoginActivity extends DaggerAppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginViewModel loginViewModel = new ViewModelProvider(this, viewModelFactory).get(LoginViewModel.class);

        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        binding.setViewModel(loginViewModel);
        binding.setLifecycleOwner(this);

        setContentView(binding.getRoot());

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);

        loginViewModel.getUsernameError().observe(this, isError ->
                usernameEditText.setError(isError ? getString(R.string.invalid_username) : null)
        );
        loginViewModel.getPasswordError().observe(this, isError ->
                passwordEditText.setError(isError ? getString(R.string.invalid_password) : null)
        );
        loginViewModel.getLoginError().observe(this, isError -> {
            if (isError) showLoginFailed();
        });
        loginViewModel.getLoggedIn().observe(this, user -> {
            updateUiWithUser(user);
            setResult(RESULT_OK);
            finish();
        });
    }

    private void updateUiWithUser(LoggedInUser model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed() {
        Toast.makeText(getApplicationContext(), R.string.login_failed, Toast.LENGTH_SHORT).show();
    }

    //Method used to redirect user to Goodread's register page on their phone's web browser.
    public void btnRegister(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.goodreads.com/user/sign_up"));
        startActivity(browserIntent);
    }


    public void btnMain(View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
