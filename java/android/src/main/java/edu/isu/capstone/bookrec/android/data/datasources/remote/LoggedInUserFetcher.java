package edu.isu.capstone.bookrec.android.data.datasources.remote;

import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;
import org.json.JSONException;
import org.json.JSONObject;

public class LoggedInUserFetcher extends Fetcher<LoggedInUser> {
    public LoggedInUserFetcher(VolleySingleton volley, String url_to_fetch) {
        super(volley, url_to_fetch);
    }

    @Override
    protected LoggedInUser load(JSONObject from) throws JSONException {
        String userId = from.getString("userId");
        String displayName = from.getString("displayName");
        return new LoggedInUser(userId, displayName);
    }
}
