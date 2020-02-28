package edu.isu.capstone.bookrec.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.app.Activity;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import edu.isu.capstone.bookrec.android.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {


    TextView Hyperlink;
    Spanned Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hyperlink = (TextView)findViewById(R.id.txtRegister);
        Text = Html.fromHtml("<a href='https://goodreads.com/register'>Click here to register.");

        Hyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        Hyperlink.setText(Text);
    }

    public void redirectToLogin(View v){
        Intent i = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(i);
    }
}