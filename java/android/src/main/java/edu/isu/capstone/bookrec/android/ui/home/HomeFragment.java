package edu.isu.capstone.bookrec.android.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.ui.TemporaryImagePopulatorTODO;

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
        TemporaryImagePopulatorTODO.populateBookImages(getActivity(), lib::addView, numBooksLib);
    }
    //Populates the recommendations linear layout with images pulled from URL's
    private void CreateRecImages(View root){
        LinearLayout rec = root.findViewById(R.id.llRecomendations);
        //numBooks will need to reflect how many books are in the user's recommendations
        int numBooksRec = 10;
        TemporaryImagePopulatorTODO.populateBookImages(getActivity(), rec::addView, numBooksRec);
    }

}
