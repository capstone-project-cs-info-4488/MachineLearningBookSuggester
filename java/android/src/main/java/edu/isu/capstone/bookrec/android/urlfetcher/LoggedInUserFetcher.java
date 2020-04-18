package edu.isu.capstone.bookrec.android.urlfetcher;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public class LoggedInUserFetcher extends Fetcher<LoggedInUser> {
    private Context context;
    private String url;

    public LoggedInUserFetcher(Context ctx, String url_to_fetch) {
        super(ctx, url_to_fetch);
    }

    protected LoggedInUser load(JSONObject response) throws JSONException {
        String userId = response.getString("userId");
        String displayName = response.getString("displayName");
        return new LoggedInUser(userId, displayName);
    }
}
