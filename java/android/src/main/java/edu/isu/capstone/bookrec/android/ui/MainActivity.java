package edu.isu.capstone.bookrec.android.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.data.repositories.LoginRepository;
import edu.isu.capstone.bookrec.android.ui.login.LoginActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    LoginRepository loggedIn;

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!loggedIn.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.my_toolbar));
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.homeFragment, R.id.dashboardFragment, R.id.notificationsFragment)
                .build();
//         Passing each menu ID as a set of Ids because each
//         menu should be considered as top level destinations.
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(
                Navigation.findNavController(this, R.id.nav_host_fragment),
                appBarConfiguration
        ) || super.onSupportNavigateUp();
    }
}
