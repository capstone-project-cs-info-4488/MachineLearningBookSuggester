package edu.isu.capstone.bookrec.android;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;


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
        LinearLayout layout = findViewById(R.id.llLibrary);

//        AsyncTask<Void, Void, Bitmap> retrieveImage = new AsyncTask<Void, Void, Bitmap>() {
//            @Override
//            protected Bitmap doInBackground(Void... voids) {
//                return null;
//            }
//        }

//        for (int i = 0; i <5; i++){
//            ImageView img = new ImageView(this);
//            img.setLayoutParams(new android.view.ViewGroup.LayoutParams(10, 10));
//            img.setMaxHeight(20);
//            img.setMaxWidth(20);
//
//            Picasso.get().load("http://therecipehound.com/css/Logo.png").into(img);
////            URL url = null;
////            try {
////                url = new URL("https://ih0.redbubble.net/image.161080070.3717/flat,750x1000,075,f.jpg");
////                InputStream in = url.openConnection().getInputStream();
////                Bitmap bmp = BitmapFactory.decodeStream(in);
////                img.setImageBitmap(bmp);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//
//            layout.addView(img);
//        }
    }

}
