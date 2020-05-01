package edu.isu.capstone.bookrec.android.util;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class BindingUtil {
    @SuppressWarnings({"rawtypes", "unchecked"})
    @BindingAdapter("submitItems")
    public static <T> void submitItems(RecyclerView view, List<T> items) {
        ((ListAdapter) Objects.requireNonNull(view.getAdapter())).submitList(items);
    }
}
