package edu.isu.capstone.bookrec.android.data.moshi;

import android.net.Uri;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

public class UriAdapter {
    @FromJson
    Uri uriFromJson(String json) {
        return Uri.parse(json);
    }

    @ToJson
    String uriToJson(Uri uri) {
        return uri.toString();
    }
}
