package edu.isu.capstone.bookrec.android.urlfetcher;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

// Reference Docs: https://developer.android.com/training/volley/requestqueue
public class VolleySingleton {
    private static VolleySingleton volleyInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingleton(Context ctx) {
        context = ctx;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context ctx) {
        if (volleyInstance == null) {
            volleyInstance = new VolleySingleton(ctx);
        }
        return volleyInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // According to teh tutorial this is from:
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
