package edu.isu.capstone.bookrec.android.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.Picasso;
import edu.isu.capstone.bookrec.android.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        CreateLibraryImages(root);
        CreateRecImages(root);
        //This is the linear layout for the library scrollview

        //ImageView img = root.findViewById(R.id.imageView);
        //Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);

        return root;
    }

    //Populates the Library Linear Layout with images pulled from URL's
    private void CreateLibraryImages(View root){
        LinearLayout lib = root.findViewById(R.id.llLibrary);
        //numBooks will need to reflect how many books are in the user's library
        int numBooksLib = 10;
        for(int i = 0; i < numBooksLib; i++) {
            //create new img then set parameters
            ImageView img = new ImageView(getContext());

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 400);
            lp.setMargins(15, 0, 15, 0);
            img.setLayoutParams(lp);
            img.setMaxHeight(400);
            img.setMaxWidth(300);
            //url to load into image
            //How to change url for each unique book? Load array with urls? Where do you get the urls?
            Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);
            //add img to linearlayout
            lib.addView(img);
        }
    }
    //Populates the recommendations linear layout with images pulled from URL's
    private void CreateRecImages(View root){
        LinearLayout rec = root.findViewById(R.id.llRecomendations);
        //numBooks will need to reflect how many books are in the user's recommendations
        int numBooksRec = 10;
        for(int i = 0; i < numBooksRec; i++) {
            //create new img then set parameters
            ImageView img = new ImageView(getContext());

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 400);
            lp.setMargins(15, 0, 15, 0);
            img.setLayoutParams(lp);
            img.setMaxHeight(400);
            img.setMaxWidth(300);
            //url to load into image
            //How to change url for each unique book? Load array with urls? Where do you get the urls?
            Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);
            //add img to linearlayout
            rec.addView(img);
        }
    }

}
