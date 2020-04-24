package edu.isu.capstone.bookrec.android.data.datasources.remote;

import java.util.List;

import edu.isu.capstone.bookrec.android.data.model.Book;
import edu.isu.capstone.bookrec.android.data.model.LoggedInUser;
import edu.isu.capstone.bookrec.android.data.model.Shelf;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodreadsClient {
    @GET("shelf/list.xml")
    Call<List<Shelf>> getGoodreadsShelves(@Query("user_id") int userId);

    //doesn't need a user ID but needs the ID of the book that we want to see
    @GET("book/show/")
    Call<Book> getGoodreadsBook(@Query("bookid") int bookId);

    @GET("/user/show")
    Call<LoggedInUser> getGoodreadsUser(@Query("user_id")int userId);

}
