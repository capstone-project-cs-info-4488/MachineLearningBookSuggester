package edu.isu.capstone.bookrec.android.ui;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.util.Consumer;
import androidx.navigation.Navigation;
import com.squareup.picasso.Picasso;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.ui.home.HomeFragmentDirections;

public class TemporaryImagePopulatorTODO {
    public static void populateBookImages(Activity activity, Consumer<ImageView> images, int numBooksLib) {
        //TODO numBooks will need to reflect how many books are in the user's library

        for (int i = 0; i < numBooksLib; i++) {
            ImageView img = new ImageView(activity);
            //various layout parameters that each image can have set
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 400);
            lp.setMargins(15, 0, 15, 0);
            img.setLayoutParams(lp);
            img.setMaxHeight(400);
            img.setMaxWidth(300);
            //url to load into image
            //TODO How to change url for each unique book? Load array with urls? Where do you get the urls?
            Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);
            //https://stackoverflow.com/questions/1839273/how-to-apply-click-event-listener-to-image-in-android/1839454
            img.setOnClickListener(v -> {
                //https://stackoverflow.com/questions/15478105/start-an-activity-from-a-fragment
                Navigation.findNavController(v).navigate(HomeFragmentDirections.actionHomeFragmentToBookActivity("1234"));
            });
            //populate images array with image views
            images.accept(img);
        }
    }
}
