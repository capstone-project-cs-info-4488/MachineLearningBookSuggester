package edu.isu.capstone.bookrec.android.data.datasources.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodreadsClient {
    @GET("shelf/list.xml")
    Call<List<Shelves>> getGoodreadsShelves(@Query("user_id") int userId);
}
