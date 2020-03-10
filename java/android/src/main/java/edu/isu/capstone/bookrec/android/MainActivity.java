package edu.isu.capstone.bookrec.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        LinearLayout layout = (LinearLayout)findViewById(R.id.llLibrary);

        //for (int i = 0; i <5; i++){
            //ImageView img = new ImageView(this);
//            img.setLayoutParams(new android.view.ViewGroup.LayoutParams());
//            img.setMaxHeight(20);
//            img.setMaxWidth(20);

          //  Picasso.get().load("http://therecipehound.com/css/Logo.png").into(img);
//            URL url = null;
//            try {
//                url = new URL("https://ih0.redbubble.net/image.161080070.3717/flat,750x1000,075,f.jpg");
//                InputStream in = url.openConnection().getInputStream();
//                Bitmap bmp = BitmapFactory.decodeStream(in);
//                img.setImageBitmap(bmp);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

//            layout.addView(img);
        //}
    }

}
