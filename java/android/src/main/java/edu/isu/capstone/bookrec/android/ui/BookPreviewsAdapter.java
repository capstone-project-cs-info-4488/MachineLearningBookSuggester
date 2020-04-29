package edu.isu.capstone.bookrec.android.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.databinding.FragmentBookPreviewBinding;


public class BookPreviewsAdapter extends ListAdapter<Book, BookPreviewsAdapter.ViewHolder> {
    public BookPreviewsAdapter(LiveData<List<Book>> books) {
        super(new BookDiff());
    }

    @NonNull
    @Override
    public BookPreviewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BookPreviewsAdapter.ViewHolder holder, int position) {
        Book book = getItem(position);
        holder.bind(book);
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

        ViewHolder(@NonNull FragmentBookPreviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public static ViewHolder create(ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            FragmentBookPreviewBinding binding = FragmentBookPreviewBinding.inflate(inflater, parent, false);
            return new ViewHolder(binding);
        }

        void bind(Book book) {
            binding.setBook(book);
            binding.executePendingBindings();
        }
    }
}

