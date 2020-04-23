package edu.isu.capstone.bookrec.android.data.datasources.remote;

import edu.isu.capstone.bookrec.android.data.model.Book;
import org.json.JSONException;
import org.json.JSONObject;

public class BookFetcher extends Fetcher<Book> {
    public BookFetcher(VolleySingleton volley, String url_to_fetch) {
        super(volley, url_to_fetch);
    }

    protected Book load(JSONObject from) throws JSONException {
        //TODO: Implement based on the return from GoodReads.
        return null;
    }
}
