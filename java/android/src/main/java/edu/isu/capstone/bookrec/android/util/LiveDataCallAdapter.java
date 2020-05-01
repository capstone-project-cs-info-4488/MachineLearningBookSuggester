package edu.isu.capstone.bookrec.android.util;

import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import edu.isu.capstone.bookrec.android.data.Result;
import retrofit2.Call;
import retrofit2.CallAdapter;

import static edu.isu.capstone.bookrec.android.util.LiveDataUtil.liveDataFromCall;

class LiveDataCallAdapter<T> implements CallAdapter<T, LiveData<Result<T>>> {
    private final Type responseType;

    LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @NotNull
    @Override
    public Type responseType() {
        return responseType;
    }

    @NotNull
    @Override
    public LiveData<Result<T>> adapt(@NotNull Call<T> call) {
        return liveDataFromCall(call);
    }
}
