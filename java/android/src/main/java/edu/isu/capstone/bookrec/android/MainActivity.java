package edu.isu.capstone.bookrec.android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import edu.isu.capstone.bookrec.android.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {


    TextView Hyperlink;
    Spanned Text;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hyperlink = findViewById(R.id.txtRegister);
        Text = Html.fromHtml("<a href='https://goodreads.com/register'>Click here to register.", Html.FROM_HTML_MODE_LEGACY);

        Hyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        Hyperlink.setText(Text);
    }

    public void redirectToLogin(View v){
        Intent i = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(i);
    }
}