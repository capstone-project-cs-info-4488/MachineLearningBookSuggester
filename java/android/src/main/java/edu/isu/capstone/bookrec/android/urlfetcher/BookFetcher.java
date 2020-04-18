package edu.isu.capstone.bookrec.android.urlfetcher;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import edu.isu.capstone.bookrec.android.data.model.Book;

public class BookFetcher extends Fetcher<Book> {
    public BookFetcher(Context ctx, String url_to_fetch) {
        super(ctx, url_to_fetch);
    }

    protected Book load(JSONObject from) throws JSONException {
        //TODO: Implement based on the return from GoodReads.
        return null;
    }
}
