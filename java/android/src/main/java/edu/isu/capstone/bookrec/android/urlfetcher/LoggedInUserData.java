package edu.isu.capstone.bookrec.android.urlfetcher;

import org.json.JSONException;

import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public class LoggedInUserData {
    private boolean ready = false;
    private String userId;
    private String displayName;
    private JSONException e;

    public LoggedInUser getUser() throws RuntimeException, JSONException {
        if (!ready) {
            throw new RuntimeException("The user data has not yet been set.");
        }
        //TODO: Specify the exception types e can be.
        if (e != null) {
            throw e;
        }
        return new LoggedInUser(userId, displayName);
    }

    public void loadData(String uId, String dName, JSONException ex) {
        userId = uId;
        displayName = dName;
        e = ex;
        ready = true;
    }
}
