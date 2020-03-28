package edu.isu.capstone.bookrec.android.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.ui.BooksGridAdapter;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        CreateRecomImages(root);

        return root;
    }
    //Populates an arraylist of imageviews to be used to populate the library grid
    //Written by Tyler N.
    private void CreateRecomImages(View root) {
        //TODO numBooks will need to reflect how many books are in the user's library
        int numBooksLib = 17;

        ArrayList<ImageView> images = new ArrayList<>();

        for (int i = 0; i < numBooksLib; i++) {
            //create new img then set parameters
            ImageView img = new ImageView(getContext());
            //various layout parameters that each image can have set
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 400);
            lp.setMargins(15, 0, 15, 0);
            img.setLayoutParams(lp);
            img.setMaxHeight(400);
            img.setMaxWidth(300);
            //url to load into image
            //TODO How to change url for each unique book? Load array with urls? Where do you get the urls?
            Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);
            //populate images array with imageviews
            images.add(img);
        }
        SetGrid(root,images);
    }
    //Fills the Grid with images from the array list
    //Written based off of Tyler's code for Dashboard/Library
    private void SetGrid(View root, ArrayList<ImageView> images){
        //Gets Grid View
        GridView grd = root.findViewById(R.id.grdRecommendation);
        //Gets the Adapter for setting images
        BooksGridAdapter booksAdapter = new BooksGridAdapter(getContext(), images);
        //Sets the grid with the adapter
        grd.setAdapter(booksAdapter);
    }
}
