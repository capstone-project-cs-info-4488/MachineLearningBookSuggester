package edu.isu.capstone.bookrec.android.urlfetcher;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public class LoggedInUserFetcher {
    private Context context;
    private String url;

    public LoggedInUserFetcher(Context ctx, String url_to_fetch) {
        context = ctx;
        url = url_to_fetch;
    }

    public void getUser(OnLoadAction<LoggedInUser> action) {
        VolleySingleton volley = VolleySingleton.getInstance(context);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (JSONObject response) -> {
                    LoggedInUser user = null;
                    JSONException e = null;
                    try {
                        user = loadJsonUser(response);
                    }
                    catch (JSONException jsonException) {
                        e = jsonException;
                    }
                    action.act(user, e);
                }, (VolleyError error) -> {

                });
    }

    private LoggedInUser loadJsonUser(JSONObject response) throws JSONException {
        String userId = response.getString("userId");
        String displayName = response.getString("displayName");
        return new LoggedInUser(userId, displayName);
    }
}
