package edu.isu.capstone.bookrec.android.di;

import dagger.Module;
import dagger.Provides;
import edu.isu.capstone.bookrec.android.data.datasources.remote.LoggedInUserFetcher;
import edu.isu.capstone.bookrec.android.data.datasources.remote.VolleySingleton;

@Module
public class VolleyModule {
    @Provides
    LoggedInUserFetcher loggedInUserFetcher(VolleySingleton volley) {
        return new LoggedInUserFetcher(volley, "http://localhost:8080/user");
    }
}
