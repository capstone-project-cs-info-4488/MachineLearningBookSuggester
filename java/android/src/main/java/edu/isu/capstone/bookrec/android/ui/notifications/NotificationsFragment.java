package edu.isu.capstone.bookrec.android.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import edu.isu.capstone.bookrec.android.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_recom);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

    });
        return root;
    }

    //Populates the recommendations linear layout with images pulled from URL's
    private void CreateRecImages(View root){
        LinearLayout rec = root.findViewById(R.id.llRecomendations);
        //numBooks will need to reflect how many books are in the user's recommendations
        int numBooksRec = 10;
        for(int i = 0; i < numBooksRec; i++) {
            //create new img then set parameters
            ImageView img = new ImageView(getContext());

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 400);
            lp.setMargins(15, 0, 15, 0);
            img.setLayoutParams(lp);
            img.setMaxHeight(400);
            img.setMaxWidth(300);
            //url to load into image
            //How to change url for each unique book? Load array with urls? Where do you get the urls?
            Picasso.get().load("https://i.imgur.com/aEggkZr.jpg").placeholder(R.mipmap.ic_launcher).into(img);
            //add img to linearlayout
            rec.addView(img);
        }
    }
}
