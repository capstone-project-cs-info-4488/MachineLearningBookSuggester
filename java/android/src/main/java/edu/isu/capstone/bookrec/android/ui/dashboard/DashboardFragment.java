package edu.isu.capstone.bookrec.android.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import edu.isu.capstone.bookrec.android.databinding.FragmentDashboardBinding;
import edu.isu.capstone.bookrec.android.ui.BookPreviewsAdapter;
import edu.isu.capstone.bookrec.android.ui.home.HomeViewModel;

public class DashboardFragment extends DaggerFragment {
    @Inject
    ViewModelProvider.Factory modelFactory;

    @Inject
    Picasso picasso;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //create a root view that can be used to access layout elements on this view.
        //NOTE: "R.layout.fragment_dashboard" will need to be changed depending on which view you are working on.
        //For example, if you were on the notifications fragment, it would be "R.layout.fragment_notifications"
        HomeViewModel viewModel = new ViewModelProvider(this, modelFactory).get(HomeViewModel.class);
        FragmentDashboardBinding binding = FragmentDashboardBinding.inflate(inflater);
        binding.setViewModel(viewModel);
        binding.booksView.setAdapter(new BookPreviewsAdapter(viewModel, picasso));

        return binding.getRoot();
    }
}
