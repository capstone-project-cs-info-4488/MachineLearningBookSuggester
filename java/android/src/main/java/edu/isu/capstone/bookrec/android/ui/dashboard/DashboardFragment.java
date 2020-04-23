package edu.isu.capstone.bookrec.android.ui.dashboard;

import android.accounts.AccountManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.ui.BooksGridAdapter;
import edu.isu.capstone.bookrec.android.ui.MainActivity;
import edu.isu.capstone.bookrec.android.ui.TemporaryImagePopulatorTODO;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //create a root view that can be used to access layout elements on this view.
        //NOTE: "R.layout.fragment_dashboard" will need to be changed depending on which view you are working on.
        //For example, if you were on the notifications fragment, it would be "R.layout.fragment_notifications"
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //Sets Title
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setTitle("My Library");
        //Creates an array list of images to be used to fill the grid.
        createLibraryImages(root);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.btnImportGoodreads);
        button.setOnClickListener(this::importGoodreads);
    }

    private void importGoodreads(View view) {
        AccountManager manager = AccountManager.get(view.getContext());
        Bundle options = new Bundle();
        System.out.println("called!");
    }

    //Populates an array list of image views to be used to populate the library grid
    private void createLibraryImages(View root) {
        //TODO numBooks will need to reflect how many books are in the user's library
        int numBooksLib = 10;

        ArrayList<ImageView> images = new ArrayList<>();
        TemporaryImagePopulatorTODO.populateBookImages(getActivity(), images::add, numBooksLib);
        //populate the grid with the images array
        populateGrid(root, images);
    }

    //Fills grdLibrary with the images from the arraylist of imageviews.
    private void populateGrid(View root, ArrayList<ImageView> images) {
        //grab the grid you intend to fill
        GridView grid = root.findViewById(R.id.grdLibrary);
        //Create a BooksGridAdapter to be used on grdLibrary. Fill this adapter with the relevant images.
        BooksGridAdapter adapter = new BooksGridAdapter(getContext(), images);
        //set grdLibrary to use adapter "adapter"
        grid.setAdapter(adapter);
    }
}
