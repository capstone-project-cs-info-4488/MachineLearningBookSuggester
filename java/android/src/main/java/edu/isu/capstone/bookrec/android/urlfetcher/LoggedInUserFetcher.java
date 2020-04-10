package edu.isu.capstone.bookrec.android.urlfetcher;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;

public class LoggedInUserFetcher {
    private Context context;
    private String url;

    public LoggedInUserFetcher(Context ctx, String url_to_fetch) {
        context = ctx;
        url = url_to_fetch;
    }

    public LoggedInUser getUser() {
        VolleySingleton volley = VolleySingleton.getInstance(context);

        LoggedInUserData data = new LoggedInUserData();
        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new LoggedInUserListener(data), new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO: Handle exception
                    }
                });

        LoggedInUser user = null;
        boolean wait = true;
        while (wait) {
            try {
                user = data.getUser();
                wait = false;
            }
            catch (Exception e) {
                //TODO: Handle exception
            }
        }
        return user;
    }
}
