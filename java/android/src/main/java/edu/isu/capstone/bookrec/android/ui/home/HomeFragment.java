package edu.isu.capstone.bookrec.android.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.Picasso;
import edu.isu.capstone.bookrec.android.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView img = root.findViewById(R.id.imageView);
        Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);

        return root;
    }
}
