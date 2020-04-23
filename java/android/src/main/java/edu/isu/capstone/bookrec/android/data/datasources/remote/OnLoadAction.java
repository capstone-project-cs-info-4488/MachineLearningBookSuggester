package edu.isu.capstone.bookrec.android.data.datasources.remote;

import org.json.JSONException;

public interface OnLoadAction<T> {
    void act(T on, JSONException readException);
}
