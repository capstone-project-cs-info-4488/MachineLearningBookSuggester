package edu.isu.capstone.bookrec.android.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import edu.isu.capstone.bookrec.android.R;
import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.databinding.FragmentBookPreviewBinding;
import edu.isu.capstone.bookrec.android.ui.home.HomeViewModel;


public class BookPreviewsAdapter extends ListAdapter<Book, BookPreviewsAdapter.ViewHolder> {
    private final HomeViewModel viewModel;
    private final Picasso picasso;

    public BookPreviewsAdapter(HomeViewModel viewModel, Picasso picasso) {
        super(new BookDiff());
        this.viewModel = viewModel;
        this.picasso = picasso;
    }

    @NonNull
    @Override
    public BookPreviewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.create(parent, picasso);
    }

    @Override
    public void onBindViewHolder(@NonNull BookPreviewsAdapter.ViewHolder holder, int position) {
        Book book = getItem(position);
        holder.bind(book, viewModel);
    }

    private static class BookDiff extends DiffUtil.ItemCallback<Book> {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.getBookId().equals(newItem.getBookId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.equals(newItem);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentBookPreviewBinding binding;
        private final Picasso picasso;

        ViewHolder(@NonNull FragmentBookPreviewBinding binding, Picasso picasso) {
            super(binding.getRoot());
            this.binding = binding;
            this.picasso = picasso;
        }

        public static ViewHolder create(ViewGroup parent, Picasso picasso) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            FragmentBookPreviewBinding binding = FragmentBookPreviewBinding.inflate(inflater, parent, false);
            return new ViewHolder(binding, picasso);
        }

        void bind(Book book, HomeViewModel viewModel) {
            binding.setBook(book);
            binding.setViewModel(viewModel);
            picasso.load(book.getImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .into((ImageView) binding.getRoot().findViewById(R.id.book_preview_img));
            binding.executePendingBindings();
        }
    }
}

