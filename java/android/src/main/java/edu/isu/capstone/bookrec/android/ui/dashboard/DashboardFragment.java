package edu.isu.capstone.bookrec.android.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import edu.isu.capstone.bookrec.android.databinding.FragmentDashboardBinding;
import edu.isu.capstone.bookrec.android.ui.BookPreviewsAdapter;
import edu.isu.capstone.bookrec.android.ui.home.HomeViewModel;

import static edu.isu.capstone.bookrec.android.ui.dashboard.DashboardFragmentDirections.actionDashboardFragmentToBookFragment;

public class DashboardFragment extends DaggerFragment {
    @Inject
    ViewModelProvider.Factory modelFactory;

    @Inject
    Picasso picasso;

    private HomeViewModel viewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //create a root view that can be used to access layout elements on this view.
        //NOTE: "R.layout.fragment_dashboard" will need to be changed depending on which view you are working on.
        //For example, if you were on the notifications fragment, it would be "R.layout.fragment_notifications"
        binding = FragmentDashboardBinding.inflate(inflater);
        viewModel = new ViewModelProvider(this, modelFactory).get(HomeViewModel.class);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.booksView.setAdapter(new BookPreviewsAdapter(viewModel, picasso));
        binding.setLifecycleOwner(getViewLifecycleOwner());

        viewModel.getOpenBookEvents().observe(getViewLifecycleOwner(), bookId -> {
            if (bookId.isHandled()) return;
            NavHostFragment.findNavController(this).navigate(actionDashboardFragmentToBookFragment(bookId.getContent()));
        });
    }
}
