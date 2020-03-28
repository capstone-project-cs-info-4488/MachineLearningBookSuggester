package edu.isu.capstone.bookrec.android.ui;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.isu.capstone.bookrec.android.R;

//referenced from: https://www.raywenderlich.com/995-android-gridview-tutorial
//class used as an adapter to the gridviews. Populates the grids with images.
public class BooksGridAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<ImageView> books;

    //constructor - accepts context and arraylist of imageviews
    public BooksGridAdapter(Context context, ArrayList<ImageView> books) {
        this.mContext = context;
        this.books = books;
    }

    //returns number of books
    @Override
    public int getCount() {
        return books.size();
    }

    //returns item ID
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //returns item in a given position
    @Override
    public Object getItem(int position) {
        return null;
    }

    //Returns view to be placed into the grid.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            //set imageview equal to one of the book images in the books property
            imageView = books.get(position);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        return imageView;
    }

}
