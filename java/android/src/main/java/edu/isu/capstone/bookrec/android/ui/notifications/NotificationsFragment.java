package edu.isu.capstone.bookrec.android.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.ui.BooksGridAdapter;
import edu.isu.capstone.bookrec.android.ui.MainActivity;

import java.util.ArrayList;
import java.util.Objects;

import static edu.isu.capstone.bookrec.android.ui.TemporaryImagePopulatorTODO.populateBookImages;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //Sets Title
        MainActivity activity = (MainActivity) requireActivity();
        ActionBar actionBar = Objects.requireNonNull(activity.getSupportActionBar());
        actionBar.setTitle("My Recommendations");
        //Creates images
        createRecommendedImages(root);

        return root;
    }

    //Populates an array list of image views to be used to populate the library grid
    //Written by Tyler N.
    private void createRecommendedImages(View root) {
        ArrayList<ImageView> images = new ArrayList<>();
        populateBookImages(getActivity(), images::add, 17);
        setGrid(root, images);
    }

    //Fills the Grid with images from the array list
    //Written based off of Tyler's code for Dashboard/Library
    private void setGrid(View root, ArrayList<ImageView> images) {
        //Gets Grid View
        GridView grd = root.findViewById(R.id.grdRecommendation);
        //Gets the Adapter for setting images
        BooksGridAdapter booksAdapter = new BooksGridAdapter(getContext(), images);
        //Sets the grid with the adapter
        grd.setAdapter(booksAdapter);
    }
}
