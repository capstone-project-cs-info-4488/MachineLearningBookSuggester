package edu.isu.capstone.bookrec.android.urlfetcher;

import org.json.JSONException;

public interface OnLoadAction<T> {
    public void act(T on, JSONException readException);
}
