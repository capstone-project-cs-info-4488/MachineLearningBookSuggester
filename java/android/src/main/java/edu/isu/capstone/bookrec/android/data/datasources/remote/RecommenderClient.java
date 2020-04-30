package edu.isu.capstone.bookrec.android.data.datasources.remote;

import java.util.List;

import edu.isu.capstone.bookrec.android.data.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecommenderClient {
    @GET("/user/{userId}/recommend")
    Call<List<Book>> getRecommendedBooks(@Path("userId") int userId);
}
