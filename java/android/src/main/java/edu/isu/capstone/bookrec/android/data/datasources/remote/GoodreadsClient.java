package edu.isu.capstone.bookrec.android.data.datasources.remote;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.isu.capstone.bookrec.android.data.Result;
import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;
import edu.isu.capstone.bookrec.android.data.model.Reviews;
import edu.isu.capstone.bookrec.android.data.model.Shelf;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodreadsClient {
    @GET("shelf/list.xml")
    LiveData<Result<List<Shelf>>> getGoodreadsShelves(@Query("user_id") String userId);

    //doesn't need a user ID but needs the ID of the book that we want to see
    @GET("book/show/")
    LiveData<Result<Book>> getGoodreadsBook(@Query("bookid") int bookId);

    @GET("/user/show")
    LiveData<Result<LoggedInUser>> getGoodreadsUser(@Query("user_id") int userId);

    @GET("/review/list")
    LiveData<Result<Reviews>> getBooks(
            @Query("v") int version,
            @Query("id") String userId
    );
}
