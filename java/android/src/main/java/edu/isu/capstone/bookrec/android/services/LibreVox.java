package edu.isu.capstone.bookrec.android.services;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import edu.isu.capstone.bookrec.android.di.activities.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class LibreVox {
    private final AppCompatActivity activity;

    @Inject
    LibreVox(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void open() {
        Uri uriUrl = Uri.parse("https://librivox.org/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        activity.startActivity(launchBrowser);
    }
}
