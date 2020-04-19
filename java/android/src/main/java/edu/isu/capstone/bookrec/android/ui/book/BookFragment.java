package edu.isu.capstone.bookrec.android.ui.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.squareup.picasso.Picasso;
import dagger.android.support.DaggerFragment;
import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.databinding.FragmentBookViewBinding;

import javax.inject.Inject;

public class BookFragment extends DaggerFragment {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    BookEventHandler handler;
    @Inject
    Picasso picasso;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BookActivityViewModel viewModel = new ViewModelProvider(this, viewModelFactory).get(BookActivityViewModel.class);
        String bookId = BookFragmentArgs.fromBundle(requireArguments()).getBookId();
        viewModel.setBookId(bookId);

        FragmentBookViewBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_view, container, false);
        binding.setHandler(handler);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);

        View view = binding.getRoot();
        viewModel.getImgUri().observe(getViewLifecycleOwner(), uri -> {
            ImageView imageView = view.findViewById(R.id.imageView);
            picasso.load(uri).placeholder(R.mipmap.ic_launcher).into(imageView);
        });

        return view;
    }
}