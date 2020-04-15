package edu.isu.capstone.bookrec.android.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import edu.isu.capstone.bookrec.android.BookView;
import edu.isu.capstone.bookrec.android.MainActivity;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.ui.BooksGridAdapter;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //create a root view that can be used to access layout elements on this view.
        //NOTE: "R.layout.fragment_dashboard" will need to be changed depending on which view you are working on.
        //For example, if you were on the notifications fragment, it would be "R.layout.fragment_notifications"
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //Sets Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("My Library");
        //Creates an arraylist of images to be used to fill the grid.
        CreateLibraryImages(root);

        return root;
    }

    //Populates an arraylist of imageviews to be used to populate the library grid
    private void CreateLibraryImages(View root){
        //TODO numBooks will need to reflect how many books are in the user's library
        int numBooksLib = 10;

        ArrayList<ImageView> images = new ArrayList<>();

        for(int i = 0; i < numBooksLib; i++) {
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
            //https://stackoverflow.com/questions/1839273/how-to-apply-click-event-listener-to-image-in-android/1839454
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //https://stackoverflow.com/questions/15478105/start-an-activity-from-a-fragment
                    Intent intent = new Intent(getActivity(), BookView.class);
                    startActivity(intent);
                }
            });
            //populate images array with imageviews
            images.add(img);
        }
        //populate the grid with the images array
        PopulateGrid(root, images);
    }
    //Fills grdLibrary with the images from the arraylist of imageviews.
    private void PopulateGrid(View root, ArrayList<ImageView> images){
        //grab the grid you intend to fill
        GridView grid = root.findViewById(R.id.grdLibrary);
        //Create a BooksGridAdapter to be used on grdLibrary. Fill this adapter with the relevant images.
        BooksGridAdapter adapter = new BooksGridAdapter(getContext(), images);
        //set grdLibrary to use adapter "adapter"
        grid.setAdapter(adapter);
    }
}
