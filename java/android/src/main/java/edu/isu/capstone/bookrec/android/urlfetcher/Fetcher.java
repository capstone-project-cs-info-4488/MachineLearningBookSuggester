package edu.isu.capstone.bookrec.android.urlfetcher;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Fetcher<T> {
    public Fetcher(Context ctx, String url_to_fetch) {
        context = ctx;
        url = url_to_fetch;
    }

    private Context context;
    private String url;

    public void fetch(OnLoadAction<T> action) {
        VolleySingleton volley = VolleySingleton.getInstance(context);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (JSONObject response) -> {
                    T toFetch = null;
                    JSONException e = null;
                    try {
                        toFetch = load(response);
                    }
                    catch (JSONException jsonException) {
                        e = jsonException;
                    }
                    action.act(toFetch, e);
                }, (VolleyError error) -> {
                    //TODO: Implement
        });
    }

    protected abstract T load(JSONObject from) throws JSONException;
}
