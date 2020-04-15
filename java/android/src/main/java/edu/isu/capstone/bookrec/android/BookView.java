package edu.isu.capstone.bookrec.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.isu.capstone.bookrec.android.data.model.Book;

public class BookView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_view);
        ((TextView)findViewById(R.id.txtDescription)).setText("This is a description");
        ((TextView)findViewById(R.id.txtTitle)).setText("This is a title");
        ((TextView)findViewById(R.id.txtAuthor)).setText("Katie Bailey");
        ((TextView)findViewById(R.id.txtYearPublished)).setText("1998");
    }

    public void btnDownload(View view) {
        goToUrl("https://librivox.org/");
    }

    //https://stackoverflow.com/questions/5026349/how-to-open-a-website-when-a-button-is-clicked-in-android-application
    private void goToUrl(String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}