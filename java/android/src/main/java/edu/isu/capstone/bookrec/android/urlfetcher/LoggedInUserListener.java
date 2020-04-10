package edu.isu.capstone.bookrec.android.urlfetcher;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public class LoggedInUserListener implements Response.Listener<JSONObject> {
    // TODO: Perhaps make this listener a generic that accepts the type of xData.
    private LoggedInUserData userData = null;

    public LoggedInUserListener(LoggedInUserData data) {
        userData = data;
    }

    @Override
    public void onResponse(JSONObject response) {
        String userId = null;
        String displayName = null;
        Exception e = null;
        try {
            userId = response.getString("userId");
            displayName = response.getString("displayName");
        }
        catch (JSONException ex) {
            e = ex;
        }
        userData.loadData(userId, displayName, e);
    }
}
