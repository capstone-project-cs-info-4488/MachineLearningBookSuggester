package edu.isu.capstone.bookrec.android.data.datasources.remote;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;
import org.json.JSONException;
import org.json.JSONObject;

public class LoggedInUserFetcher {
    private final VolleySingleton volley;
    private Context context;
    private String url;

    public LoggedInUserFetcher(VolleySingleton volley, String url_to_fetch) {
        this.volley = volley;
        url = url_to_fetch;
    }

    public void getUser(OnLoadAction<LoggedInUser> action) {
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
