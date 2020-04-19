package edu.isu.capstone.bookrec.android.ui.book;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.DaggerAppCompatActivity;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.databinding.ActivityBookViewBinding;

import javax.inject.Inject;

public class BookActivity extends DaggerAppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBookViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_book_view);
        BookActivityViewModel viewModel = new ViewModelProvider(this, viewModelFactory).get(BookActivityViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        Intent intent = getIntent();
        String bookId = intent.getStringExtra("bookId");
        if (bookId == null) {
            throw new IllegalArgumentException("Forgot to pass a bookId");
        }
        viewModel.setBookId(bookId);
    }

    public void btnDownload(View view) {
        goToUrl("https://librivox.org/");
    }

    //https://stackoverflow.com/questions/5026349/how-to-open-a-website-when-a-button-is-clicked-in-android-application
    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}