package edu.isu.capstone.bookrec.android.data.datasources.remote;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Fetcher<T> {
    private final VolleySingleton volley;
    private String url;

    public Fetcher(VolleySingleton volley, String url_to_fetch) {
        this.volley = volley;
        url = url_to_fetch;
    }

    public void fetch(OnLoadAction<T> action) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (JSONObject response) -> {
                    T toFetch = null;
                    JSONException e = null;
                    try {
                        toFetch = load(response);
                    } catch (JSONException jsonException) {
                        e = jsonException;
                    }
                    action.act(toFetch, e);
                }, (VolleyError error) -> {
            //TODO: Implement
        });
    }

    protected abstract T load(JSONObject from) throws JSONException;
}
